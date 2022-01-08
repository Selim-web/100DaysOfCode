package com.frontend.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.frontend.CustomProperties;
import com.frontend.Model.Company;
import com.frontend.Model.Eco_district;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EntityProxy {

	
	@Autowired
	private CustomProperties props;
	

	
	public Integer getDistCons(Integer id)
	{
		String companyUrl=props.getApiUrl()+"/entity/distCons/"+id;
		RestTemplate temp=new RestTemplate();
		ResponseEntity<Integer> resp=temp.exchange(companyUrl,HttpMethod.GET,null,new ParameterizedTypeReference<Integer>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
		
	}
	public Integer EnergyStateByCity()
	{
		String companyUrl=props.getApiUrl()+"/entity/EnergieCity";
		RestTemplate temp=new RestTemplate();
		ResponseEntity<Integer> resp=temp.exchange(companyUrl,HttpMethod.GET,null,new ParameterizedTypeReference<Integer>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
		
	}
	public Integer getDistProd(Integer id)
	{
		String companyUrl=props.getApiUrl()+"/entity/distProd/"+id;
		RestTemplate temp=new RestTemplate();
		ResponseEntity<Integer> resp=temp.exchange(companyUrl,HttpMethod.GET,null,new ParameterizedTypeReference<Integer>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
		
	}
	
	
	public IdentityHashMap<Integer, IdentityHashMap<Integer, Integer>> energyStateByDistrict()
	{
		String companyUrl=props.getApiUrl()+"/entity/EnergieDistricts";
		RestTemplate temp=new RestTemplate();
		ResponseEntity<IdentityHashMap<Integer, IdentityHashMap<Integer, Integer>>> resp=temp.exchange(companyUrl,HttpMethod.GET,null,new ParameterizedTypeReference<IdentityHashMap<Integer, IdentityHashMap<Integer, Integer>>>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		for(Integer i: resp.getBody().keySet()) {System.out.println("i= "+i);}
		return resp.getBody();
		
	}
}
