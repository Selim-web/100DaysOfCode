package com.frontend.Repository;

import java.util.HashMap;
import java.util.Map;

import com.frontend.CustomProperties;
import com.frontend.Model.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BookingProxy {
    @Autowired
    private CustomProperties props;

    public void saveBooking(Booking booking) {
        String messageUrl = props.getApiUrl() + "/booking/insertBooking";
        HttpEntity<Booking> request = new HttpEntity<Booking>(booking);
        RestTemplate temp = new RestTemplate();
        ResponseEntity<Booking> resp = temp.exchange(messageUrl, HttpMethod.POST, request, Booking.class);
        System.out.println("Code response : " + resp.getStatusCode().toString());
    }

    public void saveMeetingBooking(Booking booking, String listEmployee) {
        Map<String, String> sendedObject = new HashMap<>();
        sendedObject.put("date", booking.getDate());
        sendedObject.put("start", booking.getStart());
        sendedObject.put("end", booking.getEnd());
        sendedObject.put("idPerson", booking.getIdPerson());
        sendedObject.put("idRoom", booking.getIdRoom());
        sendedObject.put("listId", listEmployee);
        sendedObject.put("title", booking.getTitle());

        String messageUrl = props.getApiUrl() + "/booking/insertMeetingBooking";
        HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(sendedObject);
        RestTemplate temp = new RestTemplate();
        ResponseEntity<Map<String, String>> resp = temp.exchange(messageUrl, HttpMethod.POST, request,
                new ParameterizedTypeReference<Map<String, String>>() {
                });
        System.out.println("Code response : " + resp.getStatusCode().toString());
    }
}
