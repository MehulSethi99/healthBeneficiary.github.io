package com.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa.entity.HealthPackage;
import com.jpa.exceptions.DuplicateEntityException;
import com.jpa.exceptions.HealthPackageNotFoundException;
import com.jpa.exceptions.NoDataException;

@Service
public interface HealthPackageService {

	//Declaring the methods 
	HealthPackage getHealthPackage(int id) throws HealthPackageNotFoundException;
	List<HealthPackage> getAllHealthPackages() throws NoDataException;
	void deleteHealthPackage(int id) throws HealthPackageNotFoundException;
	void updateHealthPackage(HealthPackage pkg) throws HealthPackageNotFoundException;
	void saveHealthPackage(HealthPackage pkg) throws DuplicateEntityException;

}
