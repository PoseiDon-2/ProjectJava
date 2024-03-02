package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.diary;
import com.project.model.diaryRepository;

@Controller
public class diaryContoller {
	
	@Autowired
    private diaryRepository repo;
	
	  @RequestMapping("/diaryinsert")
	    public String showdiaryinsertPage() {
	        return "diaryinsert"; // ส่งกลับไปยังหน้า homeinsert.html
	    }
	  
	  @PostMapping("/adddiary")
	    public String addEntry(@ModelAttribute diary diary) {
	      repo.save(diary); // บันทึกข้อมูล diary ลงในฐานข้อมูล
	      return "redirect:/diary"; // ส่งกลับไปยังหน้าหลัก
	    }
	  
		@PostMapping("/insertDiary")
		public String add(@ModelAttribute diary diary, Model model) {

		    // Insert data into the database
			repo.insertData(diary);
			
		    return "redirect:/diary";
		}

		
		


}
