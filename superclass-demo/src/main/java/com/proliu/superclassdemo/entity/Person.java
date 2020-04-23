package com.proliu.superclassdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="t_person")
public class Person extends BaseEntity {

	@Id
	@GeneratedValue
	private long id;

	private String name;

}
