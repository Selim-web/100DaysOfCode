package com.backend.service.backendservice.repository;

import com.backend.service.backendservice.model.RoomDwp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDwpRepo extends JpaRepository<RoomDwp, Long> {
}
