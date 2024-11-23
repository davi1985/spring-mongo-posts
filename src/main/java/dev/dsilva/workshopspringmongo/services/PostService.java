package dev.dsilva.workshopspringmongo.services;

import dev.dsilva.workshopspringmongo.domain.Post;
import dev.dsilva.workshopspringmongo.repositories.PostRepository;
import dev.dsilva.workshopspringmongo.resources.exceptions.PostNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }
}
