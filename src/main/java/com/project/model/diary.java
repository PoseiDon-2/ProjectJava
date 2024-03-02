package com.project.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class diary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String massage;
	private LocalDateTime post_data;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public LocalDateTime getPost_data() {
		return post_data;
	}
	public void setPost_data(LocalDateTime post_data) {
		this.post_data = post_data;
	}
	

}
