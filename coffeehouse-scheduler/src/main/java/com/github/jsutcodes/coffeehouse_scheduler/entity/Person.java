package com.github.jsutcodes.coffeehouse_scheduler.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "person_items", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "menu_id"))
	private List<Menu> items = new ArrayList<>();

	
    public void addOrderItem(String itemName, Number price) {
        if (price == null) return;
        
        Menu item = Menu.builder()
                .name(itemName)
                .price(BigDecimal.valueOf(price.doubleValue()))
                .size("SM")
                .build();
        
        this.items.add(item);
    }

}
