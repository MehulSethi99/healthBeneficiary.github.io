package com.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Package_Tbl")
public class HealthPackage {
	
	@Id
	@Column(name = "packageid")
	private int packageId;
	@NotEmpty(message = "Package name can not be empty")
	private String packageName;
	private int packageAmount;
	@OneToMany(mappedBy = "healthPackage")
	@JsonIgnore
	List<Beneficiary> beneficiaries = new ArrayList<>();
	
	public HealthPackage() {
		super();
	
	}

	public HealthPackage(int packageId, String packageName, int packageAmount) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageAmount = packageAmount;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public int getPackageAmount() {
		return packageAmount;
	}

	public void setPackageAmount(int packageAmount) {
		this.packageAmount = packageAmount;
	}

	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	
	@Override
	public String toString() {
		return "PackageId: " + packageId + ", packageName: " + packageName + ", packageAmount: " + packageAmount
				+ ", beneficiaries: " + beneficiaries;
	}

}
