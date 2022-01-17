package com.backend.service.backendservice.repository;

import com.backend.service.backendservice.model.LightDwp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightDwpRepo extends JpaRepository<LightDwp, Integer> {
}
