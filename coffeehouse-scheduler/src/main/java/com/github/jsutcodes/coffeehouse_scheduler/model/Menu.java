package com.github.jsutcodes.coffeehouse_scheduler.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Model class for Menu Item:
 * - TODO: Ensure price math is correct, avoid rounding errors. 
 */
@Getter @Setter @AllArgsConstructor @Builder
public class Menu {
	
	private Long id;
	private String name;
	private String size; 
	private BigDecimal price;

}
