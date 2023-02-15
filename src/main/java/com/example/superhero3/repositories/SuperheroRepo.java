package com.example.superhero3.repositories;

import com.example.superhero3.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepo {

  ArrayList<Superhero> superheroes = new ArrayList<>();

  public void createSuperhero(String realName, String heroName, int creationYear, String superPower, boolean isHuman, double power) {
    Superhero superhero = new Superhero(realName,heroName,creationYear,superPower,isHuman, power);
    superheroes.add(superhero);
  }

  // TEST DATA
  public void createTestData(){
    createSuperhero("Victor Hanert", "Actionman", 2001, "Hot", true, 999);
    createSuperhero("Bruce Wayne", "Batman", 1965, "Rich", true, 2);
    createSuperhero("Peter Parker", "Spider-man", 1970, "Spider-senses", true, 2.3);
    createSuperhero("Tony Stark", "Iron-Man", 1998, "Rich", true, 1.2);
    createSuperhero("T'Challa", "Black-Panther", 1973, "Strong and rich", true, 5.5);
    createSuperhero("Bruce Banner", "Hulk", 1967, "Very strong", true, 3.2);
  }

  public Superhero getSuperhero(String heroName) {
    for (Superhero superhero : superheroes){
      if (superhero.getHeroName().equals(heroName)){
        return superhero;
      }
    }
    return null;
  }

  public List<Superhero> getSuperheroes() {
    return new ArrayList<>(superheroes);
  }

  public void editSuperhero(Superhero superhero) {
  }
}
