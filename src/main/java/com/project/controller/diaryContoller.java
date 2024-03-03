package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

		@GetMapping("/editDiary/{id}")
		public String showEditDiaryForm(@PathVariable Long id, Model model) {
		    // ดึงข้อมูล Diary จากฐานข้อมูลด้วย ID
			diary diary = repo.findById(id);

		    // ตรวจสอบว่า Diary พบหรือไม่
		    if (diary != null) {
		        model.addAttribute("diary", diary);
		        return "diaryedit";
		    } else {
		        // หากไม่พบ Diary กลับไปที่หน้า Diary
		        return "redirect:/diary";
		    } 
		    
		}

		@PostMapping("/updateDiary")
		public String updateDiary(@ModelAttribute diary diary, Model model) {
		    // ตรวจสอบและบันทึกการแก้ไขข้อมูลลงในฐานข้อมูล
		    repo.update(diary);

		    return "redirect:/diary";
		}
		
		@GetMapping("/deleteDiary/{id}")
	    public String deleteDiary(@PathVariable Long id) {
	        // ทำการลบข้อมูลจากฐานข้อมูล
	        repo.delete(id);

	        // Redirect ไปที่หน้า Diary หลังจากที่ลบเสร็จสมบูรณ์
	        return "redirect:/diary";
	    }
		
		@GetMapping("/search")
		public String search(@RequestParam("q") String query, Model model) {
		    // ในที่นี้คุณสามารถใช้ค่า query ในการค้นหาหรือประมวลผลต่อไป
		    // ยกตัวอย่างเช่นเรียกใช้ repo.searchDiary(query) เพื่อค้นหา Diary ที่มีชื่อหรือข้อความที่ตรงกับ query
		    List<diary> searchResult = repo.searchDiary(query);
		    model.addAttribute("searchResult", searchResult);
		    return "diary"; // ชื่อ view ที่จะแสดงผลรายการค้นหา
		}
		
		


}
