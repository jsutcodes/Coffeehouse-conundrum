package com.github.jsutcodes.coffeehouse_scheduler.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Person {
		
		private Long id;
		private String name;
		private List<Menu> items; 
		
		private Map<Person, Double> debtMap = new HashMap<>();

}
