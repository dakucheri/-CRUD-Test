package org.example.crudtest.service;

import org.example.crudtest.Client;
import org.example.crudtest.repository.ClientRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client create(Client client) {
        client.setStatus("ACTIVE");
        return clientRepository.save(client);
    }

    public Client update(Long id, Client updated) {
        Client existing = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        if (updated.getFull_name() != null) existing.setFull_name(updated.getFull_name());
        if (updated.getGender() != null) existing.setGender(updated.getGender());

        return clientRepository.save(existing);
    }

    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found");
        }
        clientRepository.deleteById(id);
    }

}
