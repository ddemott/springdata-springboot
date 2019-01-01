package com.demott.trackmyjob.services;

import java.util.List;

import com.demott.trackmyjob.entities.PhoneNumber;
import com.demott.trackmyjob.exceptions.NotFoundException;

public interface PhoneNumberService {

	void delete(Long id) throws NotFoundException;

	void delete(PhoneNumber phoneNumber);

	PhoneNumber findById(Long id) throws NotFoundException;

	List<PhoneNumber> listAllPhoneNumbers();

	PhoneNumber save(PhoneNumber phoneNumber);

	PhoneNumber update(Long phoneNumberIdToUpdate, PhoneNumber newPhoneNumberWithNewValues) throws NotFoundException;

}