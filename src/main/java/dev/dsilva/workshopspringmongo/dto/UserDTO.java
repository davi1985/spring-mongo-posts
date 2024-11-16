package dev.dsilva.workshopspringmongo.dto;

import dev.dsilva.workshopspringmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 2091918631273082584L;

    private String id;
    private String name;
    private String email;

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
