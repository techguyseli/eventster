package com.techguyseli.Eventster.exceptions;

import org.springframework.http.HttpStatus;

/**
 * ClientNotFoundException
 */
public class ClientNotFoundException extends HttpException {

  public ClientNotFoundException(Long clientId) {
    super("The client with the ID: " + clientId.toString() + " was not found!", HttpStatus.NOT_FOUND);
  }

}
