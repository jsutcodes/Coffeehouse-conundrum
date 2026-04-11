package com.github.jsutcodes.coffeehouse_scheduler.service;

import java.util.List;
import java.util.Optional;

import com.github.jsutcodes.coffeehouse_scheduler.entity.Person;

public interface PersonService {

	List<Person> getAllPeople();

	Optional<Person> getPersonItemById(Long id);

	Person savePerson(Person person);

	void deletePerson(Long id);

}
