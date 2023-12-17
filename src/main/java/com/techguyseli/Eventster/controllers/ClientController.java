package com.techguyseli.Eventster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techguyseli.Eventster.services.ClientService;
import com.techguyseli.Eventster.exceptions.UserNotFoundException;

@RestController
@RequestMapping("/api/v1/clients")

public class ClientController {

  @Autowired
  private ClientService service;

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> getClient(@PathVariable Long id) throws UserNotFoundException {
    service.deleteClient(id);
    return ResponseEntity
      .status(HttpStatus.NO_CONTENT.value())
      .body(null);
  }

}
