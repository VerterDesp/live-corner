package com.rightandabove.livecorner.repository;

import com.rightandabove.livecorner.model.Animal;
import com.rightandabove.livecorner.model.enums.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

  Optional<Animal> findFirstByAnimalType(AnimalType animalType);

}
