package com.backend.service.backendservice.repository;

import com.backend.service.backendservice.model.ProductionSite;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionSiteRepo extends CrudRepository<ProductionSite, Integer> 
{
	//scope 3 : exploitation SmartGrid

	//getting the first production site that can provide a capacity greater or equal to the needed energy
	@Query(value = "select * from production_site ps where ps.type =:type and ps.state='f' LIMIT 1", nativeQuery=true)
	ProductionSite ProdSiteByType(@Param("type") String type_site);

	//changing the state of the production site which is currently producing
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update production_site set state ='t' where id_site =:id ;", nativeQuery = true)
	void ProdSiteStateUpdate(@Param("id") Integer id_site);

	//changing the state to false for all the production site that were producing from last time
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update production_site set state ='f';", nativeQuery = true)
	void ProdSiteStateUpdateAll();
}
