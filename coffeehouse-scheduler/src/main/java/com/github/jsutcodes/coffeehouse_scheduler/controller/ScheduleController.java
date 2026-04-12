package com.github.jsutcodes.coffeehouse_scheduler.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jsutcodes.coffeehouse_scheduler.entity.Person;
import com.github.jsutcodes.coffeehouse_scheduler.entity.Schedule;
import com.github.jsutcodes.coffeehouse_scheduler.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class ScheduleController {

	private final PaymentService paymentService;
	
	  @PostMapping
	public ResponseEntity<Schedule> calculate(@RequestBody List<Person> participants) {

		var response = paymentService.calculatePaymentRotation(participants);
		return ResponseEntity.ok(response);
	}
}
