package com.rightandabove.livecorner.service.impl;

import com.rightandabove.livecorner.dto.AnimalDto;
import com.rightandabove.livecorner.model.Animal;
import com.rightandabove.livecorner.model.enums.AnimalType;
import com.rightandabove.livecorner.model.enums.AnimalWarehouse;
import com.rightandabove.livecorner.repository.AnimalRepository;
import com.rightandabove.livecorner.service.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {

  private final AnimalRepository animalRepository;

  public AnimalServiceImpl(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }

  public AnimalWarehouse checkWarehouse(AnimalType animalType) {
    return animalRepository.findFirstByAnimalType(animalType).map(Animal::getAnimalWarehouse).orElse(null);
  }

  public void saveAnimal(Animal animal) {
    animalRepository.save(animal);
  }

  @Override
  public List<AnimalDto> findAll() {
    return convertToDtoList(animalRepository.findAll());
  }

  private List<AnimalDto> convertToDtoList(List<Animal> animals) {
    return animals.stream().map(animal -> new AnimalDto(
      animal.getId(), animal.getName(), animal.getAnimalClass(), animal.getAnimalType(), animal.getAnimalWarehouse()))
      .collect(Collectors.toList());
  }
}
