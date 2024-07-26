package com.rohan.chinchkar.Expense_Insights.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rohan.chinchkar.Expense_Insights.entity.ExpenseData;

@Repository
public interface ExpenseDataRepository extends JpaRepository<ExpenseData, String> {
	
	@Query(value = "SELECT * FROM expense_data exp WHERE exp.transaction_date=?1", nativeQuery = true)
	List<ExpenseData> fetchExpenseDataByMonth(int month);
	
	@Query(value = "SELECT count(*) FROM expense_data exp WHERE exp.naration <> ?1", nativeQuery = true)
	int checkForUniqueNaration(String naration);

}