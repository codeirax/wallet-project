package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Beneficiary;


@Repository
public interface BenificiaryDao extends JpaRepository<Beneficiary, Integer>{
	
	public Optional<Beneficiary> findByMobileNumber(String mobileNumber);
}
