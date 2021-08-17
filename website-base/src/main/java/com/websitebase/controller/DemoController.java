package com.websitebase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	// this function shows the home/landing page
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
}
