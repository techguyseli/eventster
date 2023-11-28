package com.techguyseli.Eventster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techguyseli.Eventster.entities.Task;

/**
 * TaskRepository
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}
