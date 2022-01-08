package com.frontend.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.frontend.CustomProperties;
import com.frontend.Model.Company;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CompanyProxy {

	
	@Autowired
	private CustomProperties props;
	

	
	public Integer getLatestId()
	{
		String companyUrl=props.getApiUrl()+"/company/latestId";
		RestTemplate temp=new RestTemplate();
		ResponseEntity<Integer> resp=temp.exchange(companyUrl,HttpMethod.GET,null,new ParameterizedTypeReference<Integer>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
		
	}
	
	public Company getCompany(int id)
	{
		String companyUrl=props.getApiUrl()+"/company/getCompany?id="+id;
		RestTemplate temp=new RestTemplate();
		ResponseEntity<Company> resp=temp.exchange(companyUrl,HttpMethod.GET,null,new ParameterizedTypeReference<Company>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
	}
	public Company getCompanyByName(String name)
	{
		String companyUrl=props.getApiUrl()+"/company/companyName?name="+name;
		RestTemplate temp=new RestTemplate();
		ResponseEntity<Company> resp=temp.exchange(companyUrl,HttpMethod.GET,null,new ParameterizedTypeReference<Company>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
	}
	
	public Iterable<Company> getCompanies() {
		String companyUrl=props.getApiUrl()+"/company/listCompany";
		RestTemplate temp=new RestTemplate();
		ResponseEntity<Iterable<Company>> resp=temp.exchange(companyUrl,HttpMethod.GET,null,new ParameterizedTypeReference<Iterable<Company>>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
	}
	public Company createCompany(Company company)
	{
		String companyUrl=props.getApiUrl()+"/company/createCompany";
		HttpEntity<Company> request=new HttpEntity<Company>(company);
		RestTemplate temp=new RestTemplate();
		ResponseEntity<Company> resp=temp.exchange(companyUrl,HttpMethod.POST,request,Company.class);
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
	}
	public Company updateCompany(Company company)
	{
		String companyUrl=props.getApiUrl()+"/company/updateCompany";
		HttpEntity<Company> request=new HttpEntity<Company>(company);
		RestTemplate temp=new RestTemplate();
		ResponseEntity<Company> resp=temp.exchange(companyUrl,HttpMethod.POST,request,Company.class);
		return resp.getBody();
	}
	public void deleteCompany(Integer id) {
			String companyUrl=props.getApiUrl()+"/company/deleteCompany?id="+id;
			RestTemplate temp=new RestTemplate();
			ResponseEntity<Void> resp=temp.exchange(companyUrl,HttpMethod.DELETE,null,Void.class);
		
	}
}
