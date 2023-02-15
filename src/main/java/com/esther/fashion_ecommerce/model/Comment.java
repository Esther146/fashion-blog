package com.esther.fashion_ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.security.Timestamp;
import java.util.Date;

@Getter
@ToString
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String commentBody;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id",
                referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "comment_user_id"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id",
                referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "comment_post_id_fk"))
    private Post post;


}
