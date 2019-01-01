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

import com.demott.trackmyjob.entities.PhoneNumber;
import com.demott.trackmyjob.services.PhoneNumberService;

@RestController
public class PhoneNumberController {

	@Autowired
	private PhoneNumberService phoneNumberService;

	@DeleteMapping({ "phonenumber/{id}", "phoneNumber/{id}" })
	public void delete(@PathVariable Long id) {
		phoneNumberService.delete(id);
	}

	@GetMapping({ "/phonenumber/{id}", "/phoneNumber/{id}" })
	public PhoneNumber findPhoneNumberById(@PathVariable Long id) {
		return phoneNumberService.findById(id);
	}

	@GetMapping({ "/phoneNumbers", "phonenumbers" })
	public List<PhoneNumber> list() {
		return phoneNumberService.listAllPhoneNumbers();
	}

	@PostMapping({ "/phoneNumber", "/phonenumber" })
	public PhoneNumber savePhoneNumber(@RequestBody PhoneNumber phoneNumber) {
		return phoneNumberService.save(phoneNumber);
	}

	@PutMapping({ "/phoneNumber/{id}", "/phonenumber/{id}" })
	public PhoneNumber updatePhoneNumber(@RequestBody PhoneNumber phoneNumber, @PathVariable long id) {
		return phoneNumberService.update(id, phoneNumber);
	}
}
