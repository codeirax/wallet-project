package com.masai.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.InsufficientAmountException;
import com.masai.exceptions.InvalidAccountException;
import com.masai.exceptions.NotFoundException;
import com.masai.exceptions.WalletException;
import com.masai.model.BankAccount;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import com.masai.repository.BankAccountDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.WalletDao;
import com.masai.util.GetCurrentLoginUserSessionDetailsImpl;
import com.masai.util.GetCurrentLoginUserSessionDetailsIntr;

@Service
public class WalletServiceImpl implements WalletServices{
     
	@Autowired
	WalletDao wDao;
	@Autowired
	CustomerDao cDao;
	@Autowired
	BankAccountDao bDao;
	
	@Autowired
    private GetCurrentLoginUserSessionDetailsIntr getCurrentLoginUser;

	@Override
	public void FundTransfer(String sourceMobileNo, String targetMobileNo, double amount)
			throws InsufficientAmountException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double showWalletBalance(String key) throws NotFoundException {
		// TODO Auto-generated method stub
		
	 double balance =	getCurrentLoginUser.getCurrentUserWallet(key).getBalance();
		
		
		return balance;
	}

	@Override
	public Customer depositAmount(double amount, String key) throws InsufficientAmountException {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

	//add money with the help of bank.
	
	@Override
	@Transactional
	public String addMoneyToWallet(int bankAccountNumber,double amount, String key) throws InsufficientAmountException {
		
	   Wallet wallet = getCurrentLoginUser.getCurrentUserWallet(key);
	   
	  List<BankAccount> banks = wallet.getBankaccounts();
	 
	  for(BankAccount bank:banks) {
		  if(bank.getAccountNo() == bankAccountNumber) {
			  if(bank.getBalance() >= amount) {
				  
				  bank.setBalance(bank.getBalance() - amount);
				  wallet.setBalance(wallet.getBalance() + amount);
				  bDao.save(bank);
				  wDao.save(wallet);
				  return "Amount : " + amount +"added to wallet";
			  }else {
				  throw new InsufficientAmountException("Insufficient amount in bank account..");
			  }
			
		  }
	  }
	  throw new NotFoundException("Bank not found..");
	  
	
		
	}

	

	

	
}


