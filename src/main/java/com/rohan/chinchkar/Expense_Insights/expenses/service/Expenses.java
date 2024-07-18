package com.rohan.chinchkar.Expense_Insights.expenses.service;

import org.springframework.stereotype.Service;

@Service
public interface Expenses {
	
	public boolean saveExpenseDataSheet();
	public String getExpenseInsights();

}
