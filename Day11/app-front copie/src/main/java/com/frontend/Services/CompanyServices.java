package com.frontend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frontend.Model.Company;
import com.frontend.Repository.CompanyProxy;

@Service
public class CompanyServices {

	@Autowired
	private CompanyProxy proxy;
	
	public Integer getLatestId()
	{
		return proxy.getLatestId();
	}
	public Company getCompany(int id)
	{
		return proxy.getCompany(id);
	}
	public Company saveCompany(Company company)
	{
		return proxy.createCompany(company);
	}
	public Company updateCompany(Company company)
	{
		return proxy.updateCompany(company);
	}
	public Company getCompanyByName(String name)
	{
		return proxy.getCompanyByName(name);
	}
	
	public Iterable<Company> getCompanies() {
		return proxy.getCompanies();
	}
	public void deleteCompany(Integer id) {
		 proxy.deleteCompany(id);
		
	}
}
