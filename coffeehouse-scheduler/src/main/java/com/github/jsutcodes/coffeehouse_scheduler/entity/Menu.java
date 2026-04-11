package com.github.jsutcodes.coffeehouse_scheduler.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Model class for Menu Item:
 * - TODO: Ensure price math is correct, avoid rounding errors. 
 */
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Menu extends BaseEntity{
	
	private String name;
	private String size; 
	private BigDecimal price;

}
