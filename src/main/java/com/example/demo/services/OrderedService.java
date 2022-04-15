package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.entities.Ordered;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.OrderedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderedService {

    private final OrderedRepository orderedRepository;

    public List<Ordered> findAll() {
        return orderedRepository.findAll();
    }

    public void save(Ordered ordered){
        orderedRepository.save(ordered);
    }

    public void deleteById(Long id) {
        orderedRepository.deleteById(id);
    }
}
