package test.selim.spring.tuto.testback.services;


import org.springframework.stereotype.Service;
import test.selim.spring.tuto.testback.domain.AppUser;
import test.selim.spring.tuto.testback.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<AppUser> getUserList() {
        return userRepository.findAll();
    }

    public Optional<AppUser> findUserById(Long id){
        return userRepository.findById(id);
    }

    public AppUser saveUser(AppUser user){
        return userRepository.save(user);
    }

    public AppUser updateUser(Long id, AppUser user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(AppUser user) {
        userRepository.delete(user);
    }
}
