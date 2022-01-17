package com.frontend.Repository;

import com.frontend.CustomProperties;
import com.frontend.Model.PlugDwp;
import com.frontend.Model.ScreenDwp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PlugDwpProxy {

    @Autowired
    private CustomProperties properties;

    public PlugDwp getPlug(Integer room_id){
        String plugUrl = properties.getApiUrl()+"/plug/plugById?room_id="+room_id;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<PlugDwp> resp = temp.exchange(plugUrl, HttpMethod.GET, null, new ParameterizedTypeReference<PlugDwp>() {
        });
        return resp.getBody();
    }

    public PlugDwp updatePlug(PlugDwp plugDwp) {
        String plugUrl = properties.getApiUrl()+"/plug/updatePlugDwp";
        RestTemplate temp = new RestTemplate();
        HttpEntity<PlugDwp> request = new HttpEntity<PlugDwp>(plugDwp);
        ResponseEntity<PlugDwp> resp = temp.exchange(plugUrl, HttpMethod.POST, request, PlugDwp.class);
        return resp.getBody();
    }
}
