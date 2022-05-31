package com.laziz.tasks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laziz.tasks.entities.Person;
import com.laziz.tasks.repos.PersonRepository;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List <Person> findAll() {
        return personRepository.findAll();
    }

	@Override
	public Person savePerson(Person p) {
		return personRepository.save(p);
	}

	@Override
	public Person updatePerson(Person p) {
		return personRepository.save(p);
	}

	@Override
	public void deletePerson(Person p) {
		personRepository.delete(p);
	}

	@Override
	public void deletePersonById(Long id) {
		personRepository.deleteById(id);
	}

	@Override
	public Person getPerson(Long id) {
		return personRepository.findById(id).get();
	}

	@Override
	public List<Person> findByPersonName(String nomPerson) {
		// TODO Auto-generated method stub
		return personRepository.findByPersonName(nomPerson);
	}

   
}