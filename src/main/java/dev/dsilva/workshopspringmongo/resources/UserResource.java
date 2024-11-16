package dev.dsilva.workshopspringmongo.resources;

import dev.dsilva.workshopspringmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User mary = new User("1", "Mary", "email@email.com");
        User steve = new User("2", "Steve", "email@email.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(mary, steve));

        return ResponseEntity.ok(list);
    }
}
