package org.example.controller;

import org.example.model.Person;
import org.example.service.PersonService;

import java.util.List;

public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(String nome, String email, String cargo) {
        personService.addPerson(nome, email, cargo);
    }

    public List<Person> getAllPeoples() {
        return personService.getAllPeoples();
    }

    public void updatePerson(Person person) {
        personService.updatePerson(person);
    }

    public void deletePerson(int id) {
        personService.deletePerson(id);
    }
}
