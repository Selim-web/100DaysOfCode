package com.backend.service.backendservice.repository;

import com.backend.service.backendservice.model.PlugDwp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlugDwpRepo extends JpaRepository<PlugDwp, Integer> {
}
