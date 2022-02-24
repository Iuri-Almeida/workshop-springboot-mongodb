package br.com.ialmeida.workshopmongodb.resources;

import br.com.ialmeida.workshopmongodb.domain.Post;
import br.com.ialmeida.workshopmongodb.domain.User;
import br.com.ialmeida.workshopmongodb.dto.AuthorDTO;
import br.com.ialmeida.workshopmongodb.dto.UserDTO;
import br.com.ialmeida.workshopmongodb.resources.util.URL;
import br.com.ialmeida.workshopmongodb.services.PostService;
import br.com.ialmeida.workshopmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
