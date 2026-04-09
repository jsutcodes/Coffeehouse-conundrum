package com.github.jsutcodes.coffeehouse_scheduler.service;

import java.util.LinkedList;
import java.util.List;

public class PaymentControllerImpl implements PaymentControllerService {

	private List<Tuple> schedule = new LinkedList<Tuple>();
	@Override
	public List<String> calculatePaymentRotation(List<Tuple> list) {
		               
		int totalBillSum = list.stream()
				.map(tuple -> tuple.price())
				.filter(Number.class::isInstance)
				.map(Number.class::cast)
				.mapToInt(Number::intValue)
				.sum();
		//calculate shared % for each person
		//generate scedule object and return
		
		return null;
	}

	@Override
	public List<Tuple> getSchedule() {
		return schedule;
	}

}
