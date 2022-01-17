package com.backend.service.backendservice.repository;

import java.util.List;

import com.backend.service.backendservice.model.Power;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionBeposRepo extends JpaRepository<Power, Integer>{

 @Query(value = "select type from habitation where id_user=:iduser", nativeQuery=true)
 String userRepo(@Param("iduser") Integer id);

 @Query(value = "select room_type from rooms where id_home=:idhome", nativeQuery=true)
 List<String> listRepoRooms(@Param("idhome") Integer id);

 @Query(value = "select distinct(room_type) from rooms", nativeQuery=true)
 List<String> listRepoRoom();

 @Query(value = "select adresse from habitation", nativeQuery=true)
 List<String> listAdressRepo();

 @Query(value = "select equipment_name,room_name, power from power where habitation_name= 'maison'", nativeQuery=true)
 List<String> ConsumPowerRepo();

 @Query(value = "select sum(power) from power;",nativeQuery=true)
 Integer sumPower();


}
