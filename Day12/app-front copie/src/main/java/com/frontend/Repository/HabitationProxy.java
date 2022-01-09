package com.frontend.Repository;

import com.frontend.CustomProperties;
import com.frontend.Model.Habitation;
import com.frontend.Model.Rooms;
import com.frontend.Model.heating;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Slf4j
@Component
public class HabitationProxy {

    @Autowired
    private CustomProperties props;

    public Iterable<Habitation> getHomes() {
        String HomeUrl = props.getApiUrl() + "/Home/listHome";
        RestTemplate temp = new RestTemplate();
        ResponseEntity<Iterable<Habitation>> resp = temp.exchange(HomeUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<Habitation>>() {});
        System.out.println("Code response : " + resp.getStatusCode().toString());
    return resp.getBody();
    }

    public Habitation getHome(int id){
        String HomeUrl = props.getApiUrl() + "/Home/getHome?id="+id;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<Habitation> resp = temp.exchange(HomeUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Habitation>() {});
        System.out.println("Code response : " + resp.getStatusCode().toString());
        System.out.println("address from proxy "+resp.getBody().getAdress());
        return resp.getBody();
    }

    public HashMap<Integer, HashMap<String,Iterable<heating>>> HomeInfo(){
        String HomeUrl = props.getApiUrl() +"/Home/HomeInfo";
        RestTemplate temp = new RestTemplate();
        ResponseEntity<HashMap<Integer, HashMap<String,Iterable<heating>>>> resp = temp.exchange(HomeUrl,HttpMethod.GET,null,new ParameterizedTypeReference<HashMap<Integer, HashMap<String,Iterable<heating>>>>(){});
        System.out.println("Code response : " + resp.getStatusCode().toString());
        return resp.getBody();
    }


}
