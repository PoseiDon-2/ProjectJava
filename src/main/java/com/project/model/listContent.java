package com.project.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class listContent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer list_id;
	private String list_name;
	private String list_massage;   
	private String status;
	
	
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "list_post_date")
    private LocalDate postDate = LocalDate.now();

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime targetDateTime;

	
	



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getList_id() {
		return list_id;
	}

	public void setList_id(Integer list_id) {
		this.list_id = list_id;
	}

	public String getList_name() {
		return list_name;
	}

	public void setList_name(String list_name) {
		this.list_name = list_name;
	}

	public String getList_massage() {
		return list_massage;
	}

	public void setList_massage(String list_massage) {
		this.list_massage = list_massage;
	}

	public LocalDate getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}

	public LocalDateTime getTargetDateTime() {
		return targetDateTime;
	}

	public void setTargetDateTime(LocalDateTime targetDateTime) {
		this.targetDateTime = targetDateTime;
	}





	
	
}
