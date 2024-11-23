package dev.dsilva.workshopspringmongo.resources;

import dev.dsilva.workshopspringmongo.domain.User;
import dev.dsilva.workshopspringmongo.dto.UserDTO;
import dev.dsilva.workshopspringmongo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    @Transactional
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDto, UriComponentsBuilder builder) {
        var user = userService.fromDto(userDto);
        user = userService.add(user);

        var uri = builder
                .path(("/doctors/{id}"))
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new UserDTO(user));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id) {
        User obj = userService.fromDto(userDTO);
        obj.setId(id);

        userService.update(obj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable String id) {
        userService.remove(id);

        return ResponseEntity.noContent().build();
    }
}
