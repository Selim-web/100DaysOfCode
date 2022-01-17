package com.backend.service.backendservice.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.backend.service.backendservice.model.Employee;
import com.backend.service.backendservice.repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    public Employee verifyEmployee(Integer id) {
        return repo.verifyEmployee(id);
    }

    public List<Integer> selectIdInBooking(Time time, Date day) {
        return repo.selectIdInBooking(time, day);
    }

    public List<Integer> selectIdOutBooking(Time time, Date day) {
        return repo.selectIdOutBooking(time, day);
    }

    public Employee saveEmployee(Integer id, String status) {
        Employee e = repo.verifyEmployee(id);
        e.setStatus(status);
        return repo.save(e);
    }

    public List<Map<String, String>> selectEmployeeInCompany(Integer id) {
        return repo.selectEmployeeInCompany(id);
    }

}
