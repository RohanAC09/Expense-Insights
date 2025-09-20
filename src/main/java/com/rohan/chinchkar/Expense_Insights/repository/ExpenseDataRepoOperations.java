package com.rohan.chinchkar.Expense_Insights.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.rohan.chinchkar.Expense_Insights.entity.ExpenseData;

@Service
public interface ExpenseDataRepoOperations {

	public List<ExpenseData> getExpenseInsightsImpl();
	public int saveAllUniqueRecords(List<ExpenseData> expenseDataList);
	public Map<String, String> getMonthlyExpensesDetailsForYear(int year);
	
}
