package com.f1soft.abstractauditableentityexample.controller;

import com.f1soft.abstractauditableentityexample.entity.Person;
import com.f1soft.abstractauditableentityexample.service.serviceimpl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Person person){
        return ResponseEntity.ok().body(personService.create(person));
    }
}
