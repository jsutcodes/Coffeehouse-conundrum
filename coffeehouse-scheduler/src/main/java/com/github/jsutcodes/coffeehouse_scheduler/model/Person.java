package com.github.jsutcodes.coffeehouse_scheduler.model;

import java.math.BigDecimal;
import java.util.ArrayList;
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
	private List<Menu> items = new ArrayList<>(); 
	
	private Map<String, BigDecimal> debtMap = new HashMap<>();
		
	public Person(String name, Number price) {
		this.name = name;
		
		Menu item = Menu.builder()
				.name("MenuItem ordered by" + name)
				.price(BigDecimal.valueOf(price.doubleValue()))
				.size("SM").build();
		
		items.add(item);
	}



}
