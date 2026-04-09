package com.github.jsutcodes.coffeehouse_scheduler.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.jsutcodes.coffeehouse_scheduler.model.Person;
import com.github.jsutcodes.coffeehouse_scheduler.model.Schedule;
import com.github.jsutcodes.coffeehouse_scheduler.service.PaymentControllerService.Tuple;


class PaymentControllerImplTest {
	
	private PaymentControllerService pcs;
	private List<Person> recipt;
	
	@BeforeEach
	void setUp() {
		pcs = new PaymentControllerImpl();
		recipt = new LinkedList<>();
	}

	@Test
	void givenWholeNum_whenSchedule_thenNoDebtRemains() {
		
		List<Person> input = generateReciptByPerson(Map.of("A", 1, "B", 3, "C", 6));
		Schedule result =  pcs.calculatePaymentRotation(input);
		
		Schedule expectedResult = setExpectedSchedule(input, Arrays.asList("C", "B", "C", "B", "C", "B", "C", "A", "C", "C"));
//		result.printSchedule();
//		expectedResult. printSchedule();
		assertScheduleEqual(expectedResult,result);
	}
	
	
	
	
	
	
	// Helpers --------------------------------------------------------------
	private List<Person> generateReciptByPerson(Map<String, Number> map)
	{
		map.forEach((name,price) -> {
			recipt.add(new Person(name,price));		
		});
	
	return recipt;
	}
	
	private Schedule setExpectedSchedule(List<Person> input, List<String> list) {
		Schedule expectedSchedule = new Schedule();
		
		List<Person> expectedPeople = new ArrayList<>();
		
		list.forEach(name -> {
		
		Person p = input.stream()
		.filter(person -> name.equals(person.getName()))
		.findAny()
		.orElse(null);
		
		expectedPeople.add(p);
		});
		expectedSchedule.setPeople(expectedPeople);
		return expectedSchedule;

	}
	
	private void assertScheduleEqual(Schedule expected,Schedule actual ) {
		List<Person> expectedPeople = null;
		List<Person> actualPeople = null;
		try {
			expectedPeople = expected.getPeople();
			actualPeople = actual.getPeople();
			
			expectedPeople.sort(null);
			actualPeople.sort(null);
			
			assertEquals(expected.getPeople(), actual.getPeople());
			
		} catch (AssertionError | NullPointerException e) {
			System.err.print(String.format("assertScheduleEqual failure: expected did not equal actual:\n\t expected:\n%s\n\t actual:\n%s\n",
					(expected!= null)? expected:"null",
					(actual!= null)? actual:"null" ));
			fail();
		}
	}

}
