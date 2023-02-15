package com.esther.fashion_ecommerce.controller;

import com.esther.fashion_ecommerce.model.Post;
import com.esther.fashion_ecommerce.payload.PostDto;
import com.esther.fashion_ecommerce.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequiredArgsConstructor
@RequestMapping(path = "/posts")
public class PostController {

    public  final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(path = "/post")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getPost/{id}")
    public ResponseEntity<?> getAPost(@PathVariable Long id){
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/getAllPost")
    public ResponseEntity<?> getAllPost(){
        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.updatePost(id, postDto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return new ResponseEntity<>("post not found!!", HttpStatus.OK);
    }
}
