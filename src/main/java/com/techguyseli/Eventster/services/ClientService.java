package com.techguyseli.Eventster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techguyseli.Eventster.entities.Client;
import com.techguyseli.Eventster.exceptions.UserNotFoundException;
import com.techguyseli.Eventster.repositories.ClientRepository;

@Service
public class ClientService {

  @Autowired
  private ClientRepository repository;

  public List<Client> getAllClients() {
    return repository.findAll();
  }

  public Client getClientById(Long ClientId) throws UserNotFoundException {
    return repository.findById(ClientId)
        .orElseThrow(() -> extracted(ClientId));
  }

  private UserNotFoundException extracted(Long ClientId) {
    return new UserNotFoundException(ClientId);
  }

  public Client createClient(Client Client) {
    return repository.save(Client);
  }

  public Client updateClient(Long ClientId, Client updatedClient) throws UserNotFoundException {
    Client existingClient = getClientById(ClientId);
    existingClient.setUsername(updatedClient.getUsername());
    existingClient.setPassword(updatedClient.getPassword());
    return repository.save(existingClient);
  }

  public void deleteClient(Long ClientId) throws UserNotFoundException {
    Client existingClient = getClientById(ClientId);
    repository.delete(existingClient);
  }

}
