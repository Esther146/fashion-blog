package com.esther.fashion_ecommerce.service;

import com.esther.fashion_ecommerce.exception.UserNotFoundException;
import com.esther.fashion_ecommerce.model.Post;
import com.esther.fashion_ecommerce.payload.PostDto;
import com.esther.fashion_ecommerce.repository.PostRepository;
import com.esther.fashion_ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    public final PostRepository postRepository;
    public final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post createPost(Post post){

        return postRepository.save(post);
    }

    public Post getPostById(Long id){
        Optional<Post> getPost = postRepository.findById(id);
        if (getPost.isEmpty()){
            throw new UserNotFoundException("The post with the id: {" + id + "}not found");
        }
        return getPost.get();
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Post updatePost(Long id, PostDto postDto) {

        Optional<Post> editPosts = postRepository.findById(id);

        if (editPosts.isEmpty()) {
            throw new UserNotFoundException("The user with the id: {" + id + "}not found");
        } else {

            Post edit = postRepository.findById(id).get();
            edit.setTitle(postDto.getTitle());
            edit.setPostBody(postDto.getPostBody());

            return postRepository.save(edit);
        }
    }

    public void deletePost(Long id){
        Optional<Post> getPost = postRepository.findById(id);

        if (getPost.isEmpty()){

            throw new UserNotFoundException("The post with the id: {" + id + "}not found");
        }

        postRepository.deleteById(id);
    }



}
