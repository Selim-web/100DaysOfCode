package test.selim.spring.tuto.testback.repo;

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
                .range(0,25)
                .forEach(i -> {
                    String nickname = "user-" + i;
                    AppUser user = new AppUser(null,nickname, nickname+"@gmail.com", "TOTOTO");
                    userRepository.save(user);
                });
    }

}
