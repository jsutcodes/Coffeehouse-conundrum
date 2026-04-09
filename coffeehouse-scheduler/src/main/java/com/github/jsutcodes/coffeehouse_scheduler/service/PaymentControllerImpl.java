package com.github.jsutcodes.coffeehouse_scheduler.service;

import java.util.List;

import com.github.jsutcodes.coffeehouse_scheduler.model.Person;
import com.github.jsutcodes.coffeehouse_scheduler.model.Schedule;

public class PaymentControllerImpl implements PaymentControllerService {

	private Schedule schedule = new Schedule();
	@Override
	public Schedule calculatePaymentRotation(List<Person> list) {
		               
//		int totalBillSum = list.stream()
//				.map(tuple -> tuple.price())
//				.filter(Number.class::isInstance)
//				.map(Number.class::cast)
//				.mapToInt(Number::intValue)
//				.sum();
		//calculate shared % for each person
		//generate scedule object and return
		
		return null;
	}

	@Override
	public Schedule getSchedule() {
		return schedule;
	}

}
