package com.techguyseli.Eventster.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Entity
public class Client extends User {

  private AccountStatus accountStatus;
  @OneToMany
  private List<Item> items;

  public Client(String username, String password, AccountStatus accountStatus) {
    super(username, password);
    this.accountStatus = accountStatus;
  }

}
