package com.techguyseli.Eventster.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * HttpException
 */
public class HttpException extends Exception {

  @Getter
  private HttpStatus status;

  public HttpException(String msg, HttpStatus status) {
    super(msg);
    this.status = status;
  }

}
