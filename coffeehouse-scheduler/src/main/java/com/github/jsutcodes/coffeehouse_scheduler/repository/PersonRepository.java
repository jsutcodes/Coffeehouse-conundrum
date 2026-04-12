package com.github.jsutcodes.coffeehouse_scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jsutcodes.coffeehouse_scheduler.entity.Person;

public interface PersonRepository  extends JpaRepository<Person, Long> {

}
