package com.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.entity.Beneficiary;
import com.jpa.entity.HealthPackage;
import com.jpa.entity.User;
import com.jpa.enums.PhysioTherapist;
import com.jpa.enums.TrainerPreference;
import com.jpa.repository.BeneficiaryRepository;
import com.jpa.repository.UserRepository;
import com.jpa.repository.PackageRepository;


@Component
public class DataInit implements CommandLineRunner{
	
	@Autowired
	BeneficiaryRepository beneficiaryRepo;
	
	@Autowired
	PackageRepository packageRepo;
	
	@Autowired
	UserRepository userRepo;
	
	Logger logger = (Logger) LoggerFactory.getLogger(DataInit.class);
	
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("Database Initialization started");
		
//Data for Login
		userRepo.save(new User( "Mehul", "Mehul", "admin"));
		userRepo.save(new User( "Pradeep", "Pradeep", "user"));
		userRepo.save(new User( "Sachin", "Sachin", "user"));
		userRepo.save(new User( "Samruddhi", "Samruddhi", "user"));
		userRepo.save(new User("Praveen", "Praveen", "user"));
		
		logger.info("Account details inserted into the database");

//Data for Packages
		HealthPackage p1 = packageRepo.save(new HealthPackage(1, "One time assesment only", 500));
		HealthPackage p2 = packageRepo.save(new HealthPackage(2, "Four sessions per week(400rs per session)", 1600));
		HealthPackage p3 = packageRepo.save(new HealthPackage(3, "Five sessions per week(300rs per session)", 1500));
		
		logger.info("Package details inserted into the database");

		
//Data for Beneficiary	
		beneficiaryRepo.save(new Beneficiary(1, "Pradeep","Phulse", 23, "pradeep@gmail.com", "M.G.Road, Bengaluru,Karnataka, India, 560018", "9946855015", p1, TrainerPreference.MaleTrainer, PhysioTherapist.NO));
		beneficiaryRepo.save(new Beneficiary(2, "Praveen","Shrungeri", 23, "praveen@gmail.com", "S.G.Road, Bengaluru,Karnataka, India, 560015", "9946850145", p3, TrainerPreference.MaleTrainer, PhysioTherapist.NO));
		beneficiaryRepo.save(new Beneficiary(3, "Sachin","Biradar", 23, "Sachin@gmail.com", "M.K.Road, Bengaluru,Karnataka, India, 560017", "8866855015", p2, TrainerPreference.MaleTrainer, PhysioTherapist.NO));
		beneficiaryRepo.save(new Beneficiary(4, "Samruddhi","More", 23, "Samruddhi@gmail.com", "A.G.Road, Bengaluru,Karnataka, India, 560014", "7854855015", p2, TrainerPreference.FemaleTrainer, PhysioTherapist.NO));
		
		
		logger.info("Beneficiary details inserted into the database");
	}

}
