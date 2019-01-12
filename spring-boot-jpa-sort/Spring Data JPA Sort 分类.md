# Spring Data JPA Sort 分类

Spring Data JPA 在使用Sort上面可以使用 `PageRequest` 或 `Sort` 来完成，默认情况下，Spring Data JPA 拒绝任何包含函数调用的Order实例，但您可以使用JpaSort.unsafe添加可能不安全的排序。

演示的版本：

1. Spring Boot 2.1.1.RELEASE
2. My SQL 8.*
3. JDK 1.8 +
4. 

## 方法

以使用`Sort` 为例，通常在方法的上面会加上`@Query` 来设置查询的规则和条件：

```java
@Query("select u from Person u where u.firstName like ?1%")
List<Person> findByFirstNameAndSort(String firstName, Sort sort);
```

## 测试

在分类的上面主要有 `ASC   ` 和 `DESC` 两种，` Sort` 默认使用 `ASC` 进行排序，在分类的属性当中，可以使用字段，别名 名称。

`Sort`表达式指向域模型中的属性：

```java
@Test
public void testFindByFirstNameAndSort() {
		List<Person> list = personRepository.findByFirstNameAndSort("JA", new Sort(Direction.ASC, "salary"));
		
		list.forEach(data -> System.out.println(data));
	}
```

输出的SQL：

```sql
select person0_.id as id1_0_, person0_.age as age2_0_, person0_.birth as birth3_0_, person0_.first_name as first_na4_0_, person0_.last_name as last_nam5_0_, person0_.salary as salary6_0_ from person person0_ where person0_.first_name like ? order by person0_.salary asc
```

`JpaSort`表达式指向域模型中的属性：

```java
@Test
public void testFindByFirstNameAndSort2() {
		List<Person> list = personRepository.findByFirstNameAndSort("JA",  JpaSort.unsafe(Direction.ASC, "len(lastName)"));
		
		list.forEach(data -> System.out.println(data));
	}
```

输出的SQL：

```sql
select person0_.id as id1_0_, person0_.age as age2_0_, person0_.birth as birth3_0_, person0_.first_name as first_na4_0_, person0_.last_name as last_nam5_0_, person0_.salary as salary6_0_ from person person0_ where person0_.first_name like ? order by len(person0_.last_name) asc
```



## 完整示例

完整演示代码可以通过GitHub : 

