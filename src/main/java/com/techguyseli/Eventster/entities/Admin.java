package com.techguyseli.Eventster.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Admin
 */

public class Admin extends User {

  private Admin() {
    setUsername("root");
    setPassword("root");
  }

}
