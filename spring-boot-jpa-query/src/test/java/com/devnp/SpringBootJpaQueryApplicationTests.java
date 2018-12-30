package com.devnp;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devnp.entity.Person;
import com.devnp.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaQueryApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	// save some data
	@Test
	public void save() {
		List<Person> list = new ArrayList<>();

		LocalDate localDate = LocalDate.of(1900, 1, 1);
		Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

		list.add(new Person("NAME-1", "JACK", 20, new Date(), 1000.00));
		list.add(new Person("NAME-2", "chen", 20, date, 2000.12));
		list.add(new Person("NAME-3", "TOME", 25, new Date(), 1500.12));
		list.add(new Person("NAME-4", "Chen", 11, date, 3000.12));
		list.add(new Person("NAME-5", "Li", 29, new Date(), 4000.52));

		list.add(new Person("NAME-1", "JACK", 20, new Date(), 1000.00));

		personRepository.saveAll(list);
	}

	// find by first name use query
	@Test
	public void findByFirstName() {
		List<Person> list = personRepository.findByFirstName("JACK");

		System.out.println(list.size());
	}

	// find by last name use query
	@Test
	public void findByLastName() {
		List<Person> list = personRepository.findByLastName("NAME-1");

		System.out.println(list.size());
	}

	// count by name
	@Test
	public void countByLastName() {
		int count = personRepository.countByLastName("NAME-1");

		System.out.println(count);
	}

	// find by first name ends with use query
	@Test
	public void findByFirstnameEndsWith() {
		List<Person> list = personRepository.findByFirstNameEndsWith("JA");

		System.out.println(list.size());
	}

	// find by name ends with use xml query
	@Test
	public void findByName() {
		List<Person> list = personRepository.findByName("JA", "JA");

		System.out.println(list.size());
	}

	// find by name with Native Queries
	@Test
	public void findByFirstNameNative() {
		List<Person> list = personRepository.findByFirstNameNative("JA");

		System.out.println(list.size());
	}

}
