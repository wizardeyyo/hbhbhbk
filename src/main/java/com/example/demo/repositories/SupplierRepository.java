package com.example.demo.repositories;

import com.example.demo.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Supplier getById(UUID uuid);
}
