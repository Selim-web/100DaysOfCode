package com.backend.service.backendservice.repository;

import com.backend.service.backendservice.model.Habitation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitationRepo extends CrudRepository<Habitation,Integer> {

    @Query(nativeQuery = true)
    Habitation selectAdress(@Param("adress") String Adress );
}
