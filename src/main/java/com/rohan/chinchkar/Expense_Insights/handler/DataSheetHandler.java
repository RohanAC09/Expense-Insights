package com.rohan.chinchkar.Expense_Insights.handler;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.rohan.chinchkar.Expense_Insights.entity.ExpenseData;

@Component
public interface DataSheetHandler {

	public List<ExpenseData> convertCSVFileToExpenseDataEntity(MultipartFile csvWorkbook);
	public List<ExpenseData> convertExcelFileToExpenseDataEntity(InputStream inputStream);

}