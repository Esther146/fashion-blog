package com.esther.fashion_ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name = "likes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",
                nullable = false,
                referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "like_user_id_fk"))
    private User user;


    @ManyToOne
    @JoinColumn(name = "post_id",
                nullable = false,
                referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "like_post_id_fk"))
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id",
                nullable = false,
                referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "like_comment_id_fk"))
    private Comment comment;


}
