package com.rohan.chinchkar.Expense_Insights.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rohan.chinchkar.Expense_Insights.entity.ExpenseData;
import com.rohan.chinchkar.Expense_Insights.handler.DataSheetHandler;
import com.rohan.chinchkar.Expense_Insights.handler.HDFCStatementHandlerImpl;
import com.rohan.chinchkar.Expense_Insights.repository.ExpenseDataRepoOperations;

@Service
public class ExpensesImpl implements Expenses{
	
	
	@Autowired
	DataSheetHandler dataSheetHandler;
	
	@Autowired
	ExpenseDataRepoOperations expenseDataRepoOperations;
	
	// private static final Logger logger = (Logger) LoggerFactory.getLogger(ExpenseInsightsApplication.class);
	
	@Override
	public int uploadExpenseDataSheetImpl(MultipartFile csvWorkbook) {
		if (!csvWorkbook.isEmpty()) {
			int numberOfRecordsStored=0;
			dataSheetHandler = new HDFCStatementHandlerImpl();
			List<ExpenseData> expenseDataList = dataSheetHandler.convertCSVFileToExpenseDataEntity(csvWorkbook);
			// logger.info(expenseDataList.toString());
			numberOfRecordsStored = expenseDataRepoOperations.saveAllUniqueRecords(expenseDataList);
			return numberOfRecordsStored;
		} else {
            return 0;
        }
	}
	
	@Override
	public int saveExpenseDataSheetImpl(MultipartFile excelWorkbook) {
		if (!excelWorkbook.isEmpty()) {
			int numberOfRecordsStored=0;
			dataSheetHandler = new HDFCStatementHandlerImpl();
			try {
				List<ExpenseData> expenseDataList = dataSheetHandler.convertExcelFileToExpenseDataEntity(excelWorkbook.getInputStream());
				// logger.info(expenseDataList.toString());
				numberOfRecordsStored = expenseDataRepoOperations.saveAllUniqueRecords(expenseDataList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return numberOfRecordsStored;
		} else {
            return 0;
        }
	}

	@Override
	public List<ExpenseData> getExpenseInsightsImpl(String month) {
		return expenseDataRepoOperations.getExpenseInsightsImpl();
	}

	@Override
	public Map<String, String> getMonthlyExpensesDetailsForYear(int year) {
		return expenseDataRepoOperations.getMonthlyExpensesDetailsForYear(year);
	}
}