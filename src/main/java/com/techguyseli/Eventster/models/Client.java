package com.techguyseli.Eventster.models;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

/**
 * Client
 */

@Entity
@DiscriminatorValue("CLIENT")
public class Client extends User {

  @OneToMany(mappedBy = "user")
  List<Item> items;

  public Client(String username, String password) {
    super(username, password);
  }

}
