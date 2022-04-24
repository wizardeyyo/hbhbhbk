package com.example.demo.services;

import com.example.demo.entities.Supplier;
import com.example.demo.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public List<Supplier> findAll(){
        return supplierRepository.findAll();
    }

    public void deleteById(Long id){
        supplierRepository.deleteById(id);
    }

    public Supplier findById(UUID uuid) { return  supplierRepository.getById(uuid);}
    }

