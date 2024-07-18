package com.rohan.chinchkar.Expense_Insights.expenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rohan.chinchkar.Expense_Insights.expenses.entity.ExpenseData;

@Controller
public class ExpensesController {
	
	@Autowired
	ExpenseData expenseData;
	
	@PutMapping(value = "/saveData")
	public Boolean saveExpenseDataSheet(@RequestParam MultipartFile file) {
		
		return true;
	}
	
	@GetMapping(value = "/getInsights")
	public String getExpenseInsights(@RequestParam String month) {
		
		return null;
	}
	

}
