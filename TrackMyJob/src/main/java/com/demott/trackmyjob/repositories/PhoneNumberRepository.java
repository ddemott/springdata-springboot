package com.demott.trackmyjob.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demott.trackmyjob.entities.PhoneNumber;

@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long> {

}
