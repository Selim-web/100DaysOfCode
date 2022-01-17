package com.frontend.Repository;

import com.frontend.CustomProperties;
import com.frontend.Model.heating;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class heatingProxy {

    @Autowired
    private CustomProperties props;

    public heating getHeating(int id){
        String HeatingUrl =props.getApiUrl() +"/heating/getHeating?id"+id;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<heating> resp = temp.exchange(HeatingUrl, HttpMethod.GET, null, new ParameterizedTypeReference<heating>(){});
        System.out.println("Code response : " + resp.getStatusCode().toString());
        return resp.getBody();
    }

    public Iterable<heating> getHeatings(int id){
        String HeatingUrl =props.getApiUrl() +"/heating/ListHeatings?id="+id;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<Iterable<heating>> resp = temp.exchange(HeatingUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<heating>>(){});
        System.out.println("Code response : " + resp.getStatusCode().toString());
        return resp.getBody();
    }

}
