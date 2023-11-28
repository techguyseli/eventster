package com.techguyseli.Eventster.entities;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
