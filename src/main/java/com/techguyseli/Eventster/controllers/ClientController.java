package com.techguyseli.Eventster.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techguyseli.Eventster.repositories.ClientRepository;
import com.techguyseli.Eventster.models.Client;

/**
 * ClientController
 */

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

  private final ClientRepository repository;

  ClientController(ClientRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  List<Client> getAll() {
    return repository.findAll();
  }

}
