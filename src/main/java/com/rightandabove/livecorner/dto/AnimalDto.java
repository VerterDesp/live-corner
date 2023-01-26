package com.rightandabove.livecorner.dto;

import com.rightandabove.livecorner.model.enums.AnimalClass;
import com.rightandabove.livecorner.model.enums.AnimalType;
import com.rightandabove.livecorner.model.enums.AnimalWarehouse;

import javax.validation.constraints.NotNull;
import java.util.Objects;


public class AnimalDto {
  private Integer id;

  @NotNull
  private String name;

  @NotNull
  private AnimalClass animalClass;

  @NotNull
  private AnimalType animalType;

  @NotNull
  private AnimalWarehouse animalWarehouse;

  public AnimalDto() {

  }

  public AnimalDto(Integer id, String name, AnimalClass animalClass, AnimalType animalType, AnimalWarehouse animalWarehouse) {
    this.id = id;
    this.name = name;
    this.animalClass = animalClass;
    this.animalType = animalType;
    this.animalWarehouse = animalWarehouse;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AnimalClass getAnimalClass() {
    return animalClass;
  }

  public void setAnimalClass(AnimalClass animalClass) {
    this.animalClass = animalClass;
  }

  public AnimalType getAnimalType() {
    return animalType;
  }

  public void setAnimalType(AnimalType animalType) {
    this.animalType = animalType;
  }

  public AnimalWarehouse getAnimalWarehouse() {
    return animalWarehouse;
  }

  public void setAnimalWarehouse(AnimalWarehouse animalWarehouse) {
    this.animalWarehouse = animalWarehouse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AnimalDto animalDto = (AnimalDto) o;
    return Objects.equals(id, animalDto.id) && Objects.equals(name, animalDto.name) && animalClass == animalDto.animalClass && animalType == animalDto.animalType && animalWarehouse == animalDto.animalWarehouse;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, animalClass, animalType, animalWarehouse);
  }

  @Override
  public String toString() {
    return "AnimalDto{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", animalClass=" + animalClass +
      ", animalType=" + animalType +
      ", animalWarehouse=" + animalWarehouse +
      '}';
  }
}
