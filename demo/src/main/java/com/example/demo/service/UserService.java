package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService /*implements UserDetailsService */ {
    /*
    private UserRepo userRepo;
    @Autowired
    public void setUserRepo(UserRepo userRepo) {
       this.userRepo = userRepo;
    }
    public User findByUsername(String userName){
        return userRepo.findByUsername(userName);
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
        mapRolestoAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRolestoAuthorities(Collection<Role> roles){
       return roles.stream().map(r->new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }*/
}
