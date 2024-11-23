package dev.dsilva.workshopspringmongo.dto;

import dev.dsilva.workshopspringmongo.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO implements Serializable {

    private static final long serialVersionUID = 5944006747676011634L;

    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

    public PostDTO(Post post) {
        id = post.getId();
        date = post.getDate();
        title = post.getTitle();
        body = post.getBody();
        author = post.getAuthor();
    }
}
