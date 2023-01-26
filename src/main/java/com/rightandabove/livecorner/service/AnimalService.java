package com.rightandabove.livecorner.service;

import com.rightandabove.livecorner.dto.AnimalDto;
import com.rightandabove.livecorner.model.Animal;
import com.rightandabove.livecorner.model.enums.AnimalType;
import com.rightandabove.livecorner.model.enums.AnimalWarehouse;

import java.util.List;

public interface AnimalService {

  AnimalWarehouse checkWarehouse(AnimalType animalType);

  void saveAnimal(Animal animal);

  List<AnimalDto> findAll();
}
