package com.proliu.multiprimary.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="t_animal")
public class Animal {
	
	@EmbeddedId
	private AnimalKey key;

	private int age;

	@Version
	private int version;
}
