package com.rohan.chinchkar.Expense_Insights.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rohan.chinchkar.Expense_Insights.entity.ExpenseData;

@Service
public interface Expenses {
	
	public int saveExpenseDataSheetImpl(MultipartFile file);
	public List<ExpenseData> getExpenseInsightsImpl();
	public int saveAllUniqueRecords(List<ExpenseData> expenseDataList);
	public Map<String, String> getMonthlyExpensesDetailsForYear(int year);
}