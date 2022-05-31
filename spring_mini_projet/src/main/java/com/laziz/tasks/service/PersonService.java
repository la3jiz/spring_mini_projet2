package com.laziz.tasks.service;

import java.util.List;

import com.laziz.tasks.entities.Person;
import com.laziz.tasks.entities.Task;

public interface PersonService {

    List <Person> findAll();
    Person savePerson(Person p);
    Person updatePerson(Person p);
    void deletePerson(Person p);
     void deletePersonById(Long id);
     Person getPerson(Long id);
     List<Person> findByPersonName(String nomPerson);

}