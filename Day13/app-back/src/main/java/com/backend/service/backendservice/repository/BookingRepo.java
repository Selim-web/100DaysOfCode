package com.backend.service.backendservice.repository;

import java.time.LocalDate;
import java.util.*;

import com.backend.service.backendservice.model.AttendMeeting;
import com.backend.service.backendservice.model.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends CrudRepository<Booking, Integer> {

    @Query(nativeQuery = true)
    int selectMaxId();

    @Query(nativeQuery = true)
    List<Map<String, String>> selectRoomBooked(@Param("id") Integer id, @Param("today") LocalDate today);

}
