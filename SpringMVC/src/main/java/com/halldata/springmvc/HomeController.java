package com.halldata.springmvc;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.halldata.company.dao.CompanyDAO;
import com.halldata.company.model.Company;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model){
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("companyName", getCompany().getCompanyName());
		model.addAttribute("companyCode", getCompany().getCompanyCode());
		model.addAttribute("companyList", getCompanies());
		
		return "home";
	}
	
	public Company getCompany(){
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
		Company company = companyDAO.findByCompanyCode("BNP");
		return company;
	}
	
	public ArrayList<Company> getCompanies(){
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
		ArrayList<Company> companies = companyDAO.getAllCompanies();
		return companies;
	}
	
	@RequestMapping(value = "/primefaces", method = RequestMethod.GET)
	public String primefaces(Locale locale, Model model){
		return "primefaces";
	}
	
}
