package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.entity.HealthPackage;

@Repository
public interface PackageRepository extends JpaRepository<HealthPackage, Integer>{

}
