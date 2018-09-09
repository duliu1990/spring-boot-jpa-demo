package com.devnp.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devnp.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	//查询人的名字
	Iterable<Person> findByFirstNameAndLastName(String firstName, String lastName);
	
	//查询年龄大于18岁
	Iterable<Person> findByAgeGreaterThan(int age);
	
	//查询第一名称以**开头
	Iterable<Person> findByFirstNameStartingWith(String firstName);
	
	//查询薪水在2000到3000之间，并以从小到大排序
	Iterable<Person> findBySalaryBetweenOrderBySalaryAsc(double start, double end);
	
	//查询1990/01/01之后出生的
	Iterable<Person> findByBirthAfter(Date birth);
	
	//查询第一名字包含“chen”，并忽略大小写
	Iterable<Person> findByFirstNameContainingIgnoreCase(String firstName);

}
