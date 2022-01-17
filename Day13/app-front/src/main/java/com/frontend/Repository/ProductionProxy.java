package com.frontend.Repository;


import com.frontend.CustomProperties;
import com.frontend.Model.Production;
import com.frontend.Model.ProductionSite;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class ProductionProxy {

    @Autowired
    private CustomProperties props;

    public HashMap<String, String> getEnergiesByType() {
        String energiesUrl = props.getApiUrl() + "/production/energyByType";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HashMap<String, String>> responseEntity = restTemplate.exchange(energiesUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<HashMap<String, String>>() {
                });
        return responseEntity.getBody();
    }

    public List<Map<String, String>> getEnergiesBySite(){
        String energiesUrl = props.getApiUrl() + "/production/energyBySite";
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Map<String,String>>> entity = template.exchange(energiesUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Map<String, String>>>() {
                });
        return entity.getBody();
    }

    public ArrayList<Map<String,Object>> productionPerSite(){
        String energiesUrl = props.getApiUrl() + "/production/productionPerSite";
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Map<String,Object>>> entity = template.exchange(energiesUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Map<String,Object>>>() {
                });
        return (ArrayList<Map<String,Object>>) entity.getBody();
    }
    
    public Integer totalProductionPerSite(){
        String energiesUrl = props.getApiUrl() + "/production/totalProduction";
        RestTemplate template = new RestTemplate();
        ResponseEntity<Integer> entity = template.exchange(energiesUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<Integer>() {
                });
        return entity.getBody();
    }
}
