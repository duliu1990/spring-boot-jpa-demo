package com.proliu.multiprimary.entity;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_person")
@IdClass(PersonId.class)
public class Person {
	
	@Id
	private int id;
	
	@Id
	@Column(length=12)
	private String name;
	
	private int age;

	@Version
	private int version;

}
