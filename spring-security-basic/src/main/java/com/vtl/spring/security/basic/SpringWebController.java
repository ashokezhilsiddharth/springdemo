package com.vtl.spring.security.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringWebController {
	
	@PostMapping("/greetings")
	public String greeting(@RequestParam(name="userName", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greetings";
	}


}
