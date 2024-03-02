package com.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/diary")
	public String diary() {
		
		return "diary";
	}
	
}
