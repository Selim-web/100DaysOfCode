package com.backend.service.backendservice.service;

import java.util.List;
import java.util.Map;

import com.backend.service.backendservice.model.AttendMeeting;
import com.backend.service.backendservice.repository.AttendMeetingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendMeetingService {

    @Autowired
    private AttendMeetingRepo repo;

    public int selectMaxId() {
        return repo.selectMaxIdAttend();
    }

    public AttendMeeting insertAttend(AttendMeeting attender) {
        return repo.save(attender);
    }

    public List<Map<String, String>> selectEventForOneUser(Integer idUser) {
        return repo.selectEventForOneUser(idUser);
    }

}
