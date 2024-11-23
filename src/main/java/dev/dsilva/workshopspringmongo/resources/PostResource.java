package dev.dsilva.workshopspringmongo.resources;

import dev.dsilva.workshopspringmongo.dto.PostDTO;
import dev.dsilva.workshopspringmongo.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostResource {

    private final PostService postService;

    public PostResource(final PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        var post = postService.findById(id);

        return ResponseEntity.ok(new PostDTO(post));
    }
}
