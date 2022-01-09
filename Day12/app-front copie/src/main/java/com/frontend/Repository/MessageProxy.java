package com.frontend.Repository;

import java.util.List;
import java.util.Map;

import com.frontend.CustomProperties;
import com.frontend.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageProxy {

    @Autowired
    private CustomProperties props;

    public List<Message> getMessages(Integer id_sender, Integer id_receiver) {
        String messageUrl = props.getApiUrl() + "/messages/getMessages?id_sender=" + id_sender + "&id_receiver="
                        + id_receiver;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<List<Message>> resp = temp.exchange(messageUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Message>>() {
                });
        System.out.println("Code response : " + resp.getStatusCode().toString());
        return resp.getBody();
    }

    public List<Map<String, String>> getContacts(Integer id_sender, Integer idCompany) {
        String messageUrl = props.getApiUrl() + "/messages/getContacts?id_sender=" + id_sender + "&id_company="
                        + idCompany;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<List<Map<String, String>>> resp = temp.exchange(messageUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Map<String, String>>>() {
                });
        System.out.println("Code response : " + resp.getStatusCode().toString());
        return resp.getBody();
    }
}
