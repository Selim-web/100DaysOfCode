package com.frontend.Repository;

import com.frontend.CustomProperties;
import com.frontend.Model.Rooms;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RoomProxy {

    @Autowired
    private CustomProperties props;

    public Rooms getRoom(int id){
        String RoomUrl = props.getApiUrl() + "/Room/getRoom?id="+id;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<Rooms> resp = temp.exchange(RoomUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Rooms>() {});
        System.out.println("Code response : " + resp.getStatusCode().toString());
        return resp.getBody();
    }
    public Iterable<Rooms> listRooms(int id){
        String RoomUrl = props.getApiUrl() + "/Room/ListRooms?id="+id;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<Iterable<Rooms>> resp = temp.exchange(RoomUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<Rooms>>() {});
        System.out.println("Code response : " + resp.getStatusCode().toString());
        return resp.getBody();
    }
}
