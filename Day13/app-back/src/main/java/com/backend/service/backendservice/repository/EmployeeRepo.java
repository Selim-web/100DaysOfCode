package com.backend.service.backendservice.repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.backend.service.backendservice.model.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
    @Query(nativeQuery = true)
    Employee verifyEmployee(@Param("id") Integer id);

    @Query(nativeQuery = true)
    List<Integer> selectIdInBooking(@Param("time") Time time, @Param("day") Date day);

    @Query(nativeQuery = true)
    List<Integer> selectIdOutBooking(@Param("time") Time time, @Param("day") Date day);

    @Query(nativeQuery = true)
    List<Map<String, String>> selectEmployeeInCompany(@Param("id") Integer id);
}
