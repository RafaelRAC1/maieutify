package com.rafael.maieutify.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "category_name")
    private String categoryName;

    /* 
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ListQuestions> listQuestions;
    */
}
