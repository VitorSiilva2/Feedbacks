package org.example.service;

import org.example.model.Person;
import org.example.repositories.PersonRepository;

import java.util.List;

public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(String name, String email, String office, Integer userId) {
        Person person = new Person(name, email, office, userId);
        personRepository.addPerson(person);
    }

    public List<Person> getAllPeoples() {
        return personRepository.getAllPerson();
    }

    public Person getPeopleById(int id) {
        return personRepository.getPeopleById(id);
    }

    public void updatePerson(Person person) {
        personRepository.updatePerson(person);
    }

    public void deletePerson(int id) {
        personRepository.deletePerson(id);
    }



}
