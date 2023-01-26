package com.rightandabove.livecorner.repository;

import com.rightandabove.livecorner.model.Animal;
import com.rightandabove.livecorner.model.enums.AnimalType;
import com.rightandabove.livecorner.model.enums.AnimalWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

  Optional<Animal> findFirstByAnimalType(AnimalType animalType);

  @Query("SELECT COUNT(a) > 0 FROM Animal a WHERE a.animalWarehouse = :animalWarehouse")
  boolean checkWarehouseOccupation(AnimalWarehouse animalWarehouse);
}
