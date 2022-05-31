package com.laziz.tasks.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laziz.tasks.entities.Person;
import com.laziz.tasks.entities.Task;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	@Query("select p from Person p where p.nomP like %:nomPerson% ")
	List<Person> findByPersonName( String nomPerson);
	
}