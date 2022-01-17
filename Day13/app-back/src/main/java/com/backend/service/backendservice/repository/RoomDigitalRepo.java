package com.backend.service.backendservice.repository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.backend.service.backendservice.model.RoomDigital;

@Repository
public interface RoomDigitalRepo extends CrudRepository<RoomDigital, Integer> {
    @Query(nativeQuery = true)
    ArrayList<Map<String, String>> getRooms();

    @Query(nativeQuery = true)
    ArrayList<Map<String, String>> getMeetingRooms();

    // openSpace
    @Query(nativeQuery = true)
    ArrayList<Map<String, String>> getRoomsWithSearchOpenSpace(@Param("endTime") Time endTime,
            @Param("startTime") Time startTime, @Param("day") LocalDate day);

    // salleTravail
    @Query(nativeQuery = true)
    ArrayList<Map<String, String>> getRoomsWithSearchSalleTravail(@Param("endTime") Time endTime,
            @Param("startTime") Time startTime, @Param("day") LocalDate day);

    // bureauSolo
    @Query(nativeQuery = true)
    ArrayList<Map<String, String>> getRoomsWithSearchBureauSolo(@Param("endTime") Time endTime,
            @Param("startTime") Time startTime, @Param("day") LocalDate day);

    // bureauSolo
    @Query(nativeQuery = true)
    ArrayList<Map<String, String>> getRoomsWithSearchMeetingRoom(@Param("endTime") Time endTime,
                    @Param("startTime") Time startTime, @Param("day") LocalDate day);

}
