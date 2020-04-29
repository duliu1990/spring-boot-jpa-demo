package com.proliu.multiprimary.repository;

import com.proliu.multiprimary.entity.Person;
import com.proliu.multiprimary.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, PersonId> {

}
