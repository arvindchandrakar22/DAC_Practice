package com.insta.clone.modal;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.insta.clone.dto.UserDto;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Embedded
        @AttributeOverrides({
        @AttributeOverride(name="id",column=@Column(name="user_id")),
        @AttributeOverride(name="email",column = @Column(name="user_email"))
    })
    private UserDto user;

    private String content;

    @Embedded
    @ElementCollection
    private Set<UserDto> likedByUser = new HashSet<UserDto>();

    private LocalDateTime createdAt;

    public Comment() {
    }

    public Comment(Integer id, UserDto user, String content, Set<UserDto> likedByUser, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.likedByUser = likedByUser;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<UserDto> getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Set<UserDto> likedByUser) {
        this.likedByUser = likedByUser;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    

}
