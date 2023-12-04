package com.techguyseli.Eventster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techguyseli.Eventster.repositories.ClientRepository;
import com.techguyseli.Eventster.services.ClientService;
import com.techguyseli.Eventster.exceptions.ClientNotFoundException;
import com.techguyseli.Eventster.exceptions.HttpException;
import com.techguyseli.Eventster.models.Client;

/**
 * ClientController
 */

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

  @Autowired
  private ClientService service;

  @GetMapping
  public List<Client> getAll() {
    return service.getAllClients();
  }

  @PostMapping
  public Client addClient(Client client) {
    return service.createClient(client);
  }

  @GetMapping("/{id}")
  public Client getClient(@PathVariable Long id) throws ClientNotFoundException {
    return service.getClientById(id);
  }

}
