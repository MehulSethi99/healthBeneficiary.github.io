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

import com.jpa.entity.Response;
import com.jpa.entity.User;
import com.jpa.exceptions.NotAuthorizedException;
import com.jpa.exceptions.UserNotFoundException;
import com.jpa.jwt.JwtTokenUtil;
import com.jpa.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("Users")

public class UserController {

	@Autowired
	UserService service;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	User user = null;
	
	Logger logger = LoggerFactory.getLogger(BeneficiaryController.class);

	@GetMapping("{UserName}")
	public ResponseEntity<User> getUser(@PathVariable("UserName") String userName, HttpServletRequest request)
	{
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		String role = user.getRole();
		if(!(role.equals("admin")))
		throw new NotAuthorizedException("User can be seen by admin");
		logger.info("User with id " + userName + " is displayed");
		User u = service.getUser(userName);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	@GetMapping
	public List<User> getAll(HttpServletRequest request){
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		String role = user.getRole();
		if(!(role.equals("admin")))
		throw new NotAuthorizedException("User can be seen by admin");
		logger.info("List of all User");
		return service.getAllUsers();
	}
	
	@PostMapping
	public ResponseEntity<?> saveUser(@Valid @RequestBody User u, HttpServletRequest request){
			
		logger.info("New User created");
		service.saveUser(u);
		return new ResponseEntity<Response>(
				new Response("User with id"+u.getUserName()+" succesfully created"), HttpStatus.OK);
	}
	
	@DeleteMapping("{userName}")
	public ResponseEntity<Response> deleteUser(@PathVariable("UserId") String userName, HttpServletRequest request){
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		String role = user.getRole();
		if(!(role.equals("admin")))
			throw new NotAuthorizedException("User of Beneficiary can be done by admin");
		logger.info("User deleted");
		service.deleteUser(userName);
			return new ResponseEntity<Response>(
				new Response("User with username "+userName+ " succesfully deleted"), HttpStatus.OK);
		}
}
