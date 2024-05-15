package com.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.jpa.enums.PhysioTherapist;
import com.jpa.enums.TrainerPreference;

@Entity
@Table(name = "Beneficiary_Tbl")
public class Beneficiary {
	
	@Id
	
	@GeneratedValue()
	private int beneficiaryId;
	
	
	@NotNull(message = "First name can not be blank")
	@Length(min = 5, max = 20,message="Length of name should be between 5 and 20")
	private String beneficiaryFirstName;
	
	@Pattern(regexp = "^([a-zA-Z]+)$")
	@NotNull(message = "Last name can not be blank")
	private String beneficiaryLastName;
	
	@Min(18)
	@Max(60)
	private int beneficiaryAge;
	
	@Email(message = "Please enter valid email address")
	private String beneficiaryEmailId;
	
	@NotEmpty(message = "Address can not be blank")
	private String beneficiaryAddress;
	
	@Pattern(regexp="^([1-9][0-9]{9})$")
	@NotBlank(message = "Please enter valid mobile number")
	private String beneficiaryMobileNumber;
	
	@ManyToOne
	@JoinColumn(name = "packageid")
	private HealthPackage healthPackage;
	private TrainerPreference preference;
	private PhysioTherapist choice;
	public Beneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Beneficiary(int beneficiaryId, @Pattern(regexp = "^([a-zA-Z]+)$") @NotNull String beneficiaryFirstName,
			@Pattern(regexp = "^([a-zA-Z]+)$") @NotNull String beneficiaryLastName,
			@Min(18) @Max(60) int beneficiaryAge, @Email String beneficiaryEmailId, @NotEmpty String beneficiaryAddress,
			@Pattern(regexp = "^([1-9][0-9]{9})$") String beneficiaryMobileNumber, HealthPackage healthPackage,
			TrainerPreference preference, PhysioTherapist choice) {
		super();
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryFirstName = beneficiaryFirstName;
		this.beneficiaryLastName = beneficiaryLastName;
		this.beneficiaryAge = beneficiaryAge;
		this.beneficiaryEmailId = beneficiaryEmailId;
		this.beneficiaryAddress = beneficiaryAddress;
		this.beneficiaryMobileNumber = beneficiaryMobileNumber;
		this.healthPackage = healthPackage;
		this.preference = preference;
		this.choice = choice;
	}


	public int getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public String getBeneficiaryFirstName() {
		return beneficiaryFirstName;
	}
	public void setBeneficiaryFirstName(String beneficiaryFirstName) {
		this.beneficiaryFirstName = beneficiaryFirstName;
	}
	public String getBeneficiaryLastName() {
		return beneficiaryLastName;
	}
	public void setBeneficiaryLastName(String beneficiaryLastName) {
		this.beneficiaryLastName = beneficiaryLastName;
	}
	public int getBeneficiaryAge() {
		return beneficiaryAge;
	}
	public void setBeneficiaryAge(int beneficiaryAge) {
		this.beneficiaryAge = beneficiaryAge;
	}
	public String getBeneficiaryEmailId() {
		return beneficiaryEmailId;
	}
	public void setBeneficiaryEmailId(String beneficiaryEmailId) {
		this.beneficiaryEmailId = beneficiaryEmailId;
	}
	public String getBeneficiaryAddress() {
		return beneficiaryAddress;
	}
	public void setBeneficiaryAddress(String beneficiaryAddress) {
		this.beneficiaryAddress = beneficiaryAddress;
	}
	public String getBeneficiaryMobileNumber() {
		return beneficiaryMobileNumber;
	}
	public void setBeneficiaryMobileNumber(String beneficiaryMobileNumber) {
		this.beneficiaryMobileNumber = beneficiaryMobileNumber;
	}
	public HealthPackage getHealthPackage() {
		return healthPackage;
	}
	public void setHealthPackage(HealthPackage healthPackage) {
		this.healthPackage = healthPackage;
	}
	public TrainerPreference getPreference() {
		return preference;
	}
	public void setPreference(TrainerPreference preference) {
		this.preference = preference;
	}
	public PhysioTherapist getChoice() {
		return choice;
	}
	public void setChoice(PhysioTherapist choice) {
		this.choice = choice;
	}
	@Override
	public String toString() {
		return "Beneficiary [beneficiaryId=" + beneficiaryId + ", beneficiaryFirstName=" + beneficiaryFirstName
				+ ", beneficiaryLastName=" + beneficiaryLastName + ", beneficiaryAge=" + beneficiaryAge
				+ ", beneficiaryEmailId=" + beneficiaryEmailId + ", beneficiaryAddress=" + beneficiaryAddress
				+ ", beneficiaryMobileNumber=" + beneficiaryMobileNumber + ", healthPackage=" + healthPackage
				+ ", preference=" + preference + ", choice=" + choice + "]";
	}
	
}
