package com.github.jsutcodes.coffeehouse_scheduler.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Person extends BaseEntity{ 
	
	private Long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "store_id") // Creates a foreign key in the Menu table
	private List<Menu> items = new ArrayList<>(); 
	
	//private Map<String, BigDecimal> debtMap = new HashMap<>();
		
	public Person(String name, Number price) {
		this.name = name;
		
		Menu item = Menu.builder()
				.name("MenuItem ordered by" + name)
				.price(BigDecimal.valueOf(price.doubleValue()))
				.size("SM").build();
		
		items.add(item);
	}



}
