package com.example.demo.repositories;

import com.example.demo.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository <Client, UUID> {
}
