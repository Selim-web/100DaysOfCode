package com.frontend.Repository;

import com.frontend.CustomProperties;
import com.frontend.Model.RoomDigital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EquipmentProxy {

    @Autowired
    private CustomProperties props;

    public RoomDigital getEquipmentRoom(Integer room_id) {
        String url = props.getApiUrl()+"/roomDigital/roomById?room_id="+room_id;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<RoomDigital> resp = temp.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<RoomDigital>() {
        });
        return resp.getBody();
    }

    public RoomDigital updateRoom(RoomDigital roomDigital) {
        System.out.println(roomDigital);
        String url = props.getApiUrl()+"/Lumiere/updateRoom";
        RestTemplate temp = new RestTemplate();
        HttpEntity<RoomDigital> request = new HttpEntity<RoomDigital>(roomDigital);
        ResponseEntity<RoomDigital> resp = temp.exchange(url,HttpMethod.POST, request,RoomDigital.class);
        return resp.getBody();
    }
}
