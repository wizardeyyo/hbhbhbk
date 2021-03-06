package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.entities.Supplier;
import com.example.demo.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void save(Client client) {
        clientRepository.save(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) { return clientRepository.getById(id); }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);

    }
}
