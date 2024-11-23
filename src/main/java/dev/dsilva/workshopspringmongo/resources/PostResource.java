package dev.dsilva.workshopspringmongo.resources;

import dev.dsilva.workshopspringmongo.domain.Post;
import dev.dsilva.workshopspringmongo.dto.PostDTO;
import dev.dsilva.workshopspringmongo.resources.utils.URL;
import dev.dsilva.workshopspringmongo.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    private final PostService postService;

    public PostResource(final PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        var post = postService.findById(id);

        return ResponseEntity.ok(new PostDTO(post));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParams(text);
        var posts = postService.findByTitle(text);

        return ResponseEntity.ok(posts);
    }
}
