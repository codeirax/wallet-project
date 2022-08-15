package com.masai.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.NotFoundException;
import com.masai.model.Transaction;
import com.masai.model.Wallet; 
import com.masai.repository.TransactionDao;
import com.masai.repository.WalletDao;
import com.masai.util.GetCurrentLoginUserSessionDetailsIntr;


@Service
public class TransactionServicesImpl implements TransactionSevices {

	@Autowired
	WalletDao wDao;
	@Autowired
	TransactionDao transactionDao;
	@Autowired
    private GetCurrentLoginUserSessionDetailsIntr getCurrentLoginUser;
	
	@Override
	public List<Transaction> viewAllTransaction(String key) {
		Wallet wallet = getCurrentLoginUser.getCurrentUserWallet(key);
		
		List <Transaction>  transactionList = wallet.getTransactions();
		
		if(transactionList.size() == 0) {
			throw new NotFoundException("No Transaction found");
		}
		
		return transactionList;
	}

	
	
	@Override
	public List<Transaction> viewAllTransactionByDate(String key, String date) {
		Wallet wallet = getCurrentLoginUser.getCurrentUserWallet(key);
		
		Date d; 
		

		try {
			d = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		}catch (Exception e) {
			throw new NotFoundException("Date didn't match");
		}
		
		List <Transaction>  transactionList = wallet.getTransactions();
		
		List <Transaction> trList2 = new ArrayList<Transaction>();
		
		for(Transaction tx : transactionList) {
			if(tx.getTransactionDate().equals(d)) {
				trList2.add(tx);
			}
		}
		if(trList2.size() == 0) {
			throw new NotFoundException("Transaction not found as per given date");
		}
		
		return trList2;
	}

	

	
	

}