package com.rohan.chinchkar.Expense_Insights.expenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.chinchkar.Expense_Insights.expenses.entity.ExpenseDataRepository;

@Service
public class ExpensesImpl implements Expenses{
	
	@Autowired
	ExpenseDataRepository expenseDataRepository;

	@Override
	public boolean saveExpenseDataSheet() {
		
		
		return false;
	}

	@Override
	public String getExpenseInsights() {
		
		
		return null;
	}

}
