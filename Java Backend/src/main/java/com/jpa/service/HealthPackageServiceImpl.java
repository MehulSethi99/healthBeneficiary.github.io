package com.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entity.HealthPackage;
import com.jpa.exceptions.DuplicateEntityException;
import com.jpa.exceptions.HealthPackageNotFoundException;
import com.jpa.exceptions.NoDataException;
import com.jpa.repository.PackageRepository;

//Implementing the methods of HealthPackageService interface
@Service
public class HealthPackageServiceImpl implements HealthPackageService{
	
	@Autowired
	PackageRepository repository;

	@Override
	public HealthPackage getHealthPackage(int id) throws HealthPackageNotFoundException {
		Optional<HealthPackage> opt = repository.findById(id);
		if (opt.isPresent()) {
			HealthPackage p = opt.get();
			return p;
		} else {
			throw new HealthPackageNotFoundException("Get","HealthPackage with id " + id + " not found");
		}

	}

	@Override
	public List<HealthPackage> getAllHealthPackages() throws NoDataException {
		List<HealthPackage> list = repository.findAll();
		if (list.size() == 0)
			throw new NoDataException("No data available.");
		return list;
	}

	@Override
	public void deleteHealthPackage(int id) throws HealthPackageNotFoundException {
		if (!(repository.existsById(id)))
			throw new HealthPackageNotFoundException("Delete","HealthPackage with id " + id + " not found to delete");
		repository.deleteById(id);
	}

	@Override
	public void updateHealthPackage(HealthPackage pkg) throws HealthPackageNotFoundException {
		if (!(repository.existsById(pkg.getPackageId()))) {
			throw new HealthPackageNotFoundException("Update",
					"HealthPackage with id " + pkg.getPackageId() + " not found to update");

		}
		repository.save(pkg);
	}

	@Override
	public void saveHealthPackage(HealthPackage pkg) throws DuplicateEntityException {
		if(repository.existsById(pkg.getPackageId()))
		{
		throw new HealthPackageNotFoundException("Save","HealthPackage with id "+pkg.getPackageId()+" already exists");
		
		}repository.save(pkg);
	}

}
