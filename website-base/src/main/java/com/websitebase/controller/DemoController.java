package com.websitebase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websitebase.entity.ContactInfo;
import com.websitebase.service.ContactInfoServiceInterface;
import com.websitebase.utility.SortingUtility;

@Controller
public class DemoController {
	
	// inject CustomerService
	@Autowired
	ContactInfoServiceInterface contactInfoService;
		
	

	// this function shows the home/landing page
	@GetMapping("/")
	public String showHome() {
		
		System.out.println("\n********** showHome() method **********\n");
		
		return "home";
	}
	
	
	
	// this function shows the login page page
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		System.out.println("\n********** showMyLoginPage() method **********\n");
		
		return "login-page";
	}
	
	
	
		// ??? NOT NEEDED ???
//	// this function shows the login page page
//	@GetMapping("/login-page")
//	public String showLoginpage() {
//		
//		System.out.println("\n********** showLoginpage() method **********\n");
//		
//		return "login-page";
//	}
	
	
	
	// this function shows the list of contact information page
	@GetMapping("/list-of-contact-info")
	public String listOfContactInfo(Model theModel, @RequestParam(required = false) String sortingString) {
		
		System.out.println("\n********** listOfContactInfo(Model theModel, @RequestParam(required = false) String sortingString) method **********\n");
		
		// create a list to hold the contact info
		List<ContactInfo> theContactInfoList = null;
		
		// verify the sortingString isn't null
		if (sortingString != null) {
			
			int theSortField = Integer.parseInt(sortingString);
			theContactInfoList = contactInfoService.getAllContactInfo(theSortField);
			
		} else {
			
			theContactInfoList = contactInfoService.getAllContactInfo(SortingUtility.LAST_NAME);
			
		}
		
		// add theContactInfoList to the model
		theModel.addAttribute("contactInfos", theContactInfoList);
		
		return "list-of-contact-info";
	}
	
	// ??? NOT NEEDED ???
//	// this is the original function that shows the list of contact information page *without sorting*
//	@GetMapping("/list-of-contact-info")
//	public String listOfContactInfo(Model theModel) {
//		
//		System.out.println("\n********** listOfContactInfo() method **********\n");
//		
//		// use the customer service to retrieve the contact info from the database
//		List<ContactInfo> theContactInfoList = contactInfoService.getAllContactInfo();
//		
//		
//		theModel.addAttribute("contactInfos", theContactInfoList);
//				
//		return "list-of-contact-info";
//	}
	
	
	
	// this function returns the form for users to input their contact info.
	// this is accessed from the "Submit a Request For Info" button on the home page
	@GetMapping("/addContactInfo")
	public String addContactInfo(Model theModel) {
		
		System.out.println("\n********** addContactInfo(Model theModel) method **********\n");
		
		// create a model attribute to bind the form data to
		ContactInfo theContactInfo = new ContactInfo();
		
		theModel.addAttribute("contactInfo", theContactInfo);
		
		return "add-contact-info-page";
	}
	
	
	
	// this function adds a ContactInfo entry to the database using the contactInfoService
	// this is accessed from the "Save" button on add-contact-info-page 
	@PostMapping("/saveContactInfo")
	public String saveContactInfo(@ModelAttribute("contactInfo") ContactInfo theContactInfo) {
		
		System.out.println("\n********** saveContactInfo(@ModelAttribute(\"contactInfo\") ContactInfo theContactInfo) method **********\n");
		
		// save the ContactInfo using the contactInfoService
		contactInfoService.saveContactInfo(theContactInfo);
		
		return "redirect:/";
	}
	
	
	
	// this function deletes a ContactInfo entry from the database using the contactInfoService
	@GetMapping("/delete")
	public String deleteContactInfo(@RequestParam("contactInfoId") int theId) {
		
		contactInfoService.deleteContactInfo(theId);
		
		return "redirect:/list-of-contact-info";
	}
	
	
	
	// this function searches the contact info database for a specific contact info based on the name entered
	@GetMapping("/search")
	public String searchContactInfo(Model theModel, @RequestParam("theSearchName") String theSearchName) {
		
		System.out.println("\n********** searchContactInfo(Model theModel, @RequestParam(\"theSearchName\") String theSearchName) method **********\n");
		
		// use the customer service to retrieve the contact info from the database
		List<ContactInfo> theContactInfoList = contactInfoService.searchContactInfo(theSearchName);
		
		theModel.addAttribute("contactInfos", theContactInfoList);

		return "list-of-contact-info";
	}
	
	
	
	// this function is just in case the user gets to a page that they don't have access to
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		System.out.println("\n********** showAccessDenied() method **********\n");
		
		return "access-denied";
	}
	
	
	
	// ??? NOT NEEDED ???
	// this function logs out by invalidating the HTTP Session and then shows the home/landing page
//	@PostMapping("/logout")
//	public String logoutRedirectToHome() {
//		
//		System.out.println("\n\n********** logoutRedirectToHome() method **********\n\n");
//		
//		return "home";
//	}
	
}
