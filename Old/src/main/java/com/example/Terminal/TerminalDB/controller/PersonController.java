package com.example.Terminal.TerminalDB.controller;

import com.example.Terminal.TerminalDB.entity.Person;
import com.example.Terminal.TerminalDB.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;
    @PostMapping("/users")
    public String savePerson(@RequestBody Person person) throws ExecutionException, InterruptedException {

    return PersonService.savePerson(person);

    }
    @GetMapping ("/users/{name}")
    public Person getPerson(@PathVariable String name) throws ExecutionException, InterruptedException {

        return PersonService.getPersonDetails(name);

    }

    @PutMapping ("/users")
    public String update(@RequestBody Person person) throws ExecutionException, InterruptedException {

        return PersonService.updatePerson(person);

    }

    @DeleteMapping ("/users/{name}")
    public String delete(@PathVariable String name) throws ExecutionException, InterruptedException {

        return PersonService.deletePerson(name);

    }

}
