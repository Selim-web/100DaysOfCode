package com.backend.service.backendservice.repository;

import com.backend.service.backendservice.model.heating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface heatingRepo extends CrudRepository<heating,Integer> {

}
