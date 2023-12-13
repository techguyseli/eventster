package com.techguyseli.Eventster.entities;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

@Entity
public class Task extends Item {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer priority;
  private Set<DayOfWeek> days;
  private Integer dailyRepititions;
  private Duration estimatedDuration;
  private Set<String> subtasks;

  public Task(String title,
      String description,
      ItemStatus status,
      Integer priority,
      Set<DayOfWeek> days,
      Integer dailyRepititions,
      Duration estimatedDuration,
      Set<String> subtasks,
      Client user) {
    super(title, description, status, user);
    this.priority = priority;
    this.days = days;
    this.dailyRepititions = dailyRepititions;
    this.estimatedDuration = estimatedDuration;
    this.subtasks = subtasks;
  }
}
