package com.rightandabove.livecorner.controller;

import com.rightandabove.livecorner.dto.AnimalDto;
import com.rightandabove.livecorner.model.Animal;
import com.rightandabove.livecorner.model.enums.AnimalClass;
import com.rightandabove.livecorner.model.enums.AnimalType;
import com.rightandabove.livecorner.model.enums.AnimalWarehouse;
import com.rightandabove.livecorner.service.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animals")
public class AnimalController {

  private final AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @GetMapping("/all")
  public String getAnimals(Model model) {
    model.addAttribute("animalList", animalService.findAll());
    return "animals-table";
  }

  @GetMapping("/create")
  public String animalCreation(Model model) {
    model.addAttribute("animal", new AnimalDto());
    model.addAttribute("types", AnimalType.values());
    model.addAttribute("classes", AnimalClass.values());
    model.addAttribute("warehouses", AnimalWarehouse.values());
    return "animal-creation";
  }

  @PostMapping("/create")
  public String saveAnimal(AnimalDto animal, Model model) {
    AnimalWarehouse animalWarehouse = animalService.checkWarehouse(animal.getAnimalType());
    boolean warehouseOccupation = animalService.checkWarehouseOccupation(animal.getAnimalWarehouse());

    if(!warehouseOccupation || animal.getAnimalWarehouse().equals(animalWarehouse)) {
      animalService.saveAnimal(convertToEntity(animal));
      return "success";
    } else {
      model.addAttribute("selectedWarehouse", animal.getAnimalWarehouse());
      model.addAttribute("selectedType", animal.getAnimalType());
      model.addAttribute("rightWarehouse", animalWarehouse == null ? "another" : animalWarehouse);
      return "fail";
    }
  }

  private Animal convertToEntity(AnimalDto dto) {
    return new Animal(dto.getName(), dto.getAnimalClass(), dto.getAnimalType(), dto.getAnimalWarehouse());
  }
}
