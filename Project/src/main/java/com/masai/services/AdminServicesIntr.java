package com.masai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.model.Transaction;

@Service
public interface AdminServicesIntr {
	
	public List<Transaction> getEveryTransaction();
	
	public List<Transaction> getTransactionsForDay(String date );
	
	public List<Transaction> getPeriodTransaction(String fromDate , String tillDate);
	
	public List<Transaction> getEveryTransactionForId(int id);
	
	public List<Transaction> getTransactionsForIdForDay(String date  , int id);
	
	public List<Transaction> getPeriodTransactionForId(String fromDate , String tillDate,int id);
	

}
