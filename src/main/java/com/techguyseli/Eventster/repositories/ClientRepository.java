package com.techguyseli.Eventster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techguyseli.Eventster.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
