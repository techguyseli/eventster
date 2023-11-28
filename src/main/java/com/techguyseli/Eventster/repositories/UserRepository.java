package com.techguyseli.Eventster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techguyseli.Eventster.entities.User;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
