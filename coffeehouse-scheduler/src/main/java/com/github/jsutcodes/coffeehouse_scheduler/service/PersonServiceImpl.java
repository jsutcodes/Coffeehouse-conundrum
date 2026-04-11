package com.github.jsutcodes.coffeehouse_scheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.jsutcodes.coffeehouse_scheduler.entity.Person;
import com.github.jsutcodes.coffeehouse_scheduler.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepo;
	
	@Override
	public List<Person> getAllPeople() {
		return personRepo.findAll();
	}

	@Override
	public Optional<Person> getPersonItemById(Long id) {
		return personRepo.findById(id);
	}

	@Override
	public Person savePerson(Person person) {
		return personRepo.save(person);
	}

	@Override
	public void deletePerson(Long id) {
		personRepo.deleteById(id);
		
	}

}
