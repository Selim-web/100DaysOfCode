package com.backend.service.backendservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Map;
import com.backend.service.backendservice.model.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends CrudRepository<Message, Integer> {

    @Query(nativeQuery = true)
    List<Message> findAllMessagesBetweenTwoPeople(@Param("id_sender") Integer id_sender,
            @Param("id_receiver") Integer id_receiver);

    @Query(nativeQuery = true)
    List<Map<String, String>> findAllContactOfOneUser(@Param("id_sender") Integer id_sender,
            @Param("idCompany") Integer idCompany);

    @Query(nativeQuery = true)
    Integer lastId();
}
