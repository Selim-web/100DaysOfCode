package com.backend.service.backendservice.repository;

import com.backend.service.backendservice.model.ScreenDwp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenDwpRepo extends JpaRepository<ScreenDwp, Integer> {
}
