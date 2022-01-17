package com.backend.service.backendservice.repository;

import java.util.List;
import java.util.Map;

import com.backend.service.backendservice.model.Favoris;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FavorisRepo extends CrudRepository<Favoris, Integer> {
    @Query(nativeQuery = true)
    List<Map<String, String>> selectFavorisOFOneUser(@Param("idPerson") Integer idPerson);

    @Query(nativeQuery = true)
    Integer verifyTwoPeopleFavoris(@Param("idSender") Integer idSender, @Param("idReceiver") Integer idReceiver);

}
