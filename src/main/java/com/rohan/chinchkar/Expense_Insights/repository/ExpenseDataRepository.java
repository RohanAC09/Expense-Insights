package com.rohan.chinchkar.Expense_Insights.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rohan.chinchkar.Expense_Insights.entity.ExpenseData;

@Repository
public interface ExpenseDataRepository extends JpaRepository<ExpenseData, String> {
	
	@Query(value = "SELECT count(*) FROM expense_data exp WHERE exp.naration = ?1 "
			+ "AND transaction_date = ?2 AND credit_amount = ?3 AND debit_amount = ?4", nativeQuery = true)
	int checkForUniqueNaration(String naration, Date transactionDate, double credit_amt, double debit_amt);
	
//	@Query(value = "SELECT naration FROM expense_data exp WHERE exp.naration IN (?1)", nativeQuery = true)
//	List<String> findAllNaration(String narationQuery);
	
	@Query(value = "SELECT * FROM expense_data exp WHERE exp.transaction_date=?1", nativeQuery = true)
	List<ExpenseData> fetchExpenseDataByMonth(int month);
	
	@Query(value = "SELECT dt_1.month_name, sum(dt_1.debit_amount) FROM "
			+ "(SELECT month(exp.transaction_date) AS month_name, exp.debit_amount FROM expense_data AS exp"
			+ "WHERE year(exp.transaction_date) = '?1') AS dt_1 GROUP BY dt_1.month_name", nativeQuery = true)
	Map<String, String> fetchMonthlyExpenseDataByYear(int targeted_year);

}