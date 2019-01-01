package com.demott.trackmyjob.services;

import java.util.List;

import com.demott.trackmyjob.entities.Person;
import com.demott.trackmyjob.exceptions.NotFoundException;

public interface PersonService {

	void delete(Long id);

	void delete(Person person);

	Person findById(Long id) throws NotFoundException;

	List<Person> listAllPersons();

	Person save(Person person);

	Person update(Long personIdToUpdate, Person newPersonWithNewValues) throws NotFoundException;

}