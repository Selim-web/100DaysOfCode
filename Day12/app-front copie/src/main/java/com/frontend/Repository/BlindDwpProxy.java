package com.frontend.Repository;

import com.frontend.CustomProperties;
import com.frontend.Model.BlindDwp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BlindDwpProxy {

    @Autowired
    private CustomProperties properties;

    public BlindDwp getBlind(Integer room_id){
        String blindUrl = properties.getApiUrl()+"/blind/blindById?room_id="+room_id;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<BlindDwp> resp = temp.exchange(blindUrl, HttpMethod.GET, null, new ParameterizedTypeReference<BlindDwp>() {});
        return resp.getBody();
    }

    public BlindDwp updateBlind(BlindDwp blindDwp) {
        String blindUrl = properties.getApiUrl()+"/blind/updateBlindDwp";
        RestTemplate temp = new RestTemplate();
        HttpEntity<BlindDwp> request = new HttpEntity<BlindDwp>(blindDwp);
        ResponseEntity<BlindDwp> resp = temp.exchange(blindUrl, HttpMethod.POST, request, BlindDwp.class);
        return resp.getBody();
    }


}
