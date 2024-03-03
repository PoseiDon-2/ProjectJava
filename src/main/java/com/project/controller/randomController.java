package com.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.diary;
import com.project.model.diaryRepository;
import com.project.model.RandomModel;

@Controller
public class randomController {
	
	@Autowired
	diaryRepository repof;
	
	private List<String> foodList = new ArrayList<>();
	
	
	@GetMapping("/random")
    public String showDiaryPage(Model model) {

		List<diary> d = repof.showall();
		model.addAttribute("listDiary",d);
        model.addAttribute("foodList", foodList);
        return "random";
    }

    @PostMapping("/addFood")
    public String addFood(@RequestParam String food, Model model) {
        if (foodList.size() < 10) {
            foodList.add(food);
        }
        model.addAttribute("foodList", foodList);
        return "random";
    }

    @GetMapping("/randomizeFood")
    public String randomizeFood(Model model) {
        if (!foodList.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(foodList.size());
            String randomFood = foodList.get(randomIndex);
            model.addAttribute("randomFood", randomFood);
        }
        return "random";
    }
    
	@GetMapping("/randomClear")
    public String clearList(Model model) {

		List<diary> d = repof.showall();
        foodList.clear();
		model.addAttribute("listDiary",d);
        model.addAttribute("foodList", foodList);
        return "redirect:/random";
    }
	
	@PostMapping("/deleteFood")
    public String deleteFood(@RequestParam int foodIndex, Model model) {
        if (foodIndex >= 0 && foodIndex < foodList.size()) {
            foodList.remove(foodIndex);
        }
        model.addAttribute("foodList", foodList);
        return "random";
    }

}