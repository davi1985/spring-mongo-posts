package dev.dsilva.workshopspringmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 484879967569097514L;

    private String comment;
    private Date date;
    private AuthorDTO author;
}
