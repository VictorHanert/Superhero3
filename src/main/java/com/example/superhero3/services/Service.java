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

  public Superhero editSuperhero(Superhero superhero){
    return superheroRepo.editSuperhero(superhero);
  }

  public List<Superhero> deleteSuperhero(String searchTerm){
    return superheroRepo.deleteSuperhero(searchTerm);
  }
}
