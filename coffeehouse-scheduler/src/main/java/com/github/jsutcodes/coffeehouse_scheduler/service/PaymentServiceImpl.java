package com.github.jsutcodes.coffeehouse_scheduler.service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.jsutcodes.coffeehouse_scheduler.entity.DebtEntry;
import com.github.jsutcodes.coffeehouse_scheduler.entity.Menu;
import com.github.jsutcodes.coffeehouse_scheduler.entity.Person;
import com.github.jsutcodes.coffeehouse_scheduler.entity.Round;
import com.github.jsutcodes.coffeehouse_scheduler.entity.Schedule;

@Service
public class PaymentServiceImpl implements PaymentService {

	private Schedule schedule = new Schedule();
	private Map<String, BigDecimal> debtBalances = new HashMap<>();

	private final int MAX_ROUNDS = 90;

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
		return list.stream().flatMap(p -> p.getItems().stream()).map(Menu::getPrice).reduce(BigDecimal.ZERO,
				BigDecimal::add);
	}

	private Map<String, BigDecimal> calculateSharedPercentageByPerson(List<Person> list) {
		Map<String, BigDecimal> shares = new HashMap<>();

		for (Person p : list) {
			// Sum up the price of every item in that person's list
			BigDecimal personTotal = p.getItems().stream().map(Menu::getPrice) // Assuming Item has getPrice() returning
																				// BigDecimal
					.reduce(BigDecimal.ZERO, BigDecimal::add);

			shares.put(p.getName(), personTotal);
		}
		return shares;
	}

	private Schedule generateSchedule(List<Person> list, BigDecimal totalBill, Map<String, BigDecimal> shares) {
		
		schedule = new Schedule();
		Set<String> seenStates = new HashSet<>();
		 debtBalances = new HashMap<>();
		// Find the Schedules Max rounds to loop about
		schedule.setMaxNumOfRounds(Math.toIntExact(Schedule.predictCycleLength(list)));
		int maxRounds = Math.min(MAX_ROUNDS,schedule.getMaxNumOfRounds());

		for (int i = 0; i < maxRounds; i++) {
			Round currentRound = new Round();
			currentRound.setRoundNumber(i);
			System.out.println("Round " + (i + 1));
			
			Map<String, BigDecimal> previousDebtBalances = new HashMap<>(debtBalances);
			Person nextPayer = getNextPayer(list, totalBill, currentRound);

			String currentState = nextPayer.getName() + "|" + list.stream().map(p -> {
				// Round to 0 decimal places just for the comparison key
				long roundedDebt = Math.round(debtBalances.getOrDefault(p.getName(), BigDecimal.ZERO).doubleValue());
				return p.getName() + ":" + roundedDebt;
			}).collect(Collectors.joining("|"));

			if (seenStates.contains(currentState)) {
				System.out.println("Pattern repeated at Round" + i + ". Stopping.");
				debtBalances = previousDebtBalances;
				break;
			}

			//schedule.getPeople().add(nextPayer);
			schedule.getRounds().add(currentRound);
			//System.out.println(currentState);
			seenStates.add(currentState);
			System.out.println("");
		}

		System.out.println(schedule);
		printDebtBalances();

		return schedule;
	}

	private Person getNextPayer(List<Person> list, BigDecimal totalBill, Round round) {
		Map<String, BigDecimal> currentBillShares = calculateSharedPercentageByPerson(list);

		// 1. Update everyone's balance with their share of the current bill
		for (Person p : list) {
			DebtEntry debt = new DebtEntry();
			BigDecimal shareAmount = currentBillShares.getOrDefault(p.getName(), BigDecimal.ZERO);
			BigDecimal currentDebt = debtBalances.getOrDefault(p.getName(), BigDecimal.ZERO);
			
			debt.setPersonName(p.getName());
			debt.setBalance(currentDebt.add(shareAmount));
			
			round.getBalances().add(debt);
			debtBalances.put(p.getName(), currentDebt.add(shareAmount));
		}

		// 2. Find the person with the highest debt (the most "overdue" to pay)
		Person nextPayer = list.stream()
				.max(Comparator.comparing(p -> debtBalances.getOrDefault(p.getName(), BigDecimal.ZERO))).orElseThrow();

		System.out.println("Next payer is: " + nextPayer.getName());
		round.setPayerName(nextPayer.getName());
		
		// 3. Deduct the total bill from the payer's balance (they have now "paid up")
		BigDecimal payerBalance = debtBalances.get(nextPayer.getName());
		debtBalances.put(nextPayer.getName(), payerBalance.subtract(totalBill));
		
		round.getBalances().forEach(balance -> {
		    if (balance.getPersonName().equals(nextPayer.getName())) {
		        balance.setBalance(payerBalance.subtract(totalBill));
		    }
		});


		printDebtBalances();

		return nextPayer;
	}

	private void printDebtBalances() {
		debtBalances.forEach(
				(name, currentDebt) -> System.out.println(String.format("Person %s: Debt: %.2f", name, currentDebt)));
	}

}
