package com.frontend.Repository;

import com.frontend.CustomProperties;
import com.frontend.Model.Employee;
import com.frontend.Model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UsersProxy {

    @Autowired
    private CustomProperties props;

    public Boolean checkUser(String email) {
        String usersUrl = props.getApiUrl() + "/users/checkUser?email=" + email;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<Boolean> resp = temp.exchange(usersUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<Boolean>() {
                });
        System.out.println("Code response : " + resp.getStatusCode().toString());
        return resp.getBody();
    }

    public Users getUser(String email) {
        String usersUrl = props.getApiUrl() + "/users/getUser?email=" + email;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<Users> resp = temp.exchange(usersUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<Users>() {
                });
        System.out.println("Code response : " + resp.getStatusCode().toString());
        return resp.getBody();
    }

    public Employee verifyEmployee(Integer id) {
        String usersUrl = props.getApiUrl() + "/employee/verifyEmployee?id=" + id;
        RestTemplate temp = new RestTemplate();
        ResponseEntity<Employee> resp = temp.exchange(usersUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<Employee>() {
                });
        System.out.println("Code response : " + resp.getStatusCode().toString());
        return resp.getBody();
    }
}
