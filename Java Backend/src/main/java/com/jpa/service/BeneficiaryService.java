package com.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa.entity.Beneficiary;
import com.jpa.exceptions.BeneficiaryNotFoundException;
import com.jpa.exceptions.DuplicateEntityException;
import com.jpa.exceptions.NoDataException;

@Service
public interface BeneficiaryService {
	
	//Declaring the methods 
	Beneficiary getBeneficiary(int id) throws BeneficiaryNotFoundException;
	List<Beneficiary> getAllBeneficiaries() throws NoDataException;
	void saveBeneficiary(Beneficiary b) throws DuplicateEntityException;
	void updateBeneficiary(Beneficiary b) throws BeneficiaryNotFoundException;
	void deleteBeneficiary(int bId) throws BeneficiaryNotFoundException;
	
}
