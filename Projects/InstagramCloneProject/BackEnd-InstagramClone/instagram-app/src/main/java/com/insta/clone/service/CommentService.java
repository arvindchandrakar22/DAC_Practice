package com.insta.clone.service;

import com.insta.clone.exceptions.CommentException;
import com.insta.clone.exceptions.PostException;
import com.insta.clone.exceptions.UserException;
import com.insta.clone.modal.Comment;

public interface CommentService {
    
    public Comment createComment(Comment comment, Integer postId, Integer userId) throws UserException, PostException;

    public Comment findCommentById(Integer commentId) throws CommentException;

    public Comment likeComment(Integer commentId, Integer userId) throws CommentException, UserException;

    public Comment unLikeComment(Integer commentId, Integer userId) throws CommentException, UserException;

}
