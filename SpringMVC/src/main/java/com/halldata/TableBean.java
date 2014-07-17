package com.halldata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.halldata.company.dao.CompanyDAO;
import com.halldata.company.model.Company;

public class TableBean
{
	private List<Company> companyList;
	
	public TableBean(){
		companyList = getCompanies();
	}
	
	public List<Company> getCompanyList() {
		return companyList;
	}
	
	public ArrayList<Company> getCompanies(){
		System.out.println("getCompanies");
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
		ArrayList<Company> companies = companyDAO.getAllCompanies();
		return companies;
	}
}