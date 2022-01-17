package com.backend.service.backendservice.repository;

import com.backend.service.backendservice.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface CompanyRepo extends CrudRepository<Company, Integer> {
	
    @Query(value = "select * from Company c where nbbuilding > :nbr ;", nativeQuery=true)
    List<Company> nbBuildingCompany(@Param("nbr") Integer nbr);

    @Query(nativeQuery=true)
    List<Company> findByLocation(@Param("location") String location);

    @Query(nativeQuery=true)
    Integer findCountByLocation(@Param("location") String location);

    @Query(nativeQuery=true)
    Integer findLatestId();
    
    List<Company> findByLocationV2(String location);
}