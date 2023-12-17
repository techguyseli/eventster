package com.techguyseli.Eventster.exceptions;

import org.springframework.http.HttpStatus;

public abstract class HttpException extends Exception {

  public HttpException(String msg){
    super(msg);
  }

  public abstract HttpStatus getHttpStatus();
}
