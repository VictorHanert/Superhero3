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
  HttpHeaders responseHeaders = new HttpHeaders();

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
  public ResponseEntity<String> specificSuperhero(@PathVariable String heroName) {
    Superhero superhero = service.getSuperhero(heroName);
    responseHeaders.set("Content-Type","text/html");

    return new ResponseEntity<>(
            "<html><body><h2>" + superhero.getHeroName() +
                    "</h2>" + superhero + "</body></html>",responseHeaders, HttpStatus.OK);
  }

  @PostMapping("/create")
  public ResponseEntity<Superhero> createSuperhero(@RequestBody Superhero superhero) {
    service.createSuperhero(superhero);
    return new ResponseEntity<>(superhero, HttpStatus.OK);
  }

  @PutMapping(path = "/edit")
  public ResponseEntity<Superhero> putMessage(@RequestBody Superhero superhero) {
    service.editSuperhero(superhero);
    return new ResponseEntity<>(superhero, HttpStatus.OK);
  }
}
