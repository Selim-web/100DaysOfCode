package com.frontend.Repository;

import com.frontend.CustomProperties;
import com.frontend.Model.ScreenDwp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScreenDwpProxy {

    @Autowired
    private CustomProperties properties;

    public ScreenDwp getScreen(Integer room_id){
        String screenUrl = properties.getApiUrl()+"/screen/screenById?room_id="+room_id;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<ScreenDwp> resp = temp.exchange(screenUrl, HttpMethod.GET, null, new ParameterizedTypeReference<ScreenDwp>() {
        });
        return resp.getBody();
    }

    public ScreenDwp updateScreen(ScreenDwp screenDwp) {
        String screenUrl = properties.getApiUrl()+"/screen/updateScreenDwp";
        RestTemplate temp = new RestTemplate();
        HttpEntity<ScreenDwp> request = new HttpEntity<ScreenDwp>(screenDwp);
        ResponseEntity<ScreenDwp> resp = temp.exchange(screenUrl, HttpMethod.POST, request, ScreenDwp.class);
        return resp.getBody();
    }
}
