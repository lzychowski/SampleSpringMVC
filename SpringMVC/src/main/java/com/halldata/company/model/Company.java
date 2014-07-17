package com.halldata.company.model;

import java.sql.Timestamp;

public class Company
{
	String companyCode;
	String companyName;
	
	public Company(String companyCode, String companyName){
		this.companyCode = companyCode;
		this.companyName = companyName;
	}
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Override
	public String toString(){
		return "Company Code: " + companyCode + ", Company Name: " + companyName;
	}
	
}