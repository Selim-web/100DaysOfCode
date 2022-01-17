package com.backend.service.backendservice.repository;

import com.backend.service.backendservice.model.HeatingDwp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface HeatingDwpRepo extends JpaRepository<HeatingDwp, Integer> {
    @Query(value = "select * from scenario;", nativeQuery=true)
    Integer getScenario();

}
