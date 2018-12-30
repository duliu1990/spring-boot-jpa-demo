package com.devnp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devnp.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	//class
	List<Person> findByFirstName(String firstName);
	
	//xml
	List<Person> findByName(String firstName, String lastName);

	@Query("from Person where lastName=?1 and salary>1000")
	List<Person> findByLastName(String lastName);

	@Query("select count(*) from Person where lastName=?1 and salary>1000")
	int countByLastName(String lastName);

	@Query("select p from Person p where p.firstName like %?1")
	List<Person> findByFirstNameEndsWith(String firstName);
	
	//Native Queries
	@Query(value="select * from Person where first_name = ?1", nativeQuery = true)
	List<Person> findByFirstNameNative(String firstName);

}
