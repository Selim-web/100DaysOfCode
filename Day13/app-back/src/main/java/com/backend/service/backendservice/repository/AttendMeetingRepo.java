package com.backend.service.backendservice.repository;

import java.util.List;
import java.util.Map;

import com.backend.service.backendservice.model.AttendMeeting;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AttendMeetingRepo extends CrudRepository<AttendMeeting, Integer> {
    @Query(nativeQuery = true)
    int selectMaxIdAttend();

    @Query(nativeQuery = true)
    List<Map<String, String>> selectEventForOneUser(@Param("idUser") Integer idUser);
}
