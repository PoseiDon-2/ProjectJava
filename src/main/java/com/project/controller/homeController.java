package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.model.diaryRepository;
import com.project.model.diary;

import com.project.model.listConRepo;
import com.project.model.listContent;


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
	
	@Autowired
	listConRepo lrepo;
	
	@GetMapping("/listContent")
	public String showListContent(Model model) {
	    List<listContent> listContents = lrepo.showallOrderByTargetDateTimeAsc(); // Fetch entries in ascending order of targetDateTime

	    model.addAttribute("listContent", listContents);
	    return "listContent";
	}
	
}
	

