package com.demott.trackmyjob.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demott.trackmyjob.entities.Person;
import com.demott.trackmyjob.services.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	/**
	 * Delete PERSON by ID
	 * 
	 * @param personId
	 */
	@DeleteMapping("person/{id}")
	public void delete(@PathVariable("id") Long id) {
		personService.delete(id);
	}

	/**
	 * Find PERSON by ID;
	 * 
	 * @param personId
	 * @return
	 */
	@GetMapping({ "/person/{id}" })
	public Person findPersonById(@PathVariable("id") Long id) {
		return personService.findById(id);
	}

	/**
	 * Get all Persons
	 * 
	 */
	@GetMapping({ "/persons" })
	public List<Person> list() {
		return personService.listAllPersons();
	}

	/**
	 * Save person
	 * 
	 * @param person
	 * @return PERSON object updated with new ID
	 */
	@PostMapping({ "/person" })
	public Person savePerson(@RequestBody Person person) {
		return personService.save(person);
	}

	/**
	 * @param person from request body that will contain the new values
	 * @param id     of the person object that will be updated
	 * @return person object updated with original id and new values.
	 */
	@PutMapping({ "/person/{id}" })
	public Person updatePerson(@RequestBody Person person, @PathVariable long id) {
		return personService.update(id, person);
	}

}
