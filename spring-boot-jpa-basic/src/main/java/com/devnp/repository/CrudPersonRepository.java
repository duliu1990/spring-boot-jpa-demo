package com.devnp.repository;

import org.springframework.data.repository.CrudRepository;

import com.devnp.entity.Person;

public interface CrudPersonRepository extends CrudRepository<Person, Integer> {

}
