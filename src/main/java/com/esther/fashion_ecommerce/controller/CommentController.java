package com.esther.fashion_ecommerce.controller;

import com.esther.fashion_ecommerce.model.Comment;
import com.esther.fashion_ecommerce.model.Post;
import com.esther.fashion_ecommerce.payload.CommentDto;
import com.esther.fashion_ecommerce.payload.PostDto;
import com.esther.fashion_ecommerce.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {

    public final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(path = "/createComment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.createComment(comment), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getComment/{id}")
    public ResponseEntity<?> getAComment(@PathVariable Long id){
        return new ResponseEntity<>(commentService.getById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/getAllComments")
    public ResponseEntity<?> getAllComment(){
        return new ResponseEntity<>(commentService.getAllComment(), HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.updateComment(id, commentDto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>("post not found!!", HttpStatus.NO_CONTENT);
    }
}
