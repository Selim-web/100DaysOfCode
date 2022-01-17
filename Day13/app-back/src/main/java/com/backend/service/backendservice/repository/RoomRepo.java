package com.backend.service.backendservice.repository;

import com.backend.service.backendservice.model.Rooms;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends CrudRepository<Rooms,Integer> {

}
