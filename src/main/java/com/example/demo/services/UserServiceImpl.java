package com.example.demo.services;

import com.example.demo.entities.Supplier;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;
    
    public List<User> findAll(){
        return userRepository.findAll();
    }


    public void save(User user) {
    }

    public User findById(Long id) { return  userRepository.getById(id);}

    public void deleteById(Long id) {
    }
}
