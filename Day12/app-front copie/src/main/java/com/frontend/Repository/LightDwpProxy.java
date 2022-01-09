package com.frontend.Repository;

import com.frontend.CustomProperties;
import com.frontend.Model.LightDwp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LightDwpProxy {

    @Autowired
    private CustomProperties props;

    public LightDwp getLight(Integer room_id) {
        String lightUrl = props.getApiUrl()+"/Lumiere/Lumiere?room_id="+room_id;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<LightDwp> resp = temp.exchange(lightUrl, HttpMethod.GET, null, new ParameterizedTypeReference<LightDwp>() {});
        return resp.getBody();
    }

    public LightDwp updateLight(LightDwp lightDwp) {
        String lightUrl = props.getApiUrl()+"/Lumiere/updateLightDwp";
        RestTemplate temp = new RestTemplate();
        HttpEntity<LightDwp> request = new HttpEntity<LightDwp>(lightDwp);
        ResponseEntity<LightDwp> resp = temp.exchange(lightUrl, HttpMethod.POST, request, LightDwp.class);
        return resp.getBody();
    }
}
