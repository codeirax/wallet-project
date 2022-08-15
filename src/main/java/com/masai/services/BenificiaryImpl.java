package com.masai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.masai.exceptions.InvalidAccountException;
import com.masai.exceptions.NotFoundException;
import com.masai.model.BankAccount;
import com.masai.model.Benificiary;
import com.masai.model.Wallet;
import com.masai.repository.BankAccountDao;
import com.masai.repository.BenificiaryDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.WalletDao;
import com.masai.util.GetCurrentLoginUserSessionDetailsIntr;

@Component
public class BenificiaryImpl implements BenificiaryIntr {

	
	@Autowired
	WalletDao wDao;
	@Autowired
	CustomerDao cDao;
	@Autowired
	BankAccountDao bDao;
	
	@Autowired
	BenificiaryDao bfDao;

	
	@Autowired
    private GetCurrentLoginUserSessionDetailsIntr getCurrentLoginUser;

	@Override
	public Benificiary addBenificiary(Benificiary benificary, String key) {
		
		Wallet wallet = getCurrentLoginUser.getCurrentUserWallet(key);
		
		wallet.getBenificiaryList().add(benificary);
		benificary.setWallet(wallet);
		bfDao.save(benificary);
		
		
		// TODO Auto-generated method stub
		return benificary;
	}

	@Override
	public Benificiary deleteBenificiary(String name, String key) {
		// TODO Auto-generated method stub
		 Wallet wallet =	getCurrentLoginUser.getCurrentUserWallet(key);
		 
			List<Benificiary> bflist = wallet.getBenificiaryList();
			
			for(Benificiary bf:bflist) {
				if(bf.getName().equals(name)) {
					bflist.remove(bf);
					bfDao.delete(bf);
					wDao.save(wallet);
					return bf;	
				}
			}
			
			throw new InvalidAccountException("Check Account Name");

	}

	@Override
	public List<Benificiary> viewAllBenificiary(String key) {
		Wallet wallet = getCurrentLoginUser.getCurrentUserWallet(key);
		List<Benificiary> bfList = wallet.getBenificiaryList();
		if( bfList.size()<=0 ) 
			throw new NotFoundException("Benificiaries details not found..");
		return bfList;
	}
	
	
	
	
}
