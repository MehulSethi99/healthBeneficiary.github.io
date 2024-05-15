package com.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jpa.entity.User;
import com.jpa.exceptions.DuplicateEntityException;

import com.jpa.exceptions.NoDataException;
import com.jpa.exceptions.UserNotFoundException;
import com.jpa.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository urepo;

	@Override
	public User getUser(String userName) throws UserNotFoundException {
		Optional<User> opt = urepo.findById(userName);
		if (opt.isPresent()) {
			User u = opt.get();
			return u;
		} else {
			throw new UserNotFoundException("Get","User with name  " + userName + " not found");
		}
		
	}

	@Override
	public List<User> getAllUsers() throws NoDataException {
		List<User> list = urepo.findAll();
		if(list.size()==0)
			throw new NoDataException("No Data Available");
		return list;
	}



	@Override
	public void deleteUser(String userName) throws UserNotFoundException {
		if(!(urepo.existsById(userName))) {
			throw new UserNotFoundException("Delete","User  "+userName+" not found");
		}
		urepo.deleteById(userName);
	}

	@Override
	public void saveUser(User user) throws DuplicateEntityException {
		if(urepo.existsById(user.getUserName())) {
			throw new UserNotFoundException("Save","User "+user.getUserName()+" already exists");
		}
		urepo.save(user);
	}
	
	

}
