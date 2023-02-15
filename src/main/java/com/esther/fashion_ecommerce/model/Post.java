package com.esther.fashion_ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String postBody;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id",
                referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "post_user_id_fk"))
    private User user;

    @OneToMany(mappedBy = "post",
                cascade = CascadeType.ALL)
    private List<Comment> comment;

    @OneToMany(mappedBy = "post",
                orphanRemoval = true,
                cascade = CascadeType.ALL)
    private List<Like> like = new ArrayList<>();

}
