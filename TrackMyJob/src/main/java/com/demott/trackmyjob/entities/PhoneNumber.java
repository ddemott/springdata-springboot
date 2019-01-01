package com.demott.trackmyjob.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PhoneNumber {

	public static PhoneNumber createEmptyPhoneNumber() {
		return new PhoneNumber("", "");
	}

	private Long personId;
	private String phoneNumber;
	private String phoneNumberDescription;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long phoneNumberId;

	public PhoneNumber(String phoneNumberDescription, String phoneNumber) {
		super();
		this.phoneNumberDescription = phoneNumberDescription;
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumber(String phoneNumberDescription, String phoneNumber, Long personId) {
		super();
		this.phoneNumberDescription = phoneNumberDescription;
		this.phoneNumber = phoneNumber;
		this.setPersonId(personId);
	}

}
