package test.selim.spring.tuto.testback;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;
import test.selim.spring.tuto.testback.domain.AppUser;
import test.selim.spring.tuto.testback.repo.UserRepository;

import java.util.List;

@SpringBootTest
public class TestUserData {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenRepo_WhenFetchingAllUser_ThenAreTheyEmpty() {
        List<AppUser> users = userRepository.findAll();
        Assert.isTrue(users.size() != 0,  "Is empty");
    }
}
