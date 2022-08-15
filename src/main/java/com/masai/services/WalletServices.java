package com.masai.services;

import org.springframework.stereotype.Service;

import com.masai.exceptions.InsufficientAmountException;
import com.masai.exceptions.InvalidAccountException;
import com.masai.exceptions.NotFoundException;
import com.masai.model.BankAccount;
import com.masai.model.Wallet;

@Service
public interface WalletServices {

   
  
 
    public String FundTransfer(String key ,String targetMobileNo,double amount);
   
    public double showWalletBalance(String key);
    
//    public double showBankBalance(String key) throws NotFoundException;
    
    
   
   public BankAccount depositAmount(long accountNumber,double amount ,String key);
 
   
   public String addMoneyToWallet(long bankAccountNumber,double amount,String key);
   
   
   
}
