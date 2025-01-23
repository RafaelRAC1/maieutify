package com.rafael.maieutify.model.entity;
import jakarta.persistence.*;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class AppUser {
    @Getter 
    @Setter 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter 
    @Setter 
    @Column(name = "username", nullable = false)
    private String username;

    @Getter 
    @Setter 
    @Column(name = "password", nullable = false)
    private String password;

    @Getter 
    @Setter 
    @Column(name = "pfp", nullable = false)
    private String pfp;
    
    @Getter 
    @Setter 
    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Getter 
    @Setter 
    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;
    
    @Getter 
    @Setter 
    @Column(name = "tags", nullable = true)
    private String tags;
    
    @Getter 
    @Setter 
    @Column(name = "bio", nullable = true)
    private String bio;

    /* 
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<ListQuestions> listQuestions;
    */

    /* 
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_questions__user_id", nullable = true)
    private List<ListQuestionsUser> listQuestionsUser;
    */

    /* 
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_questions__comment_id", nullable = true)
    private List<ListQuestionComment> listQuestionComment;
    */
}
