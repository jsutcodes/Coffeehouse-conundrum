package com.github.jsutcodes.coffeehouse_scheduler.service;

import java.util.List;

import com.github.jsutcodes.coffeehouse_scheduler.entity.Person;
import com.github.jsutcodes.coffeehouse_scheduler.entity.Schedule;


public interface PaymentService {
	

	public Schedule getSchedule();
	/**
	 * @param list 
	 * @return list of rotation
	 */
	public Schedule	calculatePaymentRotation(List<Person> list);
	
}
