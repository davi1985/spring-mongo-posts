package dev.dsilva.workshopspringmongo.config;

import dev.dsilva.workshopspringmongo.domain.Post;
import dev.dsilva.workshopspringmongo.domain.User;
import dev.dsilva.workshopspringmongo.dto.AuthorDTO;
import dev.dsilva.workshopspringmongo.dto.CommentDTO;
import dev.dsilva.workshopspringmongo.repositories.PostRepository;
import dev.dsilva.workshopspringmongo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;


    public Instantiation(UserRepository userRepository, final PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Davi Silva", "davi@email.com");
        User user2 = new User(null, "Joelma Braga", "joelma@email.com");
        User user3 = new User(null, "Laura Vittoria", "laura@email.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Post post1 = new Post(
                null,
                dateFormat.parse("23/11/2024"),
                "Let's travel",
                "Martin/RN I'm coming 🚙.",
                new AuthorDTO(user1)
        );

        Post post2 = new Post(
                null,
                dateFormat.parse("23/11/2024"),
                "Good morning",
                "God is good all the time.",
                new AuthorDTO(user1)
        );

        CommentDTO comment1 = new CommentDTO(
                "Have a nice tripe!",
                dateFormat.parse("23/11/2024"),
                new AuthorDTO(user2)
        );

        CommentDTO comment2 = new CommentDTO(
                "Good ...",
                dateFormat.parse("23/11/2024"),
                new AuthorDTO(user3)
        );

        CommentDTO comment3 = new CommentDTO(
                "I agree...",
                dateFormat.parse("23/11/2024"),
                new AuthorDTO(user3)
        );

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        user1.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(user1);
    }
}
