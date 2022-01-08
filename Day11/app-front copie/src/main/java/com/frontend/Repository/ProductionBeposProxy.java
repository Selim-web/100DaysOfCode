package com.frontend.Repository;

import java.util.List;
import java.util.Optional;

import com.frontend.CustomProperties;
import com.frontend.Model.Habitation;
import com.frontend.Model.Power;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductionBeposProxy {

 @Autowired
 private CustomProperties props;

 public List<String> typeHabitation(int id) {
     String url = props.getApiUrl() + "/productionBepos/typeHabitation?id="+id+"";
     RestTemplate temp=new RestTemplate();
					ResponseEntity<List<String>> resp=temp.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<List<String>>() {});
					System.out.println("Code response : " + resp.getStatusCode().toString());
					return resp.getBody();
     
 }

	public List<String> listRoom() {
		String url = props.getApiUrl() + "/productionBepos/listRoom1";
		RestTemplate temp=new RestTemplate();
		ResponseEntity<List<String>> resp=temp.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<List<String>>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
		
}

	public String messageBack(){ 
		String url = props.getApiUrl() + "/productionBepos/messageBepos";
		RestTemplate temp = new RestTemplate();
		ResponseEntity<String> resp=temp.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<String>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
	}
 

	public List<String> addressProxy(){
		String addressUrl = props.getApiUrl() + "/productionBepos/listAdresse";
		RestTemplate temp=new RestTemplate();
		ResponseEntity<List<String>> resp=temp.exchange(addressUrl, HttpMethod.GET, null,new ParameterizedTypeReference<List<String>>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
	}

	public Iterable<Power> powerMachine(){
		String powerUrl = props.getApiUrl() + "/productionBepos/findPower";
		RestTemplate temp=new RestTemplate();
		ResponseEntity<Iterable<Power>> resp=temp.exchange(powerUrl, HttpMethod.GET, null,new ParameterizedTypeReference<Iterable<Power>>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
	}

	public Integer sumPower(){
		String powerSum = props.getApiUrl() + "/productionBepos/sum";
		RestTemplate temp=new RestTemplate();
		ResponseEntity<Integer> resp = temp.exchange(powerSum, HttpMethod.GET, null,new ParameterizedTypeReference<Integer>() {});
		System.out.println("Code response : " + resp.getStatusCode().toString());
		return resp.getBody();
	}

}
