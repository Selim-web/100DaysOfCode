package com.backend.service.backendservice.repository;

import com.backend.service.backendservice.model.BlindDwp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlindDwpRepo extends JpaRepository<BlindDwp, Integer> {
}
