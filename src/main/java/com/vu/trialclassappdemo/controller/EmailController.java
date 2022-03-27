package com.vu.trialclassappdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vu.trialclassappdemo.form.EmailForm;
import com.vu.trialclassappdemo.service.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	@GetMapping("/")
	public String getHome(Model model) {
		EmailForm newEmailForm = new EmailForm();
		model.addAttribute("emailForm", newEmailForm);
		return "index";
	}
	
	@PostMapping("/send")
	public String sendEmail(@ModelAttribute("emailForm") EmailForm emailForm) {
		emailService.sendEmail(emailForm);
		return "success";
	}
}
