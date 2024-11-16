package dev.dsilva.workshopspringmongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Document
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 3981035936948844674L;

    @Id
    private String id;
    private String name;
    private String email;
}
