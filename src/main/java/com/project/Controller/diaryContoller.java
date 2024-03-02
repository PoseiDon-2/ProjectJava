package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	    public String addEntry(diary diary) {
	      repo.save(diary); // บันทึกข้อมูล diary ลงในฐานข้อมูล
	      return "redirect:/"; // ส่งกลับไปยังหน้าหลัก
	    }
}
