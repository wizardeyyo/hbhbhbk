package com.example.demo.repositories;

import com.example.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {
}
