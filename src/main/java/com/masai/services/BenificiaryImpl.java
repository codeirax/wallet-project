package com.masai.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.masai.exceptions.InvalidAccountException;
import com.masai.exceptions.NotFoundException;
import com.masai.exceptions.UserAlreadyExistWithMobileNumber;
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
		
		Optional<Benificiary> optBenificiary = bfDao.findByMobileNumber(benificary.getMobileNumber());
		if(optBenificiary.isPresent()) {
			throw new UserAlreadyExistWithMobileNumber("Benificiary already added..");
		}
		
		Wallet wallet = getCurrentLoginUser.getCurrentUserWallet(key);
		
		wallet.getBenificiaryList().add(benificary);
		
		wDao.save(wallet);
		
		return benificary;
	}



	@Override
	public List<Benificiary> viewAllBenificiary(String key) {
		Wallet wallet = getCurrentLoginUser.getCurrentUserWallet(key);
		List<Benificiary> bfList = wallet.getBenificiaryList();
		if( bfList.size()<=0 ) 
			throw new NotFoundException("Benificiaries details not found..");
		return bfList;
	}
	
	
	@Override
	public String removeBenificiary(String mobile, String key) {
		
		Wallet wallet = getCurrentLoginUser.getCurrentUserWallet(key);
		
		List<Benificiary> bfList = wallet.getBenificiaryList();
		
		for(Benificiary benfisiry:bfList) {
			
			if(benfisiry.getMobileNumber().equals(mobile)) {
				bfList.remove(benfisiry);
				bfDao.delete(benfisiry);
				wDao.save(wallet);
				return "Name: "+benfisiry.getName()+"\n"+"Mobile Number :"+benfisiry.getMobileNumber()+"\n"+"Added Successfully";
			}
		}
		
		throw new NotFoundException("Given Mobile Number Is in Benificiary List...");
	}
	
	
}
