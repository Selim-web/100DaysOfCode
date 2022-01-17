package com.backend.service.backendservice.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.service.backendservice.model.Eco_district;
import com.backend.service.backendservice.model.Entity_map;

@Repository
public interface RankingRepo extends CrudRepository<Entity_map, Integer> {

		//scope 3 : exploitation SmartGrid
		@Query(value = "select type from classement_prov order by rang;", nativeQuery=true)
	    ArrayList<String> energyByRank();
;
}