package com.insta.clone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insta.clone.exceptions.UserException;
import com.insta.clone.modal.User;
import com.insta.clone.response.MessageResponse;
import com.insta.clone.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/id/{id}")
    public ResponseEntity<User> findUserByIdHandler(@PathVariable Integer id) throws UserException{
        User user = userService.findUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> findUserByUsernameHandler(@PathVariable String username) throws UserException{
        User user = userService.findUserByUsername(username);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("/follow/{followUserId}")
    public ResponseEntity<MessageResponse> followUserHandler(@PathVariable Integer followUserId, @RequestHeader("Authorization") String token) throws UserException{
        User user = userService.findUserProfile(token);
        String message = userService.followUser(user.getId(), followUserId);
        MessageResponse res = new MessageResponse(message);
        return new ResponseEntity<MessageResponse>(res, HttpStatus.OK);
    }

    @PutMapping("/unfollow/{userId}")
    public ResponseEntity<MessageResponse> unFollowUserHandler(@PathVariable Integer userId, @RequestHeader("Authorization") String token) throws UserException{
        User user = userService.findUserProfile(token);
        String message = userService.unFollowUser(user.getId(), userId);
        MessageResponse res = new MessageResponse(message);
        return new ResponseEntity<MessageResponse>(res, HttpStatus.OK);
    }

    @GetMapping("/req")
    public ResponseEntity<User> findUserProfileHandler(@RequestHeader("Authorization") String token) throws UserException{
        User user = userService.findUserProfile(token);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/multiuser/{userIds}")
    public ResponseEntity<List<User>> findUserByUserIdsHandler(@PathVariable List<Integer> userIds) throws UserException{
        List<User> users = userService.findUserByIds(userIds);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

//   api/users/search?q = "query"
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUserhandler(@RequestParam("q") String query) throws UserException{
        List<User> users = userService.searchUser(query);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PutMapping("/account/edit")
    public ResponseEntity<User> updateUserHandler(@RequestHeader("Authorization") String token, @RequestBody User user) throws UserException{
        User reqUser = userService.findUserProfile(token);
        User updatedUser = userService.updateUserDetails(user, reqUser);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

}