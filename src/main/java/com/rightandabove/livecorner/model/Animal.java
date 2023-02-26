package com.rightandabove.livecorner.model;

import com.rightandabove.livecorner.model.enums.AnimalClass;
import com.rightandabove.livecorner.model.enums.AnimalType;
import com.rightandabove.livecorner.model.enums.AnimalWarehouse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
  private String name;

  @NotNull
  @Enumerated(EnumType.STRING)
  private AnimalClass animalClass;

  @NotNull
  @Enumerated(EnumType.STRING)
  private AnimalType animalType;

  @NotNull
  @Enumerated(EnumType.STRING)
  private AnimalWarehouse animalWarehouse;

  public Animal() {
  }

  public Animal(String name, AnimalClass animalClass, AnimalType animalType, AnimalWarehouse animalWarehouse) {
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
    Animal animal = (Animal) o;
    return id.equals(animal.id) && name.equals(animal.name) && animalClass == animal.animalClass && animalType == animal.animalType && animalWarehouse == animal.animalWarehouse;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, animalClass, animalType, animalWarehouse);
  }

  @Override
  public String toString() {
    return "Animal{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", animalClass=" + animalClass +
      ", animalType=" + animalType +
      ", animalWarehouse=" + animalWarehouse +
      '}';
  }
}