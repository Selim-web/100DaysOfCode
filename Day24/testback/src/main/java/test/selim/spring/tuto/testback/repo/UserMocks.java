package test.selim.spring.tuto.testback.repo;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import test.selim.spring.tuto.testback.domain.AppUser;

import java.util.stream.IntStream;

//@Component
public class UserMocks implements InitializingBean {

    private final UserRepository userRepository;

    public UserMocks(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void afterPropertiesSet()throws Exception {
        IntStream
                .range(0,100)
                .forEach(i -> {
                    Faker faker = new Faker();
                    String name = faker.name().firstName();
                    String nickname = "User-" + i;
                    AppUser user = new AppUser(null,name, name+"@gmail.com", "TOTO");
                    userRepository.save(user);
                });
    }

}
