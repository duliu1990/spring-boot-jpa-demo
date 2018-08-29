package com.devnp.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devnp.entity.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudPersonRepositoryTests {

	@Autowired
	private CrudPersonRepository crudPersonRepository;
	
	/**
	 * 保存或者更新单个对象
	 * 根据ID判断对象是否存在，然后决定进行更新或者保存
	 */
	@Test
	public void testSave() {
		System.out.println(crudPersonRepository.save(new Person("DU", "LIU" , 18, new Date(), 55522.12)));
	}
	
	/**
	 * 保存或者更新多个对象
	 * 根据ID判断对象是否存在，然后决定进行更新或者保存
	 */
	@Test
	public void testSaveAll() {
		List<Person> list = new ArrayList<>();
		
		list.add(new Person("NAME-1", "JACK" , 20, new Date(), 6000.00));
		list.add(new Person("NAME-2", "TOME" , 18, new Date(), 7000.12));
		
		crudPersonRepository.saveAll(list).forEach(System.out::println);
	}
	
	/**
	 * 根据主键进行查询
	 */
	@Test
	public void testFindById() {
		System.out.println(crudPersonRepository.findById(10).get());
	}
	
	/**
	 * 根据查询全部数据
	 */
	@Test
	public void testFindAll() {
		Iterable<Person> persons = crudPersonRepository.findAll();
		
		persons.forEach(System.out::println);
	}
	
	/**
	 * 根据主键判断是否存在
	 */
	@Test
	public void testExistsById() {
		System.out.println(crudPersonRepository.existsById(10));
	}
	
	/**
	 * 根据主键删除记录
	 * 先会根据ID去查询对象，然后在进行删除操作
	 */
	@Test
	public void testDeleteById() {
		crudPersonRepository.deleteById(11);
	}

	/**
	 * 根据对象进行删除
	 */
	@Test
	public void testDelete() {
		crudPersonRepository.delete(new Person(12));
	}
	
	

}
