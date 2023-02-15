package com.esther.fashion_ecommerce.repository;

import com.esther.fashion_ecommerce.model.User;
import com.esther.fashion_ecommerce.payload.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
