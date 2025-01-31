package com.rafael.maieutify.model.entity;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alternative")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Alternative {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "alternative_character", nullable = false)
    private char alternativeCharacter;

    @Getter
    @Setter
    @Column(name = "alternative_description", nullable = false)
    private String alternativeDescription;

    @Getter
    @Setter
    @Column(name = "correct")
    private Boolean correct;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Getter
    @Setter
    @OneToOne(mappedBy = "alternative")
    private UserAnswer userAnswer;
}
