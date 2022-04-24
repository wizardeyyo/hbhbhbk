package com.example.demo.services;

import com.example.demo.entities.Supplier;
import com.example.demo.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Supplier findById(Long id) { return  supplierRepository.getById(id);}
    }

