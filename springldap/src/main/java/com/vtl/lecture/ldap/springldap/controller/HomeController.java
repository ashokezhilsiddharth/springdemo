package com.vtl.lecture.ldap.springldap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	

	
	
	
	
	@PostMapping("/unsecuregreetings")
	public String unsecureGreetings(@RequestParam(name="userName", required=false, defaultValue="World") String name, Model model)  {
		model.addAttribute("name", name);
		return "unsecuregreetings";
	}
	

}