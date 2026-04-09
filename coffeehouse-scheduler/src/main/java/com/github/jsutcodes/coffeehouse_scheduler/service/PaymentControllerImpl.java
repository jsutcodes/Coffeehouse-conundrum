package com.github.jsutcodes.coffeehouse_scheduler.service;

import java.util.LinkedList;
import java.util.List;

public class PaymentControllerImpl implements PaymentControllerService {

	private List<Tuple> schedule = new LinkedList<Tuple>();
	@Override
	public List<String> calculatePaymentRotation(List<Tuple> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tuple> getSchedule() {
		return schedule;
	}

}
