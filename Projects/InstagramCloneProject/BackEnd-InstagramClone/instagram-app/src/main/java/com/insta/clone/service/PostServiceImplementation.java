package com.insta.clone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insta.clone.dto.UserDto;
import com.insta.clone.exceptions.PostException;
import com.insta.clone.exceptions.UserException;
import com.insta.clone.modal.Post;
import com.insta.clone.modal.User;
import com.insta.clone.repository.PostRepository;
import com.insta.clone.repository.UserRepository;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Post createPost(Post post, Integer userId) throws UserException {
        // TODO Auto-generated method stub

        User user = userService.findUserById(userId);
        UserDto userDto = new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUserImage(user.getImage());
        userDto.setUsername(user.getUsername());

        post.setUser(userDto);

        Post createdPost = postRepository.save(post);

        return createdPost; 
    }

    @Override
    public String deletePost(Integer postId, Integer userId) throws UserException, PostException {
        // TODO Auto-generated method stub

        Post post = findPostById(postId);
        
        User user = userService.findUserById(userId);

        if(post.getUser().getId().equals(user.getId())){
            postRepository.deleteById(userId);
            return "Post Deleted Successfully";
        }

        throw new PostException("You can't delete other user's post");
    }

    @Override
    public List<Post> findPostByUserId(Integer userId) throws UserException {
        // TODO Auto-generated method stub

        List<Post> posts = postRepository.findByUserId(userId);

        if(posts.size()==0){
            throw new UserException("This user does not have any post.");
        }

        return posts;
    }

    @Override
    public Post findPostById(Integer postId) throws PostException {
        // TODO Auto-generated method stub

        Optional<Post> opt = postRepository.findById(postId);

        if(opt.isPresent()){
            return opt.get();
        }

        throw new PostException("Post not found with ID : "+postId);
    }

    @Override
    public List<Post> findAllPostByUserIds(List<Integer> userIds) throws PostException, UserException {
        // TODO Auto-generated method stub

        List<Post> posts = postRepository.findAllPostByUserIds(userIds);

        if(posts.size() == 0){
            throw new PostException("No POST available.");
        }

        return posts;
    }

    @Override
    public String savedPost(Integer postId, Integer userId) throws PostException, UserException {
        // TODO Auto-generated method stub

        Post post = findPostById(postId);

        User user = userService.findUserById(userId);

        if(!user.getSavedPost().contains(post)){
            user.getSavedPost().add(post);
            userRepository.save(user);
        }

        return "Post Saved Successfully :)"; 
    }

    @Override
    public String unSavedPost(Integer postId, Integer userId) throws PostException, UserException {
        // TODO Auto-generated method stub

        Post post = findPostById(postId);

        User user = userService.findUserById(userId);

        if(user.getSavedPost().contains(post)){
            user.getSavedPost().remove(post);
            userRepository.save(user);
        }

        return "Post Removed Successfully :)";  
    }

    @Override
    public Post likedPost(Integer postId, Integer userId) throws PostException, UserException {
        // TODO Auto-generated method stub

        Post post = findPostById(postId);

        User user = userService.findUserById(userId);

        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUserImage(user.getImage());
        userDto.setUsername(user.getUsername());

        post.getLikedByUsers().add(userDto);

        return postRepository.save(post); 
    }

    @Override
    public Post unLikedPost(Integer postId, Integer userId) throws PostException, UserException {
        // TODO Auto-generated method stub
        
        Post post = findPostById(postId);

        User user = userService.findUserById(userId);

        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUserImage(user.getImage());
        userDto.setUsername(user.getUsername());

        post.getLikedByUsers().remove(userDto);

        return postRepository.save(post); 
    }
}
