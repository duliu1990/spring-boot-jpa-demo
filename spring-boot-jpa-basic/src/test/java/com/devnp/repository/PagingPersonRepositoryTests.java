package com.devnp.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PagingPersonRepositoryTests {
	
	@Autowired
	private PagingPersonRepository pagingPersonRepository ;

	/**
	 * 查询有数据，并根据条件进行排序
	 */
	@Test
	public void testFindAllBySort() {
		
		pagingPersonRepository.findAll(new Sort(Direction.DESC, "id")).forEach(System.out::println);
	}

	/**
	 * 查询有数据，并根据条件进行分页
	 */
	@Test
	public void testFindAllByPaging() {
		pagingPersonRepository.findAll(PageRequest.of(0, 2)).forEach(System.out::println);
	}
}
