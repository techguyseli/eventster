package com.techguyseli.Eventster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techguyseli.Eventster.entities.Item;

/**
 * ItemRepository
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

}
