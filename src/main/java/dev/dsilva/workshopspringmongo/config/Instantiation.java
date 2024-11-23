package dev.dsilva.workshopspringmongo.config;

import dev.dsilva.workshopspringmongo.domain.Post;
import dev.dsilva.workshopspringmongo.domain.User;
import dev.dsilva.workshopspringmongo.repositories.PostRepository;
import dev.dsilva.workshopspringmongo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
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

        Post post1 = new Post(null, dateFormat.parse("23/11/2024"), "Let's travel", "Martin/RN I'm coming 🚙.", user1);
        Post post2 = new Post(null, dateFormat.parse("23/11/2024"), "Good morning", "God is good all the time.", user2);

        userRepository.saveAll(Arrays.asList(user1, user2));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
