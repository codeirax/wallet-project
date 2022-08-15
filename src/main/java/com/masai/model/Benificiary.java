package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Benificiary {
	
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bid;
	private String name;
	private String mobileNumber;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
}
