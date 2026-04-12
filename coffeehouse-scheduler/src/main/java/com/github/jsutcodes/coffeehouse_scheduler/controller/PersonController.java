package com.github.jsutcodes.coffeehouse_scheduler.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jsutcodes.coffeehouse_scheduler.entity.Person;
import com.github.jsutcodes.coffeehouse_scheduler.service.PersonService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/person") // Base URL for all endpoints in this class
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    // GET: http://localhost:8080/api/menus
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    // GET: http://localhost:8080/api/person/1
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: http://localhost:8080/api/person
    @PostMapping
    public Person createMenu(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    // DELETE: http://localhost:8080/api/person/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}

