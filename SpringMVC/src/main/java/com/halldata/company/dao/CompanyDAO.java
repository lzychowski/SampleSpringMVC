package com.halldata.company.dao;

import java.util.ArrayList;

import com.halldata.company.model.Company;

public interface CompanyDAO
{
	//public void insert(Company company);
	public Company findByCompanyCode(String companyCode);
	
	public ArrayList<Company> getAllCompanies();
}