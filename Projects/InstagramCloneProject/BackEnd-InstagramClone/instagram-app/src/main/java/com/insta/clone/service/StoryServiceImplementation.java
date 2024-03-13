package com.insta.clone.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insta.clone.dto.UserDto;
import com.insta.clone.exceptions.StoryException;
import com.insta.clone.exceptions.UserException;
import com.insta.clone.modal.Story;
import com.insta.clone.modal.User;
import com.insta.clone.repository.StoryRepository;
import com.insta.clone.repository.UserRepository;

@Service
public class StoryServiceImplementation implements StoryService {
    
    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public Story createStory(Story story, Integer userId) throws UserException{
        
        User user = userService.findUserById(userId);
        
        UserDto userDto = new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUserImage(user.getImage());
        userDto.setUsername(user.getUsername());

        story.setUser(userDto);
        story.setTimeStamp(LocalDateTime.now());

        user.getStories().add(story);  

        return storyRepository.save(story);
    }

    public List<Story> findStoryByUserId(Integer userId) throws StoryException, UserException{
        
        User user = userService.findUserById(userId);
        List<Story> stories = user.getStories();

        if(stories.size()==0){
            throw new StoryException("This user doesn't have any story.");
        }
        
        return stories;
    }


}
