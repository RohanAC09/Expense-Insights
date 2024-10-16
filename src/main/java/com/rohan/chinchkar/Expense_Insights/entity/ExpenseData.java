package com.rohan.chinchkar.Expense_Insights.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExpenseData {
	
	@Id
	@Column(name="id", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	@Column(name="transaction_date")
	public Date transactionDate;
	
	@Column(name="credit_amount")
	public double credit_amt;
	
	@Column(name="debit_amount")
	public double debit_amt;
	
	@Column(name="naration")
	public String naration;
	
	@Column(name="category")
	public String category;
	
	public ExpenseData() {
		super();
	}
	
	public ExpenseData(Date transactionDate, double credit_amt, double debit_amt, String naration, String category) {
		super();
		this.transactionDate = transactionDate;
		this.credit_amt = credit_amt;
		this.debit_amt = debit_amt;
		this.naration = naration;
		this.category = category;
	}
	
	public ExpenseData(long id, Date transactionDate, double credit_amt, double debit_amt, String naration,
			String category) {
		super();
		this.id = id;
		this.transactionDate = transactionDate;
		this.credit_amt = credit_amt;
		this.debit_amt = debit_amt;
		this.naration = naration;
		this.category = category;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getCredit_amt() {
		return credit_amt;
	}
	public void setCredit_amt(double credit_amt) {
		this.credit_amt = credit_amt;
	}
	public double getDebit_amt() {
		return debit_amt;
	}
	public void setDebit_amt(double debit_amt) {
		this.debit_amt = debit_amt;
	}
	public String getNaration() {
		return naration;
	}
	public void setNaration(String naration) {
		this.naration = naration;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "ExpenseData [id=" + id + ", transactionDate=" + transactionDate + ", credit_amt=" + credit_amt
				+ ", debit_amt=" + debit_amt + ", naration=" + naration + ", category=" + category + "]";
	}
}