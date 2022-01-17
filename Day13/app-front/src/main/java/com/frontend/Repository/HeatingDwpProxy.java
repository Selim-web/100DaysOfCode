package com.frontend.Repository;

import com.frontend.CustomProperties;
import com.frontend.Model.HeatingDwp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class HeatingDwpProxy {

    @Autowired
    private CustomProperties props;


    public HeatingDwp getHeating(Integer room_id) {
        String heatingUrl = props.getApiUrl() + "/chauffage/chauffage?room_id=" + room_id;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<HeatingDwp> resp = temp.exchange(heatingUrl, HttpMethod.GET, null, new ParameterizedTypeReference<HeatingDwp>() {
        });
        return resp.getBody();
    }

    public Integer getScenario() {
        String heatingUrl = props.getApiUrl() + "/chauffage/";
        RestTemplate temp = new RestTemplate();
        ResponseEntity<Integer> resp = temp.exchange(heatingUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Integer>() {
        });
        return resp.getBody();
    }

    public HeatingDwp updateHeating(HeatingDwp heatingDwp) {
        System.out.println(heatingDwp + " recu par le proxy pour envoi au backend");
        String heatingUrl = props.getApiUrl() + "/chauffage/updateChauffage";
        RestTemplate temp = new RestTemplate();
        HttpEntity<HeatingDwp> request = new HttpEntity<HeatingDwp>(heatingDwp);
        ResponseEntity<HeatingDwp> resp = temp.exchange(heatingUrl, HttpMethod.POST, request, HeatingDwp.class);
        return resp.getBody();
    }
}
