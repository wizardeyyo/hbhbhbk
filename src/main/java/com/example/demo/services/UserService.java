package com.example.demo.services;

import com.example.demo.entities.Type;
import com.example.demo.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    User findByUserName(String name);

    List<User> findAll();

    void deleteById(Long id);

    void save(User user);

    User findById(Long id);
}
