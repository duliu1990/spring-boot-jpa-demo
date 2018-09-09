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
public class SpringBootJpaKeywordApplicationTests {

	@Autowired
	private PersonRepository personRepository;
	
	//先添加一些数据
	@Test
	public void save() {
		List<Person> list = new ArrayList<>();
		
		LocalDate localDate = LocalDate.of(1900, 1, 1);
		Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		list.add(new Person("NAME-1", "JACK" , 20, new Date(), 2000.00));
		list.add(new Person("NAME-2", "chen" , 20, date, 2000.12));
		list.add(new Person("NAME-3", "TOME" , 25, new Date(), 1500.12));
		list.add(new Person("NAME-4", "Chen" , 11, date, 3000.12));
		list.add(new Person("NAME-5", "Li" , 29, new Date(), 4000.52));
		
		personRepository.saveAll(list);
	}
	
	//查询人的名字
	@Test
	public void testFindByFirstNameAndLastName() {
		Iterable<Person> persons = personRepository.findByFirstNameAndLastName("JACK", "NAME-1");
		
		persons.forEach(System.out::println);
	}
	
	//查询年龄大于18岁
	@Test
	public void testFindByAgeGreaterThan() {
		Iterable<Person> persons = personRepository.findByAgeGreaterThan(18);
		persons.forEach(System.out::println);
	}
	
	//查询第一名称以**开头
	@Test
	public void testFindByFirstNameStartingWith() {
		Iterable<Person> persons = personRepository.findByFirstNameStartingWith("chen");
		persons.forEach(System.out::println);
	}
	
	//查询薪水在2000到3000之间，并以从小到大排序
	@Test
	public void testFindBySalaryBetweenOrderBySalaryAsc() {
		Iterable<Person> persons = personRepository.findBySalaryBetweenOrderBySalaryAsc(2000.00, 3000.00);
		persons.forEach(System.out::println);
	}
	
	//查询1990/01/01之后出生的
	@Test
	public void testFindByBirthAfter() {
		LocalDate localDate = LocalDate.of(1990, 1, 1);
		Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		Iterable<Person> persons = personRepository.findByBirthAfter(date);
		persons.forEach(System.out::println);
	}
	
	//查询第一名字包含“chen”，并忽略大小写
	@Test
	public void testFindByFirstNameContainingIgnoreCase() {
		Iterable<Person> persons = personRepository.findByFirstNameContainingIgnoreCase("chen");
		persons.forEach(System.out::println);
	}

}
