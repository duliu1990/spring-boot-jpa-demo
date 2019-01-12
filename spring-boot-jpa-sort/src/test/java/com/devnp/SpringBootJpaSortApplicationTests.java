package com.devnp;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.context.junit4.SpringRunner;

import com.devnp.entity.Person;
import com.devnp.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaSortApplicationTests {

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
	
	@Test
	public void testFindByFirstNameAndSort() {
		List<Person> list = personRepository.findByFirstNameAndSort("JA", new Sort(Direction.ASC, "salary"));
		
		list.forEach(data -> System.out.println(data));
	}
	
	@Test
	public void testFindByFirstNameAndSort2() {
		List<Person> list = personRepository.findByFirstNameAndSort("JA",  JpaSort.unsafe(Direction.ASC, "len(lastName)"));
		
		list.forEach(data -> System.out.println(data));
	}
}

