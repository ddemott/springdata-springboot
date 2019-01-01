package com.demott.trackmyjob.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demott.trackmyjob.entities.PhoneNumber;
import com.demott.trackmyjob.exceptions.NotFoundException;
import com.demott.trackmyjob.repositories.PhoneNumberRepository;

@Repository
public class PhoneNumberServiceImpl implements PhoneNumberService {

	@Autowired
	private PhoneNumberRepository phoneNumberRepository;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.demott.trackmyjob.services.PhoneNumberService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) throws NotFoundException {
		Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(id);
		if (!phoneNumber.isPresent()) {
			throw new NotFoundException("delete method did not find PhoneNumberObject with id of " + id);
		} else {
			phoneNumberRepository.delete(phoneNumber.get());
		}
	}

	@Override
	public void delete(PhoneNumber phoneNumber) {
		delete(phoneNumber.getPhoneNumberId());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.demott.trackmyjob.services.PhoneNumberService#findById(java.lang.Long)
	 */
	@Override
	public PhoneNumber findById(Long id) throws NotFoundException {
		Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(id);
		if (!phoneNumber.isPresent()) {
			throw new NotFoundException("findById method did not find PhoneNumberObject with id of " + id);
		} else {
			return phoneNumber.get();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.demott.trackmyjob.services.PhoneNumberService#listAllPhoneNumbers()
	 */
	@Override
	public List<PhoneNumber> listAllPhoneNumbers() {
		List<PhoneNumber> phoneNumberList = (List<PhoneNumber>) phoneNumberRepository.findAll();
		if (null == phoneNumberList || phoneNumberList.size() == 0) {
			return new ArrayList<PhoneNumber>(0);
		} else {
			return phoneNumberList;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.demott.trackmyjob.services.PhoneNumberService#save(com.demott.trackmyjob.
	 * entities.PhoneNumber)
	 */
	@Override
	public PhoneNumber save(PhoneNumber phoneNumber) {
		return phoneNumberRepository.save(phoneNumber);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.demott.trackmyjob.services.PhoneNumberService#update(java.lang.Long,
	 * com.demott.trackmyjob.entities.PhoneNumber)
	 */
	@Override
	public PhoneNumber update(Long phoneNumberIdToUpdate, PhoneNumber newPhoneNumberWithNewValues)
			throws NotFoundException {
		Optional<PhoneNumber> phoneNumberOptional = phoneNumberRepository.findById(phoneNumberIdToUpdate);
		if (!phoneNumberOptional.isPresent()) {
			throw new NotFoundException(
					"update method did not find PhoneNumberObject with id of " + phoneNumberIdToUpdate);
		} else {
			PhoneNumber phoneNumberToUpdate = phoneNumberOptional.get();
			phoneNumberToUpdate.setPhoneNumber(newPhoneNumberWithNewValues.getPhoneNumber());
			phoneNumberToUpdate.setPhoneNumberDescription(newPhoneNumberWithNewValues.getPhoneNumberDescription());
			phoneNumberToUpdate.setPersonId(newPhoneNumberWithNewValues.getPersonId());
			phoneNumberRepository.save(phoneNumberToUpdate);

			return phoneNumberToUpdate;
		}

	}

}
