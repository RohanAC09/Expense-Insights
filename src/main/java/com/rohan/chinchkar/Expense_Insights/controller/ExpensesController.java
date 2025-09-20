package com.rohan.chinchkar.Expense_Insights.controller;

import java.util.List;
import java.util.Map;

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
	
	@PostMapping(value = "/csv/uploadExpenseDataSheet")
	public ResponseEntity<String> uploadExpenseDataSheet(@RequestParam("file") MultipartFile file) {
		logger.info("#### Calling ExpensesImpl class for saving provided data");
		int numberOfRecordStored = expenses.uploadExpenseDataSheetImpl(file);
		String responseString = String.format("Successfully uploaded Sheet with %d unique records", numberOfRecordStored);
		return new ResponseEntity<>(responseString,HttpStatus.OK);
	}
	
	@PostMapping(value = "/excel/uploadExpenseDataSheet")
	public ResponseEntity<String> saveExpenseDataSheet(@RequestParam("file") MultipartFile file) {
		logger.info("#### Calling ExpensesImpl class for saving provided data");
		int numberOfRecordStored = expenses.saveExpenseDataSheetImpl(file);
		String responseString = String.format("Successfully uploaded Sheet with %d unique records", numberOfRecordStored);
		return new ResponseEntity<>(responseString,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getInsights")
	public ResponseEntity<List<ExpenseData>> getExpenseInsights(@RequestParam String month) {
		
		List<ExpenseData> listOfData=expenses.getExpenseInsightsImpl(month);
		return new ResponseEntity<List<ExpenseData>>(listOfData, HttpStatus.OK);
	}
	
	@GetMapping(value = "/v1/getMonthlyExpensesForYear")
	public ResponseEntity<Map<String, String>> getMonthlyExpensesDetails(@RequestParam int year) {
		
		Map<String, String> listOfData=expenses.getMonthlyExpensesDetailsForYear(year);
		return new ResponseEntity<Map<String, String>>(listOfData, HttpStatus.OK);
	}
	

}