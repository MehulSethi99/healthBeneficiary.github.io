package com.jpa.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.jpa.entity.HealthPackage;
import com.jpa.entity.Response;
import com.jpa.entity.User;
import com.jpa.exceptions.NoDataException;
import com.jpa.exceptions.NotAuthorizedException;
import com.jpa.jwt.JwtTokenUtil;
import com.jpa.entity.User;
import com.jpa.exceptions.NotAuthorizedException;
import com.jpa.service.HealthPackageService;

@RestController
@RequestMapping("HealthPackages")
@CrossOrigin(origins="http://localhost:4200")
public class PackageController {
	
	@Autowired
	HealthPackageService service;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	User user = null;
	
	Logger logger = LoggerFactory.getLogger(PackageController.class);

	//Controller Method for getting a healthpackage by id
	@GetMapping("{HealthPackageId}")
	public ResponseEntity<?> getHealthPackage(@PathVariable("HealthPackageId") int id, HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		String role = user.getRole();
		if(!(role.equals("admin")))
		throw new NotAuthorizedException(" Health Package can be seen by admin");
		HealthPackage p = service.getHealthPackage(id);

		return new ResponseEntity<HealthPackage>(p, HttpStatus.OK);
	}

	//Controller Method for getting all healthpackages
	@GetMapping
	public List<HealthPackage> getAll( HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		String role = user.getRole();
		if(!(role.equals("admin")))
		throw new NotAuthorizedException("Health Package can be seen by admin");
		logger.info("List of all HealthPackages");
		List <HealthPackage> list = service.getAllHealthPackages();
		if(list.size()==0) {
			throw new NoDataException("No Data Available");
		}return list;
	}

	//Controller Method for saving a healthpackage
	@PostMapping
	public ResponseEntity<?> saveHealthPackage(@Valid @RequestBody HealthPackage p,  HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);

		String role = user.getRole();
		if(!(role.equals("admin")))
			throw new NotAuthorizedException("Saving of HealthPackage can be done by admin");
		logger.info("HealthPackage saved");
		service.saveHealthPackage(p);
		return new ResponseEntity<Response>(
				new Response("HealthPackage with id " + p.getPackageId() + " successfully saved"),
				HttpStatus.CREATED);
	}

	//Controller Method for updating a healthpackage
	@PutMapping
	public ResponseEntity<?> updateHealthPackage(@Valid @RequestBody HealthPackage p,  HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		String role = user.getRole();
		if(!(role.equals("admin")))
			throw new NotAuthorizedException("Updating of HealthPackage can be done by admin");
		logger.info("HealthPackage updated");
		service.updateHealthPackage(p);
		return new ResponseEntity<Response>(
				new Response("HealthPackage with id " + p.getPackageId() + " succesfully updated"), HttpStatus.OK);
	}

	//Controller Method for deleting a healthpackage
	@DeleteMapping("{HealthPackageId}")
	public ResponseEntity<?> delHealthPackage(@PathVariable("HealthPackageId") int id,  HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		String role = user.getRole();
		if(!(role.equals("admin")))
			throw new NotAuthorizedException("Deleting of HealthPackage can be done by admin");
		logger.info("HealthPackage deleted");
		service.deleteHealthPackage(id);
		return new ResponseEntity<Response>(
				new Response("HealthPackage with id " + id + " succesfully deleted"), HttpStatus.OK);
	}
	

}
