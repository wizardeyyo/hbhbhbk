package com.example.demo.services;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {return employeeRepository.getById(id);}

    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }
}
