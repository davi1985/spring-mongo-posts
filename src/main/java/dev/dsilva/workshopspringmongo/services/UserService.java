package dev.dsilva.workshopspringmongo.services;

import dev.dsilva.workshopspringmongo.domain.User;
import dev.dsilva.workshopspringmongo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User add(User user) {
        return userRepository.save(user);
    }
}
