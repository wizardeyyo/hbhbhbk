package com.example.demo.services;

import com.example.demo.entities.ProductStats;
import com.example.demo.repositories.ProductStatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductStatsService {

    private final ProductStatsRepository productStatsRepository;

    public List<ProductStats> getStatistics(){
        return productStatsRepository.getStatistics();
    }
}
