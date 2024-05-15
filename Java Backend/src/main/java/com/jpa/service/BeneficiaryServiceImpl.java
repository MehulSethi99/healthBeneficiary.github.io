package com.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entity.Beneficiary;
import com.jpa.exceptions.BeneficiaryNotFoundException;
import com.jpa.exceptions.DuplicateEntityException;
import com.jpa.exceptions.NoDataException;
import com.jpa.repository.BeneficiaryRepository;

//Implementing the methods of BeneficiaryService interface
@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	BeneficiaryRepository repository;

	@Override
	public Beneficiary getBeneficiary(int id) throws BeneficiaryNotFoundException {
		Optional<Beneficiary> opt = repository.findById(id);
		if (opt.isPresent()) {
			Beneficiary b = opt.get();
			return b;
		} else {
			throw new BeneficiaryNotFoundException("Get","Beneficiary with id " + id + " not found");
		}

	}

	@Override
	public List<Beneficiary> getAllBeneficiaries() throws NoDataException {
		List<Beneficiary> list = repository.findAll();
		if (list.size() == 0)
			throw new NoDataException("No data available.");
		return list;
	}

	@Override
	public void saveBeneficiary(Beneficiary b) throws DuplicateEntityException {
		if(repository.existsById(b.getBeneficiaryId()))
		{
		throw new BeneficiaryNotFoundException("Save","Beneficiary with id "+b.getBeneficiaryId()+" already exists");
		
		}repository.save(b);

	}

	@Override
	public void updateBeneficiary(Beneficiary b) throws BeneficiaryNotFoundException {
		if (!(repository.existsById(b.getBeneficiaryId()))) {
			throw new BeneficiaryNotFoundException("Update",
					"Beneficiary with id " + b.getBeneficiaryId() + " not found to update");

		}
		repository.save(b);
	}

	@Override
	public void deleteBeneficiary(int bId) throws BeneficiaryNotFoundException {
		if (!(repository.existsById(bId)))
			throw new BeneficiaryNotFoundException("Delete","Beneficiary with id " + bId + " not found to delete");
		repository.deleteById(bId);

	}

}
