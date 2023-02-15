package com.esther.fashion_ecommerce.service;

import com.esther.fashion_ecommerce.exception.UserNotFoundException;
import com.esther.fashion_ecommerce.model.Comment;
import com.esther.fashion_ecommerce.payload.CommentDto;
import com.esther.fashion_ecommerce.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    public final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComment(){
        return commentRepository.findAll();
    }

    public Comment getById(Long id){
        Optional<Comment> comments = commentRepository.findById(id);
        if (comments.isEmpty()){
            throw new UserNotFoundException("The post with the id: {" + id + "}not found");
        }
        return comments.get();
    }

    public Comment updateComment(Long id, CommentDto commentDto){

        Optional<Comment> updateComment = commentRepository.findById(id);

        if (updateComment.isEmpty()) {
            throw new UserNotFoundException("The user with the id: {" + id + "}not found");
        }

        Comment update = commentRepository.findById(id).get();
        update.setCommentBody(commentDto.getCommentBody());
        return commentRepository.save(update);
    }

    public void deleteComment(Long id){

        Optional<Comment> comments = commentRepository.findById(id);
        if (comments.isEmpty()){
            throw new UserNotFoundException("The post with the id: {" + id + "}not found");
        }

        commentRepository.deleteById(id);
    }




}
