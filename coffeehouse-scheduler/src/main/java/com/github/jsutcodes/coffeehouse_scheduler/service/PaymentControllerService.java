package com.github.jsutcodes.coffeehouse_scheduler.service;

import java.util.List;

public interface PaymentControllerService {
	/**
	 * @return list of rotation
	 */
	public List<String>	calculatePaymentRotation();

}
