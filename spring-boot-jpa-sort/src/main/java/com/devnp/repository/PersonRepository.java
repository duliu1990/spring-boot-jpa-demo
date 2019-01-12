package com.devnp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devnp.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("select u from Person u where u.firstName like ?1%")
	List<Person> findByFirstNameAndSort(String firstName, Sort sort);
	
	
}
