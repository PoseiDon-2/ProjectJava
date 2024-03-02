package com.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.model.diaryRepository;
import com.project.model.diary;


@Controller
public class homeController {
	

	@Autowired
	diaryRepository repof;


	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/diary")
	public String diary(Model model) {
		List<diary> d = repof.showall();
		model.addAttribute("listDiary",d);
		return "diary";
	}
	
}
