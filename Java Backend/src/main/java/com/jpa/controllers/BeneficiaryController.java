package com.jpa.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jpa.entity.Beneficiary;
import com.jpa.entity.Response;
import com.jpa.entity.User;
import com.jpa.enums.PhysioTherapist;
import com.jpa.enums.TrainerPreference;
import com.jpa.exceptions.BeneficiaryNotFoundException;
import com.jpa.exceptions.NoDataException;
import com.jpa.exceptions.NotAuthorizedException;
import com.jpa.jwt.JwtTokenUtil;
import com.jpa.service.BeneficiaryService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("Beneficiaries")

public class BeneficiaryController {
	Beneficiary change=new Beneficiary();
	Beneficiary beneficiary;
	@Autowired
	BeneficiaryService service;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	User user = null;
	Beneficiary ben = new Beneficiary();
	
	Logger logger = LoggerFactory.getLogger(BeneficiaryController.class);

//Controller Method for getting beneficiary by id
	@GetMapping("{beneficiaryId}")
	public ResponseEntity<Beneficiary> getBeneficiary(@PathVariable("beneficiaryId") int id, HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		String role = user.getRole();
		if(!(role.equals("admin")))
		throw new NotAuthorizedException("Beneficiary can be seen by admin");
		logger.info("Beneficiary with id " + id + " is displayed");
		Beneficiary b = service.getBeneficiary(id);

		return new ResponseEntity<Beneficiary>(b, HttpStatus.OK);
	}

//Controller Method for getting all beneficiaries
	@GetMapping
	public List<Beneficiary> getAll(HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		String role = user.getRole();
		
		if(!(role.equals("admin")))
		throw new NotAuthorizedException("Beneficiary can be seen by admin");
		logger.info("List of all Beneficiaries");
		List<Beneficiary> list= service.getAllBeneficiaries();
		if(list.size()==0) {
			throw new NoDataException("No Data Available");
		}	return list;

	}

//Controller Method for saving beneficiary
	@PostMapping
	public ResponseEntity<?> saveBeneficiary(@Valid @RequestBody Beneficiary b, HttpServletRequest request) {
		
	
		
		ben.setBeneficiaryId(b.getBeneficiaryId());
		ben.setBeneficiaryFirstName(b.getBeneficiaryFirstName());
		ben.setBeneficiaryLastName(b.getBeneficiaryLastName());
		ben.setBeneficiaryAge(b.getBeneficiaryAge());
		ben.setBeneficiaryEmailId(b.getBeneficiaryEmailId());
		ben.setBeneficiaryAddress(b.getBeneficiaryAddress());
		ben.setBeneficiaryMobileNumber(b.getBeneficiaryMobileNumber());
		ben.setHealthPackage(b.getHealthPackage());
		ben.setPreference(b.getPreference());
		ben.setChoice(b.getChoice());		
		switch(String.valueOf(b.getChoice())) {
		case "YES":ben.setChoice(PhysioTherapist.YES);
		break;
		case "NO":ben.setChoice(PhysioTherapist.NO);
		break;
		}
		switch(String.valueOf(b.getPreference())) {
		case "MaleTrainer":ben.setPreference(TrainerPreference.MaleTrainer);
		break;
		case "FemaleTrainer":ben.setPreference(TrainerPreference.FemaleTrainer);
		break;
		}
		
		logger.info("Beneficiary saved");
		service.saveBeneficiary(ben);
		return new ResponseEntity<Response>(
				new Response("User data successfully saved"),HttpStatus.OK);
	
	}

//Controller Method for updating beneficiary
	@PutMapping
	public ResponseEntity<?> updateBeneficiary(@Valid @RequestBody Beneficiary b, HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		String role = user.getRole();
		if(!(role.equals("admin")))
			throw new NotAuthorizedException("Updating of Beneficiary can be done by admin");
		logger.info("Beneficiary updated");
		ben.setBeneficiaryId(b.getBeneficiaryId());
		ben.setBeneficiaryFirstName(b.getBeneficiaryFirstName());
		ben.setBeneficiaryLastName(b.getBeneficiaryLastName());
		ben.setBeneficiaryAge(b.getBeneficiaryAge());
		ben.setBeneficiaryEmailId(b.getBeneficiaryEmailId());
		ben.setBeneficiaryAddress(b.getBeneficiaryAddress());
		ben.setBeneficiaryMobileNumber(b.getBeneficiaryMobileNumber());
		ben.setHealthPackage(b.getHealthPackage());
		ben.setPreference(b.getPreference());
		ben.setChoice(b.getChoice());		
		switch(String.valueOf(b.getChoice())) {
		case "YES":ben.setChoice(PhysioTherapist.YES);
		break;
		case "NO":ben.setChoice(PhysioTherapist.NO);
		break;
		}
		switch(String.valueOf(b.getPreference())) {
		case "MaleTrainer":ben.setPreference(TrainerPreference.MaleTrainer);
		break;
		case "FemaleTrainer":ben.setPreference(TrainerPreference.FemaleTrainer);
		break;
		}
		service.updateBeneficiary(b);
			return new ResponseEntity<Response>(
					new Response("Beneficiary data successfully updated"),HttpStatus.OK);
		}

//Controller Method for deleting beneficiary by id
	@DeleteMapping("{BeneficiaryId}")
	public ResponseEntity<Response> deleteBeneficiary(@PathVariable("BeneficiaryId") int id, HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		String role = user.getRole();
		if(!(role.equals("admin")))
			throw new NotAuthorizedException("Deleting of Beneficiary can be done by admin");
		logger.info("Beneficiary deleted");
		service.deleteBeneficiary(id);
			return  new ResponseEntity<Response>(
					new Response("User data with Id: " + id + " successfully deleted"),HttpStatus.OK);
		}
	
	}

