package com.techguyseli.Eventster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techguyseli.Eventster.models.Client;

/**
 * ClientRepository
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
