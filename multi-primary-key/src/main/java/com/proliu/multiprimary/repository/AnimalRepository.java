package com.proliu.multiprimary.repository;

import com.proliu.multiprimary.entity.Animal;
import com.proliu.multiprimary.entity.AnimalKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, AnimalKey> {
}
