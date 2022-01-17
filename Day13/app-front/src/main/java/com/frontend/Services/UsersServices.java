package com.frontend.Services;

import com.frontend.Model.Employee;
import com.frontend.Model.Users;
import com.frontend.Repository.UsersProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {
    @Autowired
    private UsersProxy proxy;

    public Boolean checkUser(String email) {
        return proxy.checkUser(email);
    }

    public Users getUser(String email) {
        return proxy.getUser(email);
    }

    public Employee verifyEmployee(Integer id) {
        return proxy.verifyEmployee(id);
    }
}
