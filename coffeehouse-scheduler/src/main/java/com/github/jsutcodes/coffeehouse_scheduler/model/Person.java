package com.github.jsutcodes.coffeehouse_scheduler.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Person {
		
	public Person(String name, Number price) {
		this.name = name;
		items.add(new Menu());
	}

		private Long id;
		private String name;
		private List<Menu> items = new ArrayList<>(); 
		
		private Map<Person, Double> debtMap = new HashMap<>();

}
