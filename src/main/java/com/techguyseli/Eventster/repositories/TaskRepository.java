package com.techguyseli.Eventster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techguyseli.Eventster.models.Task;

/**
 * TaskRepository
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}
