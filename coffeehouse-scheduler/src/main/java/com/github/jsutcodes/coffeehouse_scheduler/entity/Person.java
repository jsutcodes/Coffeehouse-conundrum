package com.github.jsutcodes.coffeehouse_scheduler.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person extends BaseEntity {

	private Long id;
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "person_items", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "menu_id"))
	private List<Menu> items = new ArrayList<>();

	// private Map<String, BigDecimal> debtMap = new HashMap<>();

	public Person(String name, Number price) {
		this.name = name;

		Menu item = Menu.builder().name("MenuItem ordered by" + name).price(BigDecimal.valueOf(price.doubleValue()))
				.size("SM").build();

		items.add(item);
	}

}
