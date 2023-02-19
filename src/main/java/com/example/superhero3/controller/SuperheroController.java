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

  private final Service service;

  public SuperheroController(Service service) {
    this.service = service;
    service.createTestData();
  }

  @GetMapping(path= {"", "/"})
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
  public ResponseEntity<List<Superhero>> search(@PathVariable String searchTerm) {
    List<Superhero> superhero = service.searchForSuperhero(searchTerm);
    return new ResponseEntity<>(superhero, HttpStatus.OK);
  }

  @PostMapping(path={"/create", "/create/"})
  public ResponseEntity<Superhero> createSuperhero(@RequestBody Superhero superhero) {
    Superhero newSuperhero = service.createSuperhero(superhero.getRealName(), superhero.getHeroName(), superhero.getCreationYear(),
            superhero.getSuperPower(), superhero.isHuman(), superhero.getPower());
    return new ResponseEntity<>(newSuperhero, HttpStatus.OK);
  }

  @PutMapping(path ="/edit")
  public ResponseEntity<Superhero> editSuperhero(@RequestBody Superhero superhero) {
    Superhero editSuperhero = service.editSuperhero(superhero);
    return new ResponseEntity<>(editSuperhero, HttpStatus.OK);
  }

  @DeleteMapping(path="/delete/{heroName}")
  public ResponseEntity<List<Superhero>> deleteSuperhelt(@PathVariable String heroName){
    List<Superhero> deleteSuperhero = service.deleteSuperhero(heroName);
    return new ResponseEntity<>(deleteSuperhero, HttpStatus.OK);
  }
}
