package com.rohan.chinchkar.Expense_Insights.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.rohan.chinchkar.Expense_Insights.ExpenseInsightsApplication;
import com.rohan.chinchkar.Expense_Insights.constants.ExpenseConstants;
import com.rohan.chinchkar.Expense_Insights.entity.ExpenseData;

@Component
public class HDFCStatementHandlerImpl implements DataSheetHandler{
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(ExpenseInsightsApplication.class);

	@Override
	public List<ExpenseData> convertCSVFileToExpenseDataEntity(MultipartFile csvWorkbook) {
		List<ExpenseData> expenseDataList = new ArrayList<>();
        SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy"); // date format as per the expense sheet
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(csvWorkbook.getInputStream()))) {
            String line;
            boolean headerSkipped = false;
            
            while ((line = br.readLine()) != null) {
                line = line.trim();
                
                // Skip empty or unwanted rows
                if (line.isEmpty() || line.startsWith("**")) {
                    continue;
                }
                
                // Skip header (only once)
                if (!headerSkipped && (line.toLowerCase().contains("date") || line.toLowerCase().contains("description"))) {
                    headerSkipped = true;
                    continue;
                }
                
                // Split into columns
                String[] parts = line.split(",", -1);
                if (parts.length < 4) {
                    continue; // skip invalid rows
                }
                
                try {
                    Date date = dateFormater.parse(parts[0].trim());
                    String description = parts[1].trim();
                    Double debit = parts[2].isEmpty() ? 0 : Double.parseDouble(parts[2].trim());
                    Double credit = parts[3].isEmpty() ? 0 : Double.parseDouble(parts[3].trim());
                    
                    expenseDataList.add(new ExpenseData(date, description, debit, credit));
                } catch (Exception e) {
                    // Ignore malformed rows (could log if needed)
                    System.out.println("Skipping invalid row: " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read CSV file", e);
        }
        
        return expenseDataList;
	}
	
	@Override
	public List<ExpenseData> convertExcelFileToExpenseDataEntity(InputStream inputStream) {
		List<ExpenseData> expenseDataList = new ArrayList<>();

        try (HSSFWorkbook ExcelWorkbook = new HSSFWorkbook(inputStream)){
            HSSFSheet targetedSheet = ExcelWorkbook.getSheet("Sheet 1");
            Iterator<Row> currentRowIterator = targetedSheet.iterator();
            boolean endOfRecords=false;
            boolean hasHeaderPart=true;
            int rowNumber=0;

            while (currentRowIterator.hasNext()) {
                Row rowEntries = currentRowIterator.next();
                
                Iterator<Cell> cellIterator = rowEntries.iterator();
                int cellIndex = 0;
                
                if (hasHeaderPart) {
                	if (ExpenseConstants.Date.equalsIgnoreCase(cellIterator.next().getStringCellValue())) {
                		hasHeaderPart = false;
                    	logger.info("#### Found header value \"Date\" at rowNumber = {}.", rowNumber);
                    	currentRowIterator.next(); // For skipping next row containing symbols "****"
                	}
                	rowNumber++;
                	continue;
                }

                ExpenseData expenseData = new ExpenseData();

                while (cellIterator.hasNext()) {
                    Cell cellEntryData = cellIterator.next();
                    
                    if(cellIndex == 0 && cellEntryData.getStringCellValue().isBlank()) {
                    	endOfRecords=true;
                    	break;
                    }

                    switch (cellIndex) {
                        case 0:
                        	// logger.info("#### Storing Date - {}", cellEntryData.getStringCellValue());
                        	expenseData.setTransactionDate(this.removeFirstCharAndConvertToDate(cellEntryData.getStringCellValue()));
                            break;
                        case 1:
                        	expenseData.setNaration(cellEntryData.getStringCellValue());
                            break;
                        case 4:
                        	expenseData.setDebit_amt(cellEntryData.getNumericCellValue());
                        	expenseData.setCategory(this.setCategoryValue(expenseData.getNaration()));
                            break;
                        case 5:
                        	expenseData.setCredit_amt(cellEntryData.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIndex++;
                }
                if(endOfRecords) {
                	break;
                }
                expenseDataList.add(expenseData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("#### Successfully processed provided Excel Workbook with records = {}", expenseDataList.size());
        return expenseDataList;
	}
	
	private Date removeFirstCharAndConvertToDate(String rawDateString) throws Exception {
		
		Date dateValue = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			dateValue = formatter.parse(rawDateString);
		} catch (Exception e){
			throw new Exception(e);
		}
		
		return dateValue;
	}
	
	private String setCategoryValue(String naration) {
		
		
		
		return null;
	}

}