package com.github.jsutcodes.coffeehouse_scheduler.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.jsutcodes.coffeehouse_scheduler.service.PaymentControllerService.Tuple;


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
		
		var list = generateReciptByPerson(Map.of("A", 1, "B", 3, "C", 6));
		List<String> result =  pcs.calculatePaymentRotation(list);
		
		List<String> expectedResult = new LinkedList<>();
		assertScheduleEqual(expectedResult,result);
	}
	
	
	
	
	
	
	// Helpers --------------------------------------------------------------
	private List<Tuple> generateReciptByPerson(Map<String, Number> map)
	{
		map.forEach((k,v) -> {
			recipt.add(new Tuple(k, v));		
		});
	
	return recipt;
	}
	
	private void assertScheduleEqual(List<?> expected,List<?> actual ) {
		try {
			expected.sort(null);
			actual.sort(null);
			assertEquals(expected, actual);
		} catch (AssertionError | NullPointerException e) {
			System.err.print(String.format("assertScheduleEqual failure: expected did not equal actual:\n\t expected:\n\t %s\n\t actual:\n\t%s\n",expected,actual ));
			fail();
		}
	}

}
