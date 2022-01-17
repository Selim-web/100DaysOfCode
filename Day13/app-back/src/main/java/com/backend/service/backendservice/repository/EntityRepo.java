package com.backend.service.backendservice.repository;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.service.backendservice.model.Eco_district;
import com.backend.service.backendservice.model.Entity_map;

@Repository
public interface EntityRepo extends CrudRepository<Entity_map, Integer> {

		//scope 3 : exploitation SmartGrid
		@Query(value = "select Sum(quant_cons) as C from entity_map em  where em.id_ecdt= :id ;", nativeQuery=true)
	    Integer districtConso(@Param("id") Integer id);
		@Query(value = "select Sum(quant_prod) as P from entity_map em where em.id_ecdt= :id ;", nativeQuery=true)
	    Integer districtProd(@Param("id") Integer id);
	    @Query(value = "select id_ecdt from eco_district ;", nativeQuery=true)
	    List<Integer> listIdEcoDistrict();
	    @Query(value = "select * from entity_map where id_ecdt= :id and quant_cons>quant_prod LIMIT 1;", nativeQuery=true)
	    Entity_map getEntity(@Param("id") Integer id);
	    
	    //providing energy to the entity lacking energy
	    @Transactional
		@Modifying(clearAutomatically = true)
		@Query(value="update entity_map set quant_prod= quant_prod+ :provided_energy where id_entity= :id ;", nativeQuery = true)
		void provideEntergyEntity(@Param("id") Integer id_ecdt,@Param("provided_energy") Integer provided_energy);
	    
	    @Query(value = "select id_ecdt from entity_map  where quant_cons-quant_prod<= :provided_energy and quant_cons>quant_prod  LIMIT 1 ;", nativeQuery=true)
	    Integer adequatDistrict(@Param("provided_energy") Integer provided_energy);
}