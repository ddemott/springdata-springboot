package com.demott.trackmyjob.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demott.trackmyjob.entities.Person;
import com.demott.trackmyjob.entities.PhoneNumber;
import com.demott.trackmyjob.exceptions.NotFoundException;
import com.demott.trackmyjob.repositories.PersonRepository;
import com.demott.trackmyjob.repositories.PhoneNumberRepository;

@Repository
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	PhoneNumberRepository phoneNumberRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demott.trackmyjob.services.PersonService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		Optional<Person> Person = personRepository.findById(id);
		if (!Person.isPresent()) {
			throw new NotFoundException("delete method did not find Person object with id of " + id);
		} else {
			personRepository.delete(Person.get());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.demott.trackmyjob.services.PersonService#delete(com.demott.trackmyjob.
	 * entities.Person)
	 */
	@Override
	public void delete(Person person) {
		personRepository.delete(person);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demott.trackmyjob.services.PersonService#findById(java.lang.Long)
	 */
	@Override
	public Person findById(Long id) throws NotFoundException {
		Optional<Person> Person = personRepository.findById(id);
		if (!Person.isPresent()) {
			throw new NotFoundException("findById method did not find PersonObject with id of " + id);
		} else {
			return Person.get();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demott.trackmyjob.services.PersonService#listAllPersons()
	 */
	@Override
	public List<Person> listAllPersons() {
		List<Person> personList = personRepository.findAll();
		if (null == personList || personList.size() == 0) {
			return new ArrayList<Person>(0);
		} else {
			return personList;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demott.trackmyjob.services.PersonService#save(com.demott.trackmyjob.
	 * entities.Person)
	 */
	@Override
	public Person save(Person person) {
		Person savedPersonWithId = personRepository.save(person);
		return savedPersonWithId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demott.trackmyjob.services.PersonService#update(java.lang.Long,
	 * com.demott.trackmyjob.entities.Person)
	 */
	@Override
	public Person update(Long personIdToUpdateId, Person newPersonWithNewValues) throws NotFoundException {
		Optional<Person> personToUpdateOptional = personRepository.findById(personIdToUpdateId);
		Person personToUpdate;
		if (!personToUpdateOptional.isPresent()) {
			throw new NotFoundException("update method did not find Person object with id of " + personIdToUpdateId);
		} else {
			personToUpdate = personToUpdateOptional.get();
		}
		personToUpdate.setPersonFirstName(newPersonWithNewValues.getPersonFirstName());
		personToUpdate.setPersonLastName(newPersonWithNewValues.getPersonLastName());
		personToUpdate.setPhoneNumbers(newPersonWithNewValues.getPhoneNumbers());
		personToUpdate = personRepository.save(personToUpdate);
		if (null == newPersonWithNewValues.getPhoneNumbers() || newPersonWithNewValues.getPhoneNumbers().size() == 0) {
			personToUpdate.setPhoneNumbers(new ArrayList<PhoneNumber>(0));
			personRepository.save(personToUpdate);
			return personToUpdate;
		} else {
			List<PhoneNumber> phoneNumberList = newPersonWithNewValues.getPhoneNumbers();
			for (int i = 0; i < phoneNumberList.size(); i++) {
				PhoneNumber newPhone = phoneNumberList.get(i);
				newPhone.setPersonId(personToUpdate.getPersonId());
				phoneNumberRepository.save(newPhone);
			}
		}
		return personToUpdate;
	}
}