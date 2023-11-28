package com.techguyseli.Eventster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techguyseli.Eventster.entities.Event;

/**
 * EventRepository
 */
public interface EventRepository extends JpaRepository<Event, Long> {

}
