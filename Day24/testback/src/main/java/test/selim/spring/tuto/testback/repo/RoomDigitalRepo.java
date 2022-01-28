package test.selim.spring.tuto.testback.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.selim.spring.tuto.testback.domain.RoomDigital;

@Repository
public interface RoomDigitalRepo extends JpaRepository<RoomDigital,Integer> {
}
