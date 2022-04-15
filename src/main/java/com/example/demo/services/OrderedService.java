package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderedService {

    private final OrderRepository orderedRepository;

    public List<Order> findAll() {
        return orderedRepository.findAll();
    }

    public void save(Order order){
        orderedRepository.save(order);
    }

    public void removeById(Long id) {
        orderedRepository.deleteById(id);
    }
}
