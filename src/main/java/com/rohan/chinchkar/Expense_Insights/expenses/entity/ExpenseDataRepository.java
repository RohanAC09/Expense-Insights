package com.rohan.chinchkar.Expense_Insights.expenses.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ExpenseDataRepository extends JpaRepository<ExpenseData, String> {

}
