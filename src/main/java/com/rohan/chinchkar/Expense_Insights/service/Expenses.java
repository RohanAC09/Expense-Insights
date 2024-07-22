package com.rohan.chinchkar.Expense_Insights.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rohan.chinchkar.Expense_Insights.entity.ExpenseData;

@Service
public interface Expenses {
	
	public boolean saveExpenseDataSheetImpl(MultipartFile file);
	public List<ExpenseData> getExpenseInsightsImpl();
}