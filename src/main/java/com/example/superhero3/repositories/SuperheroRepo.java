package com.example.superhero3.repositories;

import com.example.superhero3.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepo {

  // TEST DATA
  public void superheroData() {
    createSuperhero("Victor Hanert", "Actionman", 2001, "Hot", true, 999);
    createSuperhero("Bruce Wayne", "Batman", 1965, "Rich", true, 2);
    createSuperhero("Peter Parker", "Spider-man", 1970, "Spider-senses", true, 2.3);
    //createSuperhero("Tony Stark", "Iron-Man", 1998, "Rich", true, 1.2);
    //createSuperhero("T'Challa", "Black-Panther", 1973, "Strong and rich", true, 5.5);
    //createSuperhero("Bruce Banner", "Hulk", 1967, "Very strong", true, 3.2);
  }

  ArrayList<Superhero> superheroes = new ArrayList<>();

  public Superhero createSuperhero(String realName, String heroName, int creationYear, String superPower, boolean isHuman, double power) {
    Superhero superhero = new Superhero(realName, heroName, creationYear, superPower, isHuman, power);
    superheroes.add(superhero);
    return superhero;
  }

  public Superhero getSuperhero(String heroName) {
    for (Superhero superhero : superheroes) {
      if (superhero.getHeroName().equals(heroName)) {
        return superhero;
      }
    }
    return null;
  }

  public List<Superhero> getSuperheroes() {
    return new ArrayList<>(superheroes);
  }

  public List<Superhero> searchForSuperhero(String searchTerm) {
    List<Superhero> searchResults = new ArrayList<>();

    for (Superhero superhero : superheroes) {
      String name = superhero.getHeroName().toLowerCase();
      if (name.contains(searchTerm.toLowerCase().trim())) {
        searchResults.add(superhero);
      }
    }
    return searchResults;
  }

  public List<Superhero> deleteSuperhero(String searchTerm) {
    List<Superhero> searchResults;
    searchResults = searchForSuperhero(searchTerm);

    for (Superhero superhero : searchResults) {
      getSuperheroes().remove(superhero);
    }
    return searchResults;
  }

  public void editSuperhero(Superhero editSuperhero, String newRealName, String newHeroName, int newCreationYear, String newSuperPower, boolean newIsHuman, double newPower) {
    for (Superhero superhero : superheroes){
      if (superhero.getHeroName().equals(editSuperhero.getHeroName())){
      if (newRealName != null) {
        editSuperhero.setRealName(newRealName);
      }
      if (newHeroName != null) {
        editSuperhero.setHeroName(newHeroName);
      }
      if (newCreationYear >= 0) {
        editSuperhero.setCreationYear(String.valueOf(newCreationYear));
      }
      if (newSuperPower != null) {
        editSuperhero.setSuperPower(newSuperPower);
      }
      if (newIsHuman) {
        editSuperhero.setHuman(newIsHuman);
      }
      if (newPower >= 0) {
        editSuperhero.setPower(String.valueOf(newPower));
      }
      }
    }
  }
}
