package com.esther.fashion_ecommerce.repository;

import com.esther.fashion_ecommerce.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
