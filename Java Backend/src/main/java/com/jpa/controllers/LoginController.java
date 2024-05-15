package com.jpa.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.User;
import com.jpa.exceptions.InvalidUserException;
import com.jpa.jwt.LoginData;
import com.jpa.jwt.TokenEntity;
import com.jpa.jwt.JwtTokenUtil;
import com.jpa.repository.UserRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/login")

public class LoginController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	UserRepository userRepository;

	
	
	User user;

	@PostMapping
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginData data) throws Exception {

		Optional<User> userData = userRepository.findById(data.getUserName());

		if (userData.isPresent()) {
			user = userData.get();
		} else {
			throw new InvalidUserException("User not found with username: " + data.getUserName());
		}

		if (!(user.getPassword().equals(data.getPassword())))
			throw new InvalidUserException("Invalid Password");

		String token = jwtTokenUtil.generateToken(user);

		return ResponseEntity.ok(new TokenEntity(token));

	}

}
