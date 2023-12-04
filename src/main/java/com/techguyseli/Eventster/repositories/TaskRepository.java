package com.techguyseli.Eventster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techguyseli.Eventster.models.Task;

/**
 * TaskRepository
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
