package com.insta.clone.service;

import java.util.List;

import com.insta.clone.exceptions.PostException;
import com.insta.clone.exceptions.UserException;
import com.insta.clone.modal.Post;

public interface PostService {
    
    public Post createPost(Post post, Integer userId) throws UserException;
    
    public String deletePost(Integer postId, Integer userId) throws UserException, PostException;

    public List<Post> findPostByUserId(Integer userId) throws UserException;

    public Post findPostById(Integer postId) throws PostException;

    public List<Post> findAllPostByUserIds(List<Integer> userIds) throws PostException,UserException;

    public String savedPost(Integer postId, Integer userId) throws PostException,UserException;

    public String unSavedPost(Integer postId, Integer userId) throws PostException, UserException;

    public Post likedPost(Integer postId, Integer userId) throws PostException,UserException;

    public Post unLikedPost(Integer postId,Integer userId) throws PostException,UserException;

}
