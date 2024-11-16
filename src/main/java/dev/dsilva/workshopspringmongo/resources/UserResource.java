package dev.dsilva.workshopspringmongo.resources;

import dev.dsilva.workshopspringmongo.domain.User;
import dev.dsilva.workshopspringmongo.dto.UserDTO;
import dev.dsilva.workshopspringmongo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        var users = userService.findAll()
                .stream()
                .map(UserDTO::new).toList();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable String id) {
        var user = userService.findById(id);

        return ResponseEntity.ok(new UserDTO(user)).getBody();
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody final User user) {
        var userCreated = userService.add(user);

        return ResponseEntity.ok(userCreated);
    }
}
