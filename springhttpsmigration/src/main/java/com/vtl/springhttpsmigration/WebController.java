package com.vtl.springhttpsmigration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@PostMapping("/greetings")
	public String greet(@RequestParam String userName, Model model) {
		model.addAttribute("name", userName);
		return "greetings";
	}
}
