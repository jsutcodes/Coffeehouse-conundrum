package com.github.jsutcodes.coffeehouse_scheduler.model;

import java.math.BigDecimal;

/**
 * Data Model class for Menu Item:
 * - TODO: Ensure price math is correct, avoid rounding errors. 
 */
public class Menu {
	
	private Long id;
	private String name;
	private String size; 
	private BigDecimal price;

}
