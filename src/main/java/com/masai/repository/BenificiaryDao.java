package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Benificiary;


@Repository
public interface BenificiaryDao extends JpaRepository<Benificiary, Integer>{
	
	public Optional<Benificiary> findByMobileNumber(String mobileNumber);
}
