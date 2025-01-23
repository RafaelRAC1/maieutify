package com.rafael.maieutify.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "question")
@NoArgsConstructor  
@AllArgsConstructor
public class Question {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "statment", nullable = false)
    private String statement;
    
    @Getter
    @Setter
    @Column(name = "hint", nullable = true)
    private String hint;

    @Getter
    @Setter
    @Column(name = "question_number")
    private int questionNumber;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "list_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ListQuestions listQuestions;

    /*@Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "abbdr_id", nullable = true)
    private List<Alternative> alternative;*/

    @Getter
    @Setter
    @OneToOne(mappedBy = "question")
    private UserAnswer userAnswer;
}
