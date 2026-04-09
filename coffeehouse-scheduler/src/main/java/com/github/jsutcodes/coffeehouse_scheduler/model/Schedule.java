package com.github.jsutcodes.coffeehouse_scheduler.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Schedule {
	
	private Long id;
	private List<Person> people; 

}
