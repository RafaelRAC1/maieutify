package com.rafael.maieutify.model.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "list_questions")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ListQuestions {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Getter
    @Setter
    @Column(name = "last_updated", nullable=false)
    private Date lastUpdated;

    @Getter
    @Setter
    @Column(name = "difficulty", nullable=false)
    private Float difficulty;

    @Getter
    @Setter
    @Column(name = "title", nullable=false)
    private String title;

    @Getter
    @Setter
    @Column(name = "list_description", columnDefinition = "TEXT", nullable=false)
    private String listDescription;

    @Getter
    @Setter
    @Column(name = "list_image", nullable=false)
    private String listImage;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AppUser appUser;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    @Getter
    @Setter
    @OneToMany(mappedBy = "listQuestions", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> question;

    /* 
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_questions__user_id", nullable = true)
    private List<ListQuestionsUser> listQuestionsUser;
    */
 
    @Getter
    @Setter
    @OneToMany(mappedBy = "listQuestions", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ListQuestionComment> listQuestionComment;
}
