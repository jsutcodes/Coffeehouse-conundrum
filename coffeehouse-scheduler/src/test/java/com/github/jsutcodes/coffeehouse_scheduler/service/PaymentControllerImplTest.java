package com.github.jsutcodes.coffeehouse_scheduler.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.jsutcodes.coffeehouse_scheduler.entity.Person;
import com.github.jsutcodes.coffeehouse_scheduler.entity.Round;
import com.github.jsutcodes.coffeehouse_scheduler.entity.Schedule;

class PaymentControllerImplTest {

	private PaymentService pcs;
	private List<Person> recipt;

	@BeforeEach
	void setUp() {
		pcs = new PaymentServiceImpl();
		recipt = new LinkedList<>();
	}

	@Test
	void givenWholeNum_whenSchedule_thenNoDebtRemains() {

		List<Person> input = generateReciptByPerson(Map.of("A", 1, "B", 3, "C", 6));
		
		//System.out.println(Schedule.predictCycleLength(input));
		
		Schedule result = pcs.calculatePaymentRotation(input);

		Schedule expectedResult = setExpectedSchedule(input,
				Arrays.asList("C", "B", "C", "B", "C", "B", "C", "A", "C", "C"));

		assertScheduleEqual(expectedResult, result);
	}

	@Test
	void givenIrrationalDecNum_whenSchedule_thenForceBreakEven() {
		
		List<Person> input = generateReciptByPerson(Map.of("A", 3.33, "B", 4.67, "C", 2));
		
		Schedule result = pcs.calculatePaymentRotation(input);

		Schedule expectedResult = setExpectedSchedule(input,
				Arrays.asList("B", "A", "C", "B", "A", "B", "C", "B", "A", "B","A","B","C","A", "B"));

		assertScheduleEqual(expectedResult, result);
	}
	
	@Test
	void givenIrrationalNum_whenSchedule_thenForceBreakEven() {
		
		//Test case where there are no decimals x100 
		List<Person> input = generateReciptByPerson(Map.of("A", 333, "B", 467, "C", 200));
		Schedule result = pcs.calculatePaymentRotation(input);

		Schedule expectedResult = setExpectedSchedule(input,
				Arrays.asList("B", "A", "C", "B", "A", "B", "C", "B", "A", "B","A","B","C","A", "B"));

		assertScheduleEqual(expectedResult, result);
	}

	// Helpers --------------------------------------------------------------
	private List<Person> generateReciptByPerson(Map<String, Number> map) {
	
		map.forEach((name, price) -> {
			Person p = new Person();
			p.addOrderItem(name, price);
			recipt.add(p);
		});

		return recipt;
	}

	private Schedule setExpectedSchedule(List<Person> input, List<String> list) {
		Schedule expectedSchedule = new Schedule();
		
		expectedSchedule.setMaxNumOfRounds(list.size());
		list.forEach(name -> {
			Round r = new Round();
			r.setPayerName(name);

			expectedSchedule.getRounds().add(r);
		});
		
		return expectedSchedule;

	}

	private void assertScheduleEqual(Schedule expected, Schedule actual) {
		List<Round> expectedPeople = null;
		List<Round> actualPeople = null;
		try {
			expectedPeople = expected.getRounds();
			actualPeople = actual.getRounds();

			expectedPeople.sort((p1,p2)-> p1.getPayerName().compareTo(p2.getPayerName()));
			//actualPeople.sort((p1,p2)-> p1.getRoundNumber().compareTo(p2.getRoundNumber()));

			assertEquals(expectedPeople, expectedPeople);

		} catch (AssertionError | NullPointerException e) {
			System.err.print(String.format(
					"assertScheduleEqual failure: expected did not equal actual:\n\t expected:\n%s\n\t actual:\n%s\n",
					(expected != null) ? expected : "null", (actual != null) ? actual : "null"));
			fail();
		}
	}

}
