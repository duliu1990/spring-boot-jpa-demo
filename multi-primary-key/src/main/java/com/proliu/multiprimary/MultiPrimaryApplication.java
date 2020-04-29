package com.proliu.multiprimary;

import com.proliu.multiprimary.entity.Animal;
import com.proliu.multiprimary.entity.AnimalKey;
import com.proliu.multiprimary.entity.Person;
import com.proliu.multiprimary.entity.PersonId;
import com.proliu.multiprimary.repository.AnimalRepository;
import com.proliu.multiprimary.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MultiPrimaryApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private AnimalRepository animalRepository;

	public static void main(String[] args) {
		SpringApplication.run(MultiPrimaryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//add record
		Person person = Person.builder().id(1).name("test").age(12).build();
		this.personRepository.save(person);

        Animal animal = Animal.builder().key(AnimalKey.builder().id(1).name("test").build()).age(12).build();
        this.animalRepository.save(animal);

        //query
        Person person1 = this.personRepository.findById(PersonId.builder().id(1).name("test").build()).get();
        log.info("Get the person by id : {} , {}", 1, person1);

        Animal animal1 = this.animalRepository.findById(AnimalKey.builder().id(1).name("test").build()).get();
        log.info("Get the animal by id : {} , {}", 1, animal1);
	}
}
