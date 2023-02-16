package com.example.superhero3.controller;

import com.example.superhero3.model.Superhero;
import com.example.superhero3.services.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("superhero")
public class SuperheroController {

  private Service service;

  public SuperheroController(Service service) {
    this.service = service;
    service.createTestData();
  }

  @GetMapping(path= {"", "/", "/superheroes"})
  public ResponseEntity<List<Superhero>> allSuperheroes() {
    List<Superhero> superheroes = service.getSuperheroes();
    return new ResponseEntity<>(superheroes,HttpStatus.OK);
  }

  @GetMapping(path="/{heroName}")
  public ResponseEntity<Superhero> specificSuperhero(@PathVariable String heroName) {
    Superhero superhero = service.getSuperhero(heroName);
    return new ResponseEntity<>(superhero, HttpStatus.OK);
  }

  @GetMapping(path="search/{searchTerm}")
  public ResponseEntity<List<Superhero>> velkommen(@PathVariable String searchTerm) {
    List<Superhero> superhero = service.searchForSuperhero(searchTerm);
    return new ResponseEntity<>(superhero, HttpStatus.OK);
  }

  @PostMapping({"/create", "/create/"})
  public ResponseEntity<Superhero> createSuperhero(@RequestBody Superhero superhero) {
    Superhero newSuperhelt = service.createSuperhero(superhero.getRealName(), superhero.getHeroName(), superhero.getCreationYear(),
            superhero.getSuperPower(), superhero.isHuman(), superhero.getPower());
    return new ResponseEntity<>(newSuperhelt, HttpStatus.CREATED);
  }

  @PutMapping(path = {"/edit", "/edit/"})
  public ResponseEntity<Superhero> putMessage(@RequestBody Superhero superhero) {
    service.editSuperhero(superhero, superhero.getRealName(), superhero.getHeroName(), superhero.getCreationYear(),
            superhero.getSuperPower(), superhero.isHuman(), superhero.getPower());
    return new ResponseEntity<>(superhero, HttpStatus.OK);
  }

  @DeleteMapping(path="/delete/{heroName}")
  public ResponseEntity<List<Superhero>> sletSuperhelt(@PathVariable String heroName){
    List<Superhero> deleteSuperhero = service.deleteSuperhero(heroName);
    return new ResponseEntity<>(deleteSuperhero, HttpStatus.OK);
  }
}
