package com.rafael.maieutify.model.entity;

import java.sql.Time;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "list_questions__user")
@NoArgsConstructor  
@AllArgsConstructor
public class ListQuestionsUser {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "time_taken", nullable = true)
    private Time timeTaken;

    @Getter
    @Setter
    @Column(name = "rating", nullable = true)
    private Float rating;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser appUser;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "list_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ListQuestions listQuestions;

    @Getter
    @Setter
    @OneToMany(mappedBy = "listQuestionsUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAnswer> userAnswer;
}
