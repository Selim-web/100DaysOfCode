package test.selim.spring.tuto.testback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.selim.spring.tuto.testback.repo.UserRepository;

@SpringBootApplication
public class TestbackApplication {

    public static void main(String[] args) {

        SpringApplication.run(TestbackApplication.class, args);
    }

}
