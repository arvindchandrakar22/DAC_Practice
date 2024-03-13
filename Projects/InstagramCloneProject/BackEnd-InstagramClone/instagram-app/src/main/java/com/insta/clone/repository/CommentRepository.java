package com.insta.clone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insta.clone.modal.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer>{
    
    

}
