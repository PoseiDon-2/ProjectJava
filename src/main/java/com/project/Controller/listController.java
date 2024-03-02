package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.listConRepo;
import com.project.model.listContent;


@Controller
public class listController {
	
		@Autowired
	    private listConRepo repo;
		
		  @RequestMapping("/listinsert")
		    public String showdiaryinsertPage() {
		        return "listinsert"; // ส่งกลับไปยังหน้า homeinsert.html
		    }
		  
		  @PostMapping("/addlist")
		    public String addEntry(listContent listContent) {
		      repo.save(listContent); // บันทึกข้อมูล diary ลงในฐานข้อมูล
		      return "redirect:/listContent"; // ส่งกลับไปยังหน้าหลัก
		    }
		  
			@PostMapping("/listinsert")
			public String add(@ModelAttribute listContent listContent, Model model) {
			    // Set default values if not provided in the form
//				diary.setAuthor("not");
//				diary.setLove(0);

			    // Insert data into the database
				repo.insertData(listContent);

			    return "redirect:/listContent";
			}
	

}
