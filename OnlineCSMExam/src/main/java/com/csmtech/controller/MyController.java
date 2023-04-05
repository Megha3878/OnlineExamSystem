package com.csmtech.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.csmtech.model.Candidate;
import com.csmtech.model.Role;
import com.csmtech.model.User;
import com.csmtech.service.CandidateService;
import com.csmtech.service.RoleService;
import com.csmtech.service.UserService;

@Controller
@RequestMapping("/exam")
public class MyController {
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private CandidateService candService;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String getLoginPage(Model model) {
		System.out.println("getting......");
		
		return "pageLogin";

	}
	
	@GetMapping("/logout")
	public String getLogout() {
		return "redirect:./login";
	}

	@PostMapping("/loginHere")
	public String loginAdminHere(@RequestParam String username, @RequestParam String password, Model model) {
		boolean flag = true;
		System.out.println("+++++" + username);
		System.out.println(password);

		User user = userService.findUserByUsernameAndPasswordForCheck(username, password);
		flag = userService.findUserByUsernameAndPassword(username, password);
		if (flag) {
			int roleid = userService.findRoleIdByUsernameAndPassword(username, password);
			Role role = roleService.findById(roleid);
			System.out.println(roleid);
			String roleName = role.getRoleName();
			httpSession.setAttribute("sessionData", user);
			if("Admin".equalsIgnoreCase(roleName))
			{
				
				model.addAttribute("username",user.getName());
				return "admin/adminDashboard";
			}
			else if("Proctor".equalsIgnoreCase(roleName)) {
				model.addAttribute("username",user.getName());
				return "proctor/proctorDashboard";
			}
			else {
				model.addAttribute("username",user.getName());
				return "hr/hrDashboard";
			}
				
			
		}
		
		else {
			Candidate cand = candService.findCandidateByCandnameAndPassword(username,password);
			System.out.println("+++++++++++++++"+cand);
			if(cand!=null) {
				return "candidate/candidateDashboard";
			}
			
		}
		
		model.addAttribute("msg","invalid username and password!!");
		return "pageLogin";
	}
	
	/*
	 * @PostMapping("getCandidateById")
	 * 
	 * @ResponseBody public Candidate getCandidate(Integer candid) {
	 * System.out.println("getting+++++++++++++++"+candService.findDetailsById(
	 * candid));
	 * 
	 * return candService.findDetailsById(candid); }
	 */

	@GetMapping("/addCandidate")
	public String addCandPage(Model model) {
		
		User user=(User)this.httpSession.getAttribute("sessionData");
		model.addAttribute("username",user.getName());
		model.addAttribute("allCandidate",candService.findAllCandidate());
		model.addAttribute("key1", "active");
		return "admin/addCandidate";
		
	}
	
	@PostMapping("/saveCandidateDetails")
	public String addCandidate(@RequestParam(value="candid" , required = false) Integer candid,
			@RequestParam("candname") String candName,
			@RequestParam("candusername") String candUserName,
			@RequestParam("candidateemail") String candEmail,
			@RequestParam("candMobile") String candMobile,
			@RequestParam("canddob") String dateOfBirth,
			@RequestParam("dateexam") String dateOfExam,
			@RequestParam("address") String address,
			RedirectAttributes ra) throws Exception {
		
		
		
		Candidate candidate = new Candidate();
		if(candid != null) 
		candidate.setCandid(candid);
		candidate.setCandname(candName);
		candidate.setCandusername(candUserName);
		candidate.setCandpassword(candUserName+"@#");
		candidate.setCandidateemail(candEmail);
		candidate.setCandMobile(candMobile);
		candidate.setCanddob(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth));
		candidate.setDateexam(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfExam));
		candidate.setAddress(address);
		candidate.setIsdelete("No");
		candidate.setStatus("0");
		candService.saveCandidate(candidate);
		System.out.println(candidate);
		
		return "redirect:./addCandidate";
		
	}
	
	@GetMapping("/deleteCandidate")
    public String deleteCandidateById(@RequestParam("candid") Integer candid) {
	
		candService.deleteCandidateById(candid);
	return "redirect:./addCandidate";
     }
	
	@GetMapping("/updateCandidate")
	public String updateStudentForm(Model model,@RequestParam("candid") Integer candid) {
		System.out.println(candid);
		System.out.println(candService.updateCandidateById(candid));
		model.addAttribute("cand",candService.updateCandidateById(candid));
		model.addAttribute("key2","active");
		model.addAttribute("key1", "disabled");
		
		return "forward:/exam/addCandidate";
	}
	
	@GetMapping("/manageUsers")
	public String manageUser(Model model) {
		
		model.addAttribute("allUser",userService.getAllUser());
		
		return "admin/userManage";

	}
	
	@PostMapping("getUserById")
	@ResponseBody
	public User getUser(Integer userId) {
		System.out.println("getting+++++++++++++++"+userService.findUserDetailsById(userId));
		return userService.findUserDetailsById(userId);
	}
	
	@PostMapping("/saveUserDetails")
	public String addUser(@RequestParam(value="userId" , required = false) Integer userId,
			@RequestParam("name") String name,
			@RequestParam("username") String userName,
			@RequestParam("email") String email,
			@RequestParam("mobileNo") String mobileNo,
			@RequestParam("gender") String gender,
			@RequestParam("userAddress") String address,
			@RequestParam("role") Role userRole,
			RedirectAttributes ra) throws Exception {
		
		
		
		User user = new User();
		if(userId != null) 
			user.setUserId(userId);
		user.setName(name);
		user.setUsername(userName);
		user.setPassword(userName+"@#");
		user.setEmail(email);
		user.setMobileNo(mobileNo);
		user.setGender(gender);
		user.setUserAddress(address);
		user.setRole(userRole);
		user.setIsDelete("No");
		user.setStatus("0");
		userService.saveDetailsOfUser(user);
		System.out.println("+++++++++++++++++++++"+user);
		
		return "redirect:./manageUsers";
		
	}
	
	@GetMapping("/deleteUser")
    public String deleteUserById(@RequestParam("userId") Integer userId) {
	
		userService.deleteUserById(userId);
	return "redirect:./manageUsers";
     }
	
	
	
}
