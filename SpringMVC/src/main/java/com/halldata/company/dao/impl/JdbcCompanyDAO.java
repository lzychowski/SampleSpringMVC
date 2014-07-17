package com.halldata.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;
import com.halldata.company.dao.CompanyDAO;
import com.halldata.company.model.Company;

public class JdbcCompanyDAO implements CompanyDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public Company findByCompanyCode(String companyCode){
		
		String sql = "SELECT CLIENT_CD,CLIENT_NAME FROM [iQApplicationDB].[dbo].[CLIENT_T] WHERE CLIENT_CD = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, companyCode);
			Company company = null;
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				company = new Company(
						rs.getString("CLIENT_CD"),
						rs.getString("CLIENT_NAME")
						);
			}
			
			rs.close();
			ps.close();
			
			return company;
			
		} catch (SQLException e){
			throw new RuntimeException(e);
		} finally {
			
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e){}
			}
			
		}
	}
	
	public ArrayList<Company> getAllCompanies(){
		System.out.println("getAllCompanies");
		
		String sql = "SELECT CLIENT_CD,CLIENT_NAME FROM [iQApplicationDB].[dbo].[CLIENT_T]";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ArrayList<Company> companyArrayList = new ArrayList<Company>();
			Company company = null;
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				company = new Company(
						rs.getString("CLIENT_CD"),
						rs.getString("CLIENT_NAME")
						);
				companyArrayList.add(company);
			}
			
			rs.close();
			ps.close();
			
			return companyArrayList;
			
		} catch (SQLException e){
			throw new RuntimeException(e);
		} finally {
			
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e){}
			}
			
		}
	}
}