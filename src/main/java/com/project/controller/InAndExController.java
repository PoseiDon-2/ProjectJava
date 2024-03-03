package com.project.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.InAndEx;
import com.project.model.InAndExRepo;

@Controller
public class InAndExController {
	@Autowired
	InAndExRepo repo;
	
	@GetMapping("/showInAndEx")
	public String showData(Model model) {
		List<InAndEx> dataList = repo.showAll();

        // เรียงลำดับข้อมูลตามวันที่
        Collections.sort(dataList, Comparator.comparing(InAndEx::getDate));
        
        model.addAttribute("list", dataList);
			return "InAndExShow";
	}
	
	@GetMapping("/detail/{id}")
	public String showDetail(@PathVariable("id") Integer id, Model model) {
	    // ดึงข้อมูลของรายการที่ต้องการแสดงจากฐานข้อมูล
	    InAndEx data = repo.findById(id);
	    // ส่งข้อมูลไปยังหน้า HTML
	    model.addAttribute("data", data);
	    return "Detail";
	}
//	@GetMapping("/Showadd")
//    public String showAdd() {
//        // ส่งชื่อของไฟล์ HTML ที่คุณต้องการให้แสดงผลกลับไป
//        return "AddInEx";
//    }

	
	@GetMapping("/add")
	public String add(@ModelAttribute InAndEx In,Model model) {
		repo.insertData(In);
		return "redirect:/showInAndEx";
//		Forum ans = new Forum();
//		ans.setDetail("Hello");
//		ans.setAuthor("GJ");
//		ans.setLove(1);
//		ans.setPostDate(new Date(System.currentTimeMillis()));
//		repof.insertData(ans);
//		System.out.println("Insert Successful");
	}
	
	@GetMapping("/editI")
	public String AddIncome(@RequestParam("id") Integer id, Model model) {
	    // ดึงข้อมูลของรายการที่ต้องการแก้ไขจากฐานข้อมูล
	    InAndEx data = repo.findById(id);
	    model.addAttribute("data", data);
	    repo.update(data);
	    return "AddIncome";
	}
	
	@GetMapping("/editE")
	public String AddExpenses(@RequestParam("id") Integer id, Model model) {
	    // ดึงข้อมูลของรายการที่ต้องการแก้ไขจากฐานข้อมูล
	    InAndEx data = repo.findById(id);
	    model.addAttribute("data", data);
	    return "AddExpenses";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Integer id, Model model) {
	    // ดึงข้อมูลของรายการที่ต้องการแก้ไขจากฐานข้อมูล
	    InAndEx data = repo.findById(id);
	    // ส่งข้อมูลไปยังหน้า HTML ในรูปแบบของ ModelAttribute เพื่อให้แสดงในฟอร์ม
	    model.addAttribute("data", data);
	    // ส่งชื่อของไฟล์ HTML ที่คุณต้องการให้แสดงผลกลับไป
	    return "EditInEx";
	}
	
	@PostMapping("/edit/{id}")
    public String editData(@PathVariable("id") Integer id, @ModelAttribute InAndEx updatedData) {
        // ดึงข้อมูลที่ต้องการแก้ไขจากฐานข้อมูล
        InAndEx existingData = repo.findById(id);
        // อัปเดตข้อมูลที่มีการเปลี่ยนแปลง
        existingData.setIncome(updatedData.getIncome());
        existingData.setIncomedetail(updatedData.getIncomedetail());
        existingData.setExpenses(updatedData.getExpenses());
        existingData.setExpensesdetail(updatedData.getExpensesdetail());
        // บันทึกการเปลี่ยนแปลงลงในฐานข้อมูล
        repo.update(existingData);
        // ส่งกลับไปยังหน้าที่แสดงข้อมูลทั้งหมด
        return "redirect:/showInAndEx";
    }
	
	@PostMapping("/editI/{id}")
    public String editDataI(@PathVariable("id") Integer id, @ModelAttribute InAndEx updatedData) {
        // ดึงข้อมูลที่ต้องการแก้ไขจากฐานข้อมูล
        InAndEx existingData = repo.findById(id);
        // อัปเดตข้อมูลที่มีการเปลี่ยนแปลง
        existingData.setIncome(existingData.getIncome()+updatedData.getIncome());
        existingData.setIncomedetail(existingData.getIncomedetail()+","+updatedData.getIncomedetail()+"="+updatedData.getIncome().toString());
        existingData.setExpenses(updatedData.getExpenses());
        existingData.setExpensesdetail(updatedData.getExpensesdetail());
        // บันทึกการเปลี่ยนแปลงลงในฐานข้อมูล
        repo.update(existingData);
        // ส่งกลับไปยังหน้าที่แสดงข้อมูลทั้งหมด
        return "redirect:/showInAndEx";
    }
	
	@PostMapping("/editE/{id}")
    public String editDataE(@PathVariable("id") Integer id, @ModelAttribute InAndEx updatedData) {
        // ดึงข้อมูลที่ต้องการแก้ไขจากฐานข้อมูล
        InAndEx existingData = repo.findById(id);
        // อัปเดตข้อมูลที่มีการเปลี่ยนแปลง
        existingData.setIncome(updatedData.getIncome());
        existingData.setIncomedetail(updatedData.getIncomedetail());
        existingData.setExpenses(existingData.getExpenses()+updatedData.getExpenses());
        existingData.setExpensesdetail(existingData.getExpensesdetail()+","+updatedData.getExpensesdetail()+"="+updatedData.getExpenses().toString());
        // บันทึกการเปลี่ยนแปลงลงในฐานข้อมูล
        repo.update(existingData);
        // ส่งกลับไปยังหน้าที่แสดงข้อมูลทั้งหมด
        return "redirect:/showInAndEx";
    }
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		repo.delete(id);
		return "redirect:/showInAndEx";
	}
	
	
}