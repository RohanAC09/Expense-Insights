package com.rohan.chinchkar.Expense_Insights.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rohan.chinchkar.Expense_Insights.ExpenseInsightsApplication;
import com.rohan.chinchkar.Expense_Insights.entity.ExpenseData;
import com.rohan.chinchkar.Expense_Insights.handler.DataSheetHandler;
import com.rohan.chinchkar.Expense_Insights.handler.HDFCStatementHandlerImpl;
import com.rohan.chinchkar.Expense_Insights.repository.ExpenseDataRepository;

@Service
public class ExpensesImpl implements Expenses{
	
	@Autowired
	ExpenseDataRepository expenseDataRepository;
	
	@Autowired
	DataSheetHandler dataSheetHandler;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(ExpenseInsightsApplication.class);

	@Override
	public int saveExpenseDataSheetImpl(MultipartFile excelWorkbook) {
		if (!excelWorkbook.isEmpty()) {
			int numberOfRecordsStored=0;
			dataSheetHandler = new HDFCStatementHandlerImpl();
			try {
				List<ExpenseData> expenseDataList = dataSheetHandler.convertFileToExpenseDataEntity(excelWorkbook.getInputStream());
				//logger.info(expenseDataList.toString());
//				expenseDataRepository.saveAll(expenseDataList);
				numberOfRecordsStored = this.saveAllRecords(expenseDataList);
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
	public List<ExpenseData> getExpenseInsightsImpl() {
		
		List<ExpenseData> listOfData = expenseDataRepository.findAll();
		logger.info("#### getExpenseInsightsImpl -> number of records = {}", listOfData.size());
		return listOfData;
	}

	@Override
	public int saveAllRecords(List<ExpenseData> expenseDataList) {
		if(!expenseDataList.isEmpty()) {
			List<ExpenseData> uniqueExpenseDataList = new ArrayList<ExpenseData>();
			for(ExpenseData expense: expenseDataList) {
				if(expenseDataRepository.checkForUniqueNaration(expense.getNaration())==0) {
					uniqueExpenseDataList.add(expense);
				}
			}
			expenseDataRepository.saveAll(uniqueExpenseDataList);
			return uniqueExpenseDataList.size();
		} else {
			return 0;
		}
		
	}
}