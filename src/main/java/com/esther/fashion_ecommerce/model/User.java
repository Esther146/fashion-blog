package com.esther.fashion_ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String password;

    @Column(nullable = false, unique = true)
    private String phoneNumber;


    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "user",
                orphanRemoval = true,
                cascade = CascadeType.ALL)
    private List<Like> like = new ArrayList<>();

}
