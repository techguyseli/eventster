package com.techguyseli.Eventster.models;

import java.time.LocalDateTime;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Event
 */
@AllArgsConstructor
@Getter
@Setter

@Entity
@DiscriminatorValue("EVENT")
public class Event extends Item {

  private LocalDateTime startDate;
  private LocalDateTime endDate;

  public Event(String title,
      String description,
      ItemStatus status,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Client user) {
    super(title, description, status, user);
    this.startDate = startDate;
    this.endDate = endDate;
  }

}
