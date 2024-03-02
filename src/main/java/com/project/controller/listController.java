package com.project.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.project.model.listConRepo;
import com.project.model.listContent;


@Controller
public class listController {
	
		@Autowired
	    private listConRepo repo;
		
		  @RequestMapping("/listinsert")
		    public String showdiaryinsertPage() {
		        return "listInsert"; // ส่งกลับไปยังหน้า homeinsert.html
		    }
		  
		  @PostMapping("/addlist")
		  public String addEntry(@ModelAttribute listContent listContent) {
		      LocalDateTime currentDateTime = LocalDateTime.now();
		      LocalDateTime targetDateTime = listContent.getTargetDateTime();

		      // Compare the targetDateTime with currentDateTime and set the status accordingly
		      if (targetDateTime != null && targetDateTime.isEqual(currentDateTime) || targetDateTime.isBefore(currentDateTime)) {
		          listContent.setStatus("ไม่สำเร็จ");
		      } else {
		          listContent.setStatus("สำเร็จ");
		      }

		      repo.save(listContent); // Save data to the database
		      return "redirect:/listContent"; // Redirect back to the main page
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
			
			@GetMapping("/deleteList/{list_id}")
			public String deleteList(@PathVariable("list_id") String list_id) {
			    repo.delete(list_id); // Delete the entry with the specified list_id from the database
			    return "redirect:/listContent"; // Redirect back to the main page after deletion
			}
	

}
