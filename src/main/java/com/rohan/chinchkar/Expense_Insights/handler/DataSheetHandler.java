package com.rohan.chinchkar.Expense_Insights.handler;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rohan.chinchkar.Expense_Insights.entity.ExpenseData;

@Component
public interface DataSheetHandler {

	public List<ExpenseData> convertFileToExpenseDataEntity(InputStream inputStream);

}