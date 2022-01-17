package com.backend.service.backendservice.controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.backend.service.backendservice.model.Employee;
import com.backend.service.backendservice.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    /**
     * Select - verify if user is an employee
     *
     * @param id of one user
     * @return employee
     */
    @GetMapping(value = "/verifyEmployee")
    public Employee verifyEmployee(@RequestParam("id") Integer id) {
        return service.verifyEmployee(id);
    }

    /**
     * Select - employees from a company
     *
     * @param id of the user
     * @return employees of the same company
     */
    @CrossOrigin(origins = { "http://localhost:9001", "http://172.31.250.12:9001", "http://172.31.249.241:9001" })
    @GetMapping(value = "/employeeInCompany")
    public List<Map<String, String>> listEmployeeInCompany(@RequestParam("id") Integer id) {
        return service.selectEmployeeInCompany(id);
    }

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * Update - update status of employe if a booking with him starts
     * refresh all 1 minute
     *
     * @return employee
     */
    @Scheduled(fixedRate = 180000)
    public void checkStatusOccupy() {
        Date now = new Date();
        Time time = convertTime(dateFormat.format(now));
        System.out.println(now + "----------------------------");

        String status = "free";
        List<Integer> listIdForFree = service.selectIdOutBooking(time, now);
        System.out.println("employe for freee");
        for (int i = 0; i < listIdForFree.size(); i++) {
            System.out.println("employe qu 'on met free' : " + listIdForFree.get(i) +
                    "aaaa");
            service.saveEmployee(listIdForFree.get(i), status);
        }

        List<Integer> listIdForOccupy = service.selectIdInBooking(time, now);
        status = "occupy";
        System.out.println("employe for occupy");
        for (int i = 0; i < listIdForOccupy.size(); i++) {
            System.out.println("employe qu 'on met occupé' : " + listIdForOccupy.get(i) + "aaaa");
            service.saveEmployee(listIdForOccupy.get(i), status);
        }
    }

    public Time convertTime(String startTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        long ms = 00;
        try {
            ms = sdf.parse(startTime).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Time convertedTime = new Time(ms);
        return convertedTime;
    }

    public LocalDate convertDate(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate aptDate = null;
        try {
            aptDate = LocalDate.parse(date, dateFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aptDate;
    }

}
