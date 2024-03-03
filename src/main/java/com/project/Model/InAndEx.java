package com.project.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InAndEx {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer income = 0;
	private Integer expenses = 0;
	private String incomedetail = "Income";
	private String expensesdetail = "Expenses";
	private Date Date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIncome() {
		return income;
	}
	public void setIncome(Integer income) {
		this.income = income;
	}
	public Integer getExpenses() {
		return expenses;
	}
	public void setExpenses(Integer expenses) {
		this.expenses = expenses;
	}
	public String getIncomedetail() {
		return incomedetail;
	}
	public void setIncomedetail(String incomedetail) {
		this.incomedetail = incomedetail;
	}
	public String getExpensesdetail() {
		return expensesdetail;
	}
	public void setExpensesdetail(String expensesdetail) {
		this.expensesdetail = expensesdetail;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	
	
}	
