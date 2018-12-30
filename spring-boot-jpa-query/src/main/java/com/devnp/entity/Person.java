
package com.devnp.entity ;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "Person.findByFirstName", query = "select p from Person p where p.firstName = ?1 and salary>2000 ")
public class Person {
	
	@Id
	@GeneratedValue
	private int id ;
	
	@Column(name = "Last_Name")
	private String lastName ;
	
	@Column(name = "First_Name")
	private String firstName ;
	
	@Column(name = "Age")
	private int age ;
	
	@Column(name = "Birth")
	@Temporal(TemporalType.DATE)
	private Date birth ;
	
	@Column(name = "Salary")
	private double salary ;
	
	public Person() {
		super();
	}
	
	
	public Person(int id) {
		super();
		this.id = id;
	}

	public Person(String lastName, String firstName, int age, Date birth, double salary) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.birth = birth;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", age=" + age + ", birth="
				+ birth + ", salary=" + salary + "]";
	}
	
	
}
