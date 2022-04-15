package com.example.demo.services;

import com.example.demo.entities.Type;
import com.example.demo.repositories.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeService {

    private final TypeRepository typeRepository;

    public void save(Type type){
        typeRepository.save(type);
    }

    public List<Type> findAll(){
        return typeRepository.findAll();
    }

    public void deleteById(Long id){
        typeRepository.deleteById(id);
    }
}
