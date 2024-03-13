package com.insta.clone.service;

import java.util.List;

import com.insta.clone.exceptions.StoryException;
import com.insta.clone.exceptions.UserException;
import com.insta.clone.modal.Story;

public interface StoryService {
    
    public Story createStory(Story story, Integer userId) throws UserException;

    public List<Story> findStoryByUserId(Integer userId) throws UserException, StoryException;

}
