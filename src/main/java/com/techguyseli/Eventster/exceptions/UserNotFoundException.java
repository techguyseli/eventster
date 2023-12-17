package com.techguyseli.Eventster.exceptions;

import org.springframework.http.HttpStatus;


public class UserNotFoundException extends HttpException {

  public UserNotFoundException(Long userId) {
    super("The user with the ID: " + userId.toString() + " was not found!");
  }

  @Override
  public HttpStatus getHttpStatus() {
    return HttpStatus.NOT_FOUND;
  }

}
