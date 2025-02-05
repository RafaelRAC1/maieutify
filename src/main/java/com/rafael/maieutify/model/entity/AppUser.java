package com.rafael.maieutify.model.entity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Getter 
    @Setter 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Getter
    @Setter
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfileComment> profileCommentsProfile;

    @Getter
    @Setter
    @OneToMany(mappedBy = "commenter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfileComment> profileCommentsCommenter;
}
