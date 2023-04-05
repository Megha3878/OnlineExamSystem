package com.csmtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csmtech.model.Role;
import com.csmtech.model.User;
import com.csmtech.service.CandidateService;
import com.csmtech.service.UserService;

@Controller
@RequestMapping("exam")
public class HrController {

	@Autowired
	public UserService userService;
	
	@Autowired
	public CandidateService candidateService;

	@GetMapping("/hrDashboard")
	public String getHrDashboard() {
		
		return "hr/hrDashboard";
	}

	@GetMapping("/hrmanageProfile")
	public String manageHrProfile(Model model) {
		System.out.println("inside hr manage");
		model.addAttribute("allCandidate", candidateService.findAllCandidate());
		return "hr/manageProfile";
	}

	@PostMapping(path = "/updateHr")
	public String editHr(@ModelAttribute() User user, @RequestParam(name = "userId", required = false) Integer userId,
			Model model) {
		Role role = new Role();
		User u = userService.findUserDetailsById(userId);

		System.out.println("ROLE:" + u.getRole());
		System.out.println("ID::" + userService.findUserDetailsById(userId));
		if (user.getPassword() == null && user.getRole() == null) {
			System.out.println("password is null::");
			user.setPassword("@" + user.getUsername() + "#");
			user.setRole(u.getRole());
			userService.saveDetailsOfUser(user);
		} else
			model.addAttribute("msg", "plzz.... fill the form");
		return "hr/hrDashboard";
	}

	@GetMapping(path = "/forgotPassword")
	public String forgotPassword() {
		return "hr/hrResetPassword";
	}
	
	@GetMapping(path = "/viewResult")
	public String viewResult() {
		return "hr/viewResult";
	}

}
