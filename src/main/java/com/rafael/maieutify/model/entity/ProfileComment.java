package com.rafael.maieutify.model.entity;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profile_comment")
@NoArgsConstructor
@AllArgsConstructor
public class ProfileComment {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "comment", nullable = false)
    private String comment;

    @Getter
    @Setter
    @Column(name = "edited")
    private char edited;

    @Getter
    @Setter
    @Column(name = "last_updated")
    private Date lastUpdated;

    @OneToOne
    @JoinColumn(name = "profile_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AppUser profile;

    @OneToOne
    @JoinColumn(name = "commenter_id")
    private AppUser commenter;
}
