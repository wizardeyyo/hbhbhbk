package com.example.demo.repositories;

import com.example.demo.Entities.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderedRepository extends JpaRepository<Ordered, UUID> {
}
