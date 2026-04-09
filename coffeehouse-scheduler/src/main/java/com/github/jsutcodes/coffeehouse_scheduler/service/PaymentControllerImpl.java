package com.github.jsutcodes.coffeehouse_scheduler.service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.jsutcodes.coffeehouse_scheduler.model.Menu;
import com.github.jsutcodes.coffeehouse_scheduler.model.Person;
import com.github.jsutcodes.coffeehouse_scheduler.model.Schedule;

public class PaymentControllerImpl implements PaymentControllerService {

	private Schedule schedule = new Schedule();
	private Map<String, BigDecimal> debtBalances = new HashMap<>();
	
	@Override
	public Schedule calculatePaymentRotation(List<Person> list) {
		               
		BigDecimal totalBill = calculateSumOfTotalBill(list);
		 Map<String, BigDecimal> shares = calculateSharedPercentageByPerson(list);
		return generateSchedule(list, totalBill, shares);
	}

	@Override
	public Schedule getSchedule() {
		return schedule;
	}


	private BigDecimal calculateSumOfTotalBill(List<Person> list) {
	    return list.stream()
	               .flatMap(p -> p.getItems().stream())
	               .map(Menu::getPrice)
	               .reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	private Map<String, BigDecimal> calculateSharedPercentageByPerson(List<Person> list) {
	    Map<String, BigDecimal> shares = new HashMap<>();

	    for (Person p : list) {
	        // Sum up the price of every item in that person's list
	        BigDecimal personTotal = p.getItems().stream()
	                .map(Menu::getPrice) // Assuming Item has getPrice() returning BigDecimal
	                .reduce(BigDecimal.ZERO, BigDecimal::add);
	        
	        shares.put(p.getName(), personTotal);
	    }
	    return shares;
	}
	
	private Schedule generateSchedule(List<Person> list, BigDecimal totalBill,  Map<String, BigDecimal> shares) {
	    
		for(int i = 0; i < 10; i++) {
		System.out.println("Round " + (i+1));
		schedule.getPeople().add(getNextPayer(list, totalBill));
	   // schedule.setGrandTotal(totalBill);
		System.out.println("");
		}
	    
	    return schedule;
	}
	
	private Person getNextPayer(List<Person> list, BigDecimal totalBill) {
		 Map<String, BigDecimal> currentBillShares = calculateSharedPercentageByPerson(list);

		    // 1. Update everyone's balance with their share of the current bill
		    for (Person p : list) {
		        BigDecimal shareAmount = currentBillShares.getOrDefault(p.getName(), BigDecimal.ZERO);
		        BigDecimal currentDebt = debtBalances.getOrDefault(p.getName(), BigDecimal.ZERO);
		        debtBalances.put(p.getName(), currentDebt.add(shareAmount));
		        
		        System.out.println(String.format("Person %s: Debt: %.2f", p.getName(), currentDebt));
		    }

		    // 2. Find the person with the highest debt (the most "overdue" to pay)
		    Person nextPayer = list.stream()
		            .max(Comparator.comparing(p -> debtBalances.getOrDefault(p.getName(), BigDecimal.ZERO)))
		            .orElseThrow();
		    
		    System.out.println("Next payer is: " + nextPayer.getName());

		    // 3. Deduct the total bill from the payer's balance (they have now "paid up")
		    BigDecimal payerBalance = debtBalances.get(nextPayer.getName());
		    debtBalances.put(nextPayer.getName(), payerBalance.subtract(totalBill));

		    return nextPayer;
		}
		

}
