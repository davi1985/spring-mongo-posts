package dev.dsilva.workshopspringmongo.services;

import dev.dsilva.workshopspringmongo.domain.User;
import dev.dsilva.workshopspringmongo.dto.UserDTO;
import dev.dsilva.workshopspringmongo.repositories.UserRepository;
import dev.dsilva.workshopspringmongo.resources.exceptions.UserNotFoundException;
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

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User fromDto(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void remove(String id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException();
        }

        userRepository.deleteById(id);
    }

    public User update(User user) {
        User newUser = userRepository.findById(user.getId()).orElseThrow(UserNotFoundException::new);
        updateData(newUser, user);

        return userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }
}
