package com.techguyseli.Eventster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techguyseli.Eventster.exceptions.ClientNotFoundException;
import com.techguyseli.Eventster.models.Client;
import com.techguyseli.Eventster.repositories.ClientRepository;

/**
 * ClientService
 */
@Service
public class ClientService {

  @Autowired
  private ClientRepository repository;

  public List<Client> getAllClients() {
    return repository.findAll();
  }

  public Client getClientById(Long clientId) throws ClientNotFoundException {
    return repository.findById(clientId)
        .orElseThrow(() -> extracted(clientId));
  }

  private ClientNotFoundException extracted(Long clientId) {
    return new ClientNotFoundException(clientId);
  }

  public Client createClient(Client client) {
    return repository.save(client);
  }

  public Client updateClient(Long clientId, Client updatedClient) throws ClientNotFoundException {
    Client existingClient = getClientById(clientId);
    existingClient.setUsername(updatedClient.getUsername());
    existingClient.setPassword(updatedClient.getPassword());
    return repository.save(existingClient);
  }

  public void deleteClient(Long clientId) throws ClientNotFoundException {
    Client existingClient = getClientById(clientId);
    repository.delete(existingClient);
  }

}
