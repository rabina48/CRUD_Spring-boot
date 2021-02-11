package com.f1soft.springdemo.security;

import com.f1soft.springdemo.repository.UserRepository;
import com.f1soft.springdemo.user.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Qualifier("myUserDetailServices")
public class MyUserDetailServices implements UserDetailsService {


    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserProfile userProfile = repository.findByFirstName(name);

        if (userProfile == null){
            throw new UsernameNotFoundException("404");

        }

        return new UserDetailServiceImpl(userProfile);
    }
}
