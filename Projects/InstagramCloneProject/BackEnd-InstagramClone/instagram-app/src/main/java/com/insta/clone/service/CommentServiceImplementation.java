package com.insta.clone.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insta.clone.dto.UserDto;
import com.insta.clone.exceptions.CommentException;
import com.insta.clone.exceptions.PostException;
import com.insta.clone.exceptions.UserException;
import com.insta.clone.modal.Comment;
import com.insta.clone.modal.Post;
import com.insta.clone.modal.User;
import com.insta.clone.repository.CommentRepository;
import com.insta.clone.repository.PostRepository;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment createComment(Comment comment, Integer postId, Integer userId) throws UserException, PostException {
        // TODO Auto-generated method stub

        User user = userService.findUserById(userId);
        Post post = postService.findPostById(postId);
        
        UserDto userDto = new UserDto();
        
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUserImage(user.getImage());
        userDto.setUsername(user.getUsername());

        comment.setUser(userDto);
        comment.setCreatedAt(LocalDateTime.now());

        Comment createdComment = commentRepository.save(comment);

        post.getComments().add(createdComment);

        postRepository.save(post);

        return createdComment;
    }

    @Override
    public Comment findCommentById(Integer commentId) throws CommentException {
        // TODO Auto-generated method stub

        Optional<Comment> opt = commentRepository.findById(commentId);
        if(opt.isPresent()){
            return opt.get();
        }

        throw new CommentException("Comment is not exist with ID : " +commentId);
    }

    @Override
    public Comment likeComment(Integer commentId, Integer userId) throws CommentException, UserException {
        // TODO Auto-generated method stub

        User user = userService.findUserById(userId);
        Comment comment = findCommentById(commentId);

        UserDto userDto = new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUserImage(user.getImage());
        userDto.setUsername(user.getUsername());

        comment.getLikedByUser().add(userDto);

        return commentRepository.save(comment);
    }

    @Override
    public Comment unLikeComment(Integer commentId, Integer userId) throws CommentException, UserException {
        // TODO Auto-generated method stub
        
        User user = userService.findUserById(userId);
        Comment comment = findCommentById(commentId);

        UserDto userDto = new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUserImage(user.getImage());
        userDto.setUsername(user.getUsername());

        comment.getLikedByUser().remove(userDto);

        return commentRepository.save(comment);
    }
    
}
