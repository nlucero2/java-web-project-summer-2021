package com.websitebase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		System.out.println("\n\n********** showMyLoginPage() method **********\n\n");
		
		return "login-page";
	}
	
	
	// this function shows the home/landing page
	@GetMapping("/")
	public String showHome() {
		
		System.out.println("\n\n********** showHome() method **********\n\n");

		return "home";
	}
	
	
	// this function shows the home/landing page
	@GetMapping("/login-page")
	public String showLoginpage() {
		
		System.out.println("\n\n********** showLoginpage() method **********\n\n");
		
		return "login-page";
	}
	
	
	// this function shows the home/landing page
	@GetMapping("/list-of-contact-info")
	public String listOfContactInfo() {
		
		System.out.println("\n\n********** listOfContactInfo() method **********\n\n");
		
		return "list-of-contact-info";
	}
	
	
	// this function is just in case the user gets to a page that they don't have access to
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		System.out.println("\n\n********** showAccessDenied() method **********\n\n");
		
		return "access-denied";
	}
	
	
	// this function logs out by invalidating the HTTP Session and then shows the home/landing page
//	@GetMapping("/logout")
//	public String logoutRedirectToHome() {
//		
//		System.out.println("\n\n********** logoutRedirectToHome() method **********\n\n");
//		
//		return "home";
//	}
	
}
