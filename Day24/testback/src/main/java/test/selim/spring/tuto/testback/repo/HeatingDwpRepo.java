package test.selim.spring.tuto.testback.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.selim.spring.tuto.testback.domain.HeatingDwp;

import javax.transaction.Transactional;


@Repository

public interface HeatingDwpRepo extends JpaRepository<HeatingDwp, Integer> {
    @Query(value = "select temperature_ext from scenario where id=?1", nativeQuery=true)
    Integer getScenario(int id);

    @Transactional
    @Modifying
    @Query(value = "update heating_dwp set temperature=?1 where mode='automatique' and etat='true'", nativeQuery = true)
    public void updateTemperature(int temperature);

    @Transactional
    @Modifying
    @Query(value = "update scenario set temperature_int=?1 where id=?2", nativeQuery = true)
    public void updateInsideTemperature(int temperature, int id);

    @Query(value = "select temperature_int from scenario where id=?1", nativeQuery=true)
    Integer getInsideTemperature(int id);

    @Transactional
    @Modifying
    @Query(value = "insert into scenario(id,temperature_ext, temperature_int) values (?1,?2,?3)", nativeQuery = true)
    public void insertScenario(int id, int temperature_ext, int temperature_int);

}

