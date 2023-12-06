package com.techguyseli.Eventster.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("CLIENT"));
  }

}
