package com.backend.service.backendservice.repository;

import com.backend.service.backendservice.model.Production;
import com.backend.service.backendservice.model.ProductionSite;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

@Repository
public interface ProductionRepo extends CrudRepository<Production, Integer> {

    @Query(value = "SELECT SUM(producted_quantity) FROM Production", nativeQuery = true)
    Integer totalEnergy();

    @Query(value = "SELECT SUM(producted_quantity)FROM Production" +
            " INNER JOIN production_site ps on ps.id_site = production.fk_site " +
            "WHERE ps.type = 'eolien'", nativeQuery = true)
    Integer energyEolien();

    @Query(value = "SELECT SUM(producted_quantity)FROM Production" +
            " INNER JOIN production_site ps on ps.id_site = Production.fk_site" +
            " WHERE ps.type = 'solaire'", nativeQuery = true)
    Integer energySolaire();

    @Query(value = "SELECT SUM(producted_quantity)FROM Production" +
            " INNER JOIN production_site ps on ps.id_site = Production.fk_site " +
            "WHERE ps.type = 'hydraulique'",
            nativeQuery = true)
    Integer energyHydraulique();

    @Query(value = "SELECT name, SUM(producted_quantity)FROM production INNER JOIN production_site ps on ps.id_site = production.fk_site GROUP BY ps.name",
            nativeQuery = true)
    List<Map<String, String>> energyBySite();
    

  	@Transactional
  	 @Modifying(clearAutomatically = true)
  	@Query(value="delete from production;", nativeQuery = true)
  	void deleteProduction();
  	
  //Deleting the old production to fill in new one
  	@Transactional
  	 @Modifying(clearAutomatically = true)
  	@Query(value="insert into production (fk_site,producted_quantity)values(:id,:quantity) ;", nativeQuery = true)
  	void productionCreation(@Param("id") Integer id_site,@Param("quantity") Integer quantity);
  	
  //retrieving the produced energy per Site
  	@Query(value = "SELECT prod.producted_quantity,ps.id_site,ps.name FROM production prod RIGHT JOIN production_site ps on ps.id_site = prod.fk_site order by ps.id_site;",
            nativeQuery = true)
   List<Map<String,Object>>ProductionPerSite();
  	
  	
    //retrieving the total production of all the production site
  	@Query(value = "SELECT Sum(producted_quantity) FROM production;",
            nativeQuery = true)
  Integer totalProduction();
  	
  	
}

