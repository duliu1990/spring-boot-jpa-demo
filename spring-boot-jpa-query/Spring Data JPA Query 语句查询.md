# Spring Data JPA Query 语句查询

使用关键字方式的查询，在面对很多字段或者条件的时候显得过于冗长，使用@Query语句的方式也是一直相对清晰的查询。

演示的版本：
1. Spring Boot 2.1.1.RELEASE
2. My SQL 8.*
3. JDK 1.8 +



## 方式

使用(Query)语句查询可以在(Entity)类、(Repository)方法和xml去配置查询语句。JPA语句查询和直接使用`Hibernate`的`HQL`类似，几乎没有什么太大的差别。



### Entity类上面

首先，在Entity类上面添加`@NamedQuery`注解，在其里面添加名称和语句, 最后在Repository里面去声明其方法的名称。

```java
@Entity
@NamedQuery(name = "Person.findByFirstName", query = "select p from Person p where p.firstName = ?1 and salary>2000 ")
public class Person {
    
}
```

```java
List<Person> findByFirstName(String firstName);
```

这时候，虽然查询方法的名称和关键字类型，但是实际运行会以运行语句查询。



### Repository方法上面

通过在方法什么添加`@Query`注解，然后添加语句。

```java
@Query("from Person where lastName=?1 and salary>1000")
	List<Person> findByLastName(String lastName);
```

```java
@Query("select count(*) from Person where lastName=?1 and salary>1000")
	int countByLastName(String lastName);
```

```java
@Query("select p from Person p where p.firstName like %?1")
	List<Person> findByFirstnameEndsWith(String firstName);
```



### xml中配置

在`META-INF`下面创建`orm.xml` 配置对应的名称和语句：



```
<?xml version="1.0" encoding="UTF-8"?>
<entity-mappings xmlns="http://java.sun.com/xml/ns/persistence/orm"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://java.sun.com/xml/ns/persistence/orm http://java.sun.com/xml/ns/persistence/orm_2_0.xsd"
                 version="2.0">
                 
<named-query name="Person.findByName">
  <query>select p from Person p where p.firstName = ?1 or p.lastName=?2 and salary>1000</query>
</named-query>

</entity-mappings>
```



## 原生SQL



原生语句的SQL使用，只是有微小的配置差别：

1. 在类上

   使用 `@NamedNativeQuery` 替代 `@NamedQuery`

2. Repository 方法上面

   在使用`@Query` 属性中，配置"nativeQuery = true"

   ```java
   @Query(value="select * from Person where first_name = ?1", nativeQuery = true)
   	List<Person> findByFirstNameNative(String firstName);
   ```

3. XML

   "<named-query>" 替换成“<named-native-query>”



## 项目地址

