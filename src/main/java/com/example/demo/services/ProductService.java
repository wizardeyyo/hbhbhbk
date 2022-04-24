package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    public final ProductRepository productRepository;

    public void save(Product product){
        productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id) {return productRepository.getById(id); }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

}
