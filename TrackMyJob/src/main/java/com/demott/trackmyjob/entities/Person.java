package com.demott.trackmyjob.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Entity
@Data
public class Person {

	private String personFirstName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long personId;
	private String personLastName;

	@Fetch(FetchMode.JOIN)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "personId")
	private List<PhoneNumber> phoneNumbers;

	public Person(Long personId, String personFirstName, String personLastName, List<PhoneNumber> phoneNumbers) {
		super();
		this.personId = personId;
		this.personFirstName = personFirstName;
		this.personLastName = personLastName;
		this.phoneNumbers = phoneNumbers;
	}

}
