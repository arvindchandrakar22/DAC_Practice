package com.insta.clone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.insta.clone.dto.UserDto;
import com.insta.clone.exceptions.UserException;
import com.insta.clone.modal.User;
import com.insta.clone.repository.UserRepository;
import com.insta.clone.security.JwtTokenClaims;
import com.insta.clone.security.JwtTokenProvider;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider JwtTokenProvider;

    @Override
    public User registerUser(User user) throws UserException {
        // TODO Auto-generated method stub

        Optional<User> isEmailExist = userRepository.findByEmail(user.getEmail());
        if(isEmailExist.isPresent()){
            throw new UserException("Email Is Aready Exists.");
        }

        Optional<User> isUsernameExist = userRepository.findByUsername(user.getUsername());
        if(isUsernameExist.isPresent()){
            throw new UserException("Username Is Aready Taken.");
        }

        if(user.getEmail()==null||user.getPassword()==null||user.getUsername()==null||user.getName()==null){
            throw new UserException("All fields are required.");
        }

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setUsername(user.getUsername());
        newUser.setName(user.getName());

        return userRepository.save(newUser);
    }

    @Override
    public User findUserById(Integer userId) throws UserException {
        // TODO Auto-generated method stub

        Optional<User> opt = userRepository.findById(userId);
        if(opt.isPresent()){
            return opt.get();
        }
        throw new UserException("User does not exist with ID : "+ userId);

    }

    @Override
    public User findUserProfile(String token) throws UserException {
        // TODO Auto-generated method stub
        
        //      Bearer kjwhdfkdhkeajfrecjbke
        token = token.substring(7);
        JwtTokenClaims jwtTokenClaims = JwtTokenProvider.getClaimsFromToken(token);
        String email = jwtTokenClaims.getUsername();

        Optional<User> opt =  userRepository.findByEmail(email);

        if(opt.isPresent()){
            return opt.get();
        }

        throw new UserException("Invalid Token !!");
    }

    @Override
    public User findUserByUsername(String username) throws UserException {
        // TODO Auto-generated method stub

        Optional<User> opt = userRepository.findByUsername(username);

        if(opt.isPresent()){
            return opt.get();
        }

        throw new UserException("User not exist with username : " +username);
    }

    @Override
    public String followUser(Integer reqUserId, Integer followUserId) throws UserException {
        // TODO Auto-generated method stub

        User reqUser = findUserById(reqUserId);
        User followUser = findUserById(followUserId);

        UserDto follower = new UserDto();
        follower.setEmail(reqUser.getEmail());
        follower.setId(reqUser.getId());
        follower.setName(reqUser.getName());
        follower.setUserImage(reqUser.getUsername());
        follower.setUsername(reqUser.getUsername());

        UserDto following = new UserDto();
        following.setEmail(followUser.getEmail());
        following.setId(followUser.getId());
        following.setUserImage(followUser.getImage());
        following.setName(followUser.getName());
        following.setUsername(followUser.getUsername());

        reqUser.getFollowing().add(following);
        followUser.getFollower().add(follower);

        userRepository.save(followUser);
        userRepository.save(reqUser);

        return "Your are following "+followUser.getUsername();
    }

    @Override
    public String unFollowUser(Integer reqUserId, Integer followUserId) throws UserException {
        // TODO Auto-generated method stub

        User reqUser = findUserById(reqUserId);
        User followUser = findUserById(followUserId);

        UserDto follower = new UserDto();
        follower.setEmail(reqUser.getEmail());
        follower.setId(reqUser.getId());
        follower.setName(reqUser.getName());
        follower.setUserImage(reqUser.getUsername());
        follower.setUsername(reqUser.getUsername());

        UserDto following = new UserDto();
        following.setEmail(followUser.getEmail());
        following.setId(followUser.getId());
        following.setUserImage(followUser.getImage());
        following.setName(followUser.getName());
        following.setUsername(followUser.getUsername());

        reqUser.getFollowing().remove(follower);
        followUser.getFollower().remove(follower);

        userRepository.save(followUser);
        userRepository.save(reqUser);

        return "You have unfollowed "+followUser.getUsername();
    }

    @Override
    public List<User> findUserByIds(List<Integer> userIds) throws UserException {
        // TODO Auto-generated method stub

        List<User> users = userRepository.findAllUserByUserIds(userIds);

        return users;
    }

    @Override
    public List<User> searchUser(String query) throws UserException {
        // TODO Auto-generated method stub

        List<User> users = userRepository.findByQuery(query);
        if(users.size()==0){
            throw new UserException("User not found.");
        }

        return users;
    }

    @Override
    public User updateUserDetails(User updatedUser, User existingUser) throws UserException {
        // TODO Auto-generated method stub

        if(updatedUser.getEmail()!=null){
            existingUser.setEmail(updatedUser.getEmail());
        }
        if(updatedUser.getBio()!=null){
            existingUser.setBio(updatedUser.getBio());
        }
        if(updatedUser.getName()!=null){
            existingUser.setName(updatedUser.getName());
        }
        if(updatedUser.getUsername()!=null){
            existingUser.setUsername(updatedUser.getUsername());
        }
        if(updatedUser.getMobile()!=null){
            existingUser.setMobile(updatedUser.getMobile());
        }
        if(updatedUser.getGender()!=null){
            existingUser.setGender(updatedUser.getGender());
        }
        if(updatedUser.getWebsite()!=null){
            existingUser.setWebsite(updatedUser.getWebsite());
        }
        if(updatedUser.getImage()!=null){
            existingUser.setImage(updatedUser.getImage());
        }

        if(updatedUser.getId().equals(existingUser.getId())){
            return userRepository.save(existingUser);
        }

        throw new UserException("You can't update this user.");
                
    }
    
}