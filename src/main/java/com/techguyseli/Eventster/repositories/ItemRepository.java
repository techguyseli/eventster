package com.techguyseli.Eventster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techguyseli.Eventster.entities.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
    
}
