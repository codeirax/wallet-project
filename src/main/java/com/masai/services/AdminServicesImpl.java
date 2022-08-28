package com.masai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.NotFoundException;
import com.masai.model.Transaction;
import com.masai.repository.TransactionDao;

@Service
public class AdminServicesImpl implements AdminServicesIntr{

	@Autowired
	TransactionDao trDao;
	
	@Override
	public List<Transaction> getEveryTransaction() {
		
		     List<Transaction> list =   trDao.findAll();
		
		     if(list.size() == 0 )
		    	 throw new NotFoundException("no transaction found");
		     
		     return list;
	}

	@Override
	public List<Transaction> getTransactionsForDay(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getPeriodTransaction(String fromDate, String tillDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getEveryTransactionForId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getTransactionsForIdForDay(String date, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getPeriodTransactionForId(String fromDate, String tillDate, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
