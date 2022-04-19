package com.example.demo.services.impl;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByUserName(String name) {
        return userRepository.findUserByUserName(name);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = findByUserName(userName);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getPassword(), mapRolesToAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }
}
