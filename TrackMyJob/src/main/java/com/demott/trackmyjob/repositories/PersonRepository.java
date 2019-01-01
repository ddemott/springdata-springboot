package com.demott.trackmyjob.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demott.trackmyjob.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	@Override
	public List<Person> findAll();

	public Person findPersonByPersonFirstNameAndPersonLastName(String personFirstName, String personLastName);

}
