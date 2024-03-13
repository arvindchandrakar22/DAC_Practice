package com.insta.clone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insta.clone.exceptions.StoryException;
import com.insta.clone.exceptions.UserException;
import com.insta.clone.modal.Story;
import com.insta.clone.modal.User;
import com.insta.clone.service.StoryService;
import com.insta.clone.service.UserService;

@RestController
@RequestMapping("/api/stories")
public class StoryController {
    
    @Autowired
    private UserService usersService;

    @Autowired
    private StoryService storyService;

    @PostMapping("/create")
    public ResponseEntity<Story> createStoryHandler(@RequestBody Story story, @RequestHeader("Authorization") String token) throws UserException{

        User user = usersService.findUserProfile(token);

        Story createdStory = storyService.createStory(story,user.getId());

        return new ResponseEntity<Story>(createdStory, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Story>> findAllStoryByUserId(@PathVariable Integer userId) throws UserException, StoryException{

        User user = usersService.findUserById(userId);
        
        List<Story> stories = storyService.findStoryByUserId(user.getId());
        
        return new ResponseEntity<List<Story>>(stories, HttpStatus.OK);
    }

}
