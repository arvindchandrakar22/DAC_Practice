package com.insta.clone.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.insta.clone.repository.UserRepository;

@Service
public class UserUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        Optional<com.insta.clone.modal.User> opt = userRepository.findByEmail(username);
        if(opt.isPresent()){
            com.insta.clone.modal.User user = opt.get();
            java.util.List<GrantedAuthority> authorities = new ArrayList<>();
            return new User(user.getEmail(),user.getPassword(),authorities);
        }
        throw new BadCredentialsException("User not found with username "+username);
    }
}