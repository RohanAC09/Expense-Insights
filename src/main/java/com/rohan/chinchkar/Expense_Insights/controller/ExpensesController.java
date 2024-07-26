package com.rohan.chinchkar.Expense_Insights.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rohan.chinchkar.Expense_Insights.ExpenseInsightsApplication;
import com.rohan.chinchkar.Expense_Insights.entity.ExpenseData;
import com.rohan.chinchkar.Expense_Insights.service.Expenses;

@Controller
public class ExpensesController {
	
	@Autowired
	Expenses expenses;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(ExpenseInsightsApplication.class);
	
	@PostMapping(value = "/expense/saveData")
	public ResponseEntity<String> saveExpenseDataSheet(@RequestParam("file") MultipartFile file) {
		logger.info("#### Calling ExpensesImpl class for saving provided data");
		int numberOfRecordStored = expenses.saveExpenseDataSheetImpl(file);
		String responseString = String.format("Successfully stored %d unique records", numberOfRecordStored);
		return new ResponseEntity<>(responseString,HttpStatus.OK);
	}
	
	@GetMapping(value = "/expense/getInsights")
	public ResponseEntity<List<ExpenseData>> getExpenseInsights(@RequestParam String month) {
		
		List<ExpenseData> listOfData=expenses.getExpenseInsightsImpl();
		return new ResponseEntity<List<ExpenseData>>(listOfData, HttpStatus.OK);
	}
	

}