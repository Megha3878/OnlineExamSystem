package com.csmtech.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csmtech.model.User;
import com.csmtech.service.UserService;

@Controller
 @RequestMapping("exam") 
public class ProctorController {
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private UserService userService;

	@GetMapping("/forgetPassword")
	public String forgetPassword(Model model) {
		
		 User user=(User)this.httpSession.getAttribute("sessionData");
		  model.addAttribute("username",user.getName());
		 
		
		System.out.println("get............");
		return "proctor/proctorResetPassword";
		
	}
	
	@PostMapping("/changepassword")
	public String changePassword(@RequestParam("newpassword") String newPassword,@RequestParam("cpassword") String cpassword,Model model,@RequestParam(value="userid" , required = false) Integer userid ) {
	
		User user=(User)this.httpSession.getAttribute("sessionData");
		  model.addAttribute("username",user.getName());
		  model.addAttribute("userid",user.getUserId());
		
		//User userchnage = new User();
		if(newPassword.equals(cpassword))
		{
			if(userid!=null)
				user.setPassword(cpassword);
			userService.saveDetailsOfUser(user);
			
			
		}
		else {
			model.addAttribute("msg","Entered password is wrong..!! ");
			System.out.println("error");
		}
		
		return "proctor/proctorResetPassword";
	}
	
	@GetMapping("/manageProfile")
	public String getmanageProfile(Model model) {
		
		User user=(User)this.httpSession.getAttribute("sessionData");
		  model.addAttribute("username",user.getName());
		return "ProctorManageProfile";
	}
}
