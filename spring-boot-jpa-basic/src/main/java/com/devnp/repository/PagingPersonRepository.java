package com.devnp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.devnp.entity.Person;

public interface PagingPersonRepository extends PagingAndSortingRepository<Person, Integer> {

}
