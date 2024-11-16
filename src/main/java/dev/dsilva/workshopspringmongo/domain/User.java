package dev.dsilva.workshopspringmongo.domain;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User implements Serializable {

    private static final long serialVersionUID = 3981035936948844674L;

    private String id;
    private String name;
    private String email;
}
