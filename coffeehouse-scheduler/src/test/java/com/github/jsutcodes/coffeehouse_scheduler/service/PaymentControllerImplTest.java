package com.github.jsutcodes.coffeehouse_scheduler.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PaymentControllerImplTest {
	
	private PaymentControllerService pcs;
	private List<Tuple> recipt;
	
	@BeforeEach
	void setUp() {
		pcs = new PaymentControllerImpl();
		recipt = new LinkedList<>();
	}

	@Test
	void givenWholeNum_whenSchedule_thenNoDebtRemains() {
		
		generateReciptByPerson(Map.of("A", 1, "B", 3, "C", 6));
		List<String> result =  pcs.calculatePaymentRotation();
		
		// add expected result
	}
	
	private List<Tuple> generateReciptByPerson(Map<String, Number> map)
	{
		map.forEach((k,v) -> {
			recipt.add(new Tuple(k, v));		
		});
	
	return recipt;
	}
	// used only for testing TDD purposes (this should become a spring obj )
	private record Tuple(String name, Number price) {};

}
