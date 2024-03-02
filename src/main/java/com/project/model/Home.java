package com.project.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Home {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String name;
	
	private LocalDateTime post_data; 

}
