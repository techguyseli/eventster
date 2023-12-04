package com.techguyseli.Eventster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techguyseli.Eventster.models.Event;

/**
 * EventRepository
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
