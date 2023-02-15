package com.example.superhero3.services;

import com.example.superhero3.model.Superhero;
import com.example.superhero3.repositories.SuperheroRepo;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

  private SuperheroRepo superheroRepo;

  public void createTestData(){
    superheroRepo.createTestData();
  }

  public Service() {
    this.superheroRepo = new SuperheroRepo();
  }

  public Superhero getSuperhero(String heroName) {
    return superheroRepo.getSuperhero(heroName);
  }

  public List<Superhero> getSuperheroes() {
    return superheroRepo.getSuperheroes();
  }

  public void createSuperhero(Superhero superhero) {
    superheroRepo.createSuperhero(
            superhero.getRealName(),
            superhero.getHeroName(),
            superhero.getCreationYear(),
            superhero.getSuperPower(),
            superhero.isHuman(),
            superhero.getPower());
  }

  public void editSuperhero(Superhero superhero) {
    superheroRepo.editSuperhero(superhero);
  }
}
