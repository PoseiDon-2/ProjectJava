package com.project.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.model.diary;

@Controller
public class randomController {
	
	@GetMapping("/random")
	public String home() {
		return "random";
	}

}
