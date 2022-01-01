package test.selim.spring.tuto.testback.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import test.selim.spring.tuto.testback.domain.AppUser;

public interface UserRepository extends JpaRepository<AppUser,Long> {
}
