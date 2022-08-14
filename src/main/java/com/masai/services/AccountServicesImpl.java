package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.masai.model.BankAccount;
import com.masai.model.Wallet;
import com.masai.repository.BankAccountDao;
import com.masai.util.GetCurrentLoginUserSessionDetailsIntr;

@Component
public class AccountServicesImpl implements AccountServicesIntr {

	@Autowired
	BankAccountDao bDao;
	
	@Autowired
    private GetCurrentLoginUserSessionDetailsIntr getCurrentLoginUser;
	
	
	@Override
	public BankAccount addAccount(BankAccount bank, String key) {
		
		 Wallet wallet =	getCurrentLoginUser.getCurrentUserWallet(key);
		  
		   wallet.getBankaccounts().add(bank);
		   
		    
		    bank.setWallet(wallet);
			bDao.save(bank);
			
			return bank;
		
	}
     
	
	  
}
