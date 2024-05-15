package com.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa.entity.User;
import com.jpa.exceptions.DuplicateEntityException;
import com.jpa.exceptions.NoDataException;
import com.jpa.exceptions.UserNotFoundException;

@Service
public interface UserService {
User getUser(String userName) throws UserNotFoundException;
	
	List<User> getAllUsers() throws NoDataException;

	

	void deleteUser(String userName) throws UserNotFoundException;

	void saveUser(User user) throws DuplicateEntityException;
}
