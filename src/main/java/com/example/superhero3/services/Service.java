package com.example.superhero3.services;

import com.example.superhero3.model.Superhero;
import com.example.superhero3.repositories.SuperheroRepo;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

  private SuperheroRepo superheroRepo;

  public void createTestData(){
    superheroRepo.superheroData();
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

  public List<Superhero> searchForSuperhero(String heroName) {
    return superheroRepo.searchForSuperhero(heroName);
  }

  public Superhero createSuperhero(String realName, String heroName, int creationYear, String superPower, boolean isHuman, double power) {
    return superheroRepo.createSuperhero(realName, heroName, creationYear, superPower, isHuman, power);
  }

  public void editSuperhero(Superhero superhero, String newRealName, String newHeroName, int newCreationYear, String newSuperPower, boolean newIsHuman, double newPower) {
    superheroRepo.editSuperhero(superhero, newRealName, newHeroName, newCreationYear, newSuperPower, newIsHuman, newPower);
  }

  public List<Superhero> deleteSuperhero(String searchTerm){
    return superheroRepo.deleteSuperhero(searchTerm);
  }
}
