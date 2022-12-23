package com.vtl.spring.security.basic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuthController {
	
	
	@GetMapping("/hello")
	public String githubhello(@AuthenticationPrincipal OAuth2User principal, Model model, HttpServletRequest request) {
		model.addAttribute("name", principal.getAttribute("name"));
		return "hello";
	}
	@GetMapping("/greetings")
	public String greeting(@AuthenticationPrincipal OAuth2User principal, Model model) {
		model.addAttribute("name", principal.getAttribute("name"));
		return "greetings";
	}
	
	
	
}
