package com.devnp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devnp.entity.Person;

public interface JpaPersonRepository extends JpaRepository<Person, Integer> {

}
