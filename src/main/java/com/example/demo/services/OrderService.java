package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id) {return orderRepository.getById(id);}

    public void deleteById(Long id){
        orderRepository.deleteById(id);
    }
}
