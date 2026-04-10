package com.github.jsutcodes.coffeehouse_scheduler.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Schedule {
	
	private Long id;
	private List<Person> people = new LinkedList<>();
	//private List< Map<String, BigDecimal>> debtBalancesPerRound = new LinkedList<Map<String,BigDecimal>>();
	private int currentPayerIndex = 0;
	private int maxNumOfRounds = 0;
	
	
	
	public static long predictCycleLength(List<Person> list) {
	    // 1. Get costs as long (cents) to avoid decimal issues
	    List<Long> costs = list.stream()
	            .map(p -> p.getItems().stream()
	                    .map(Menu::getPrice)
	                    .reduce(BigDecimal.ZERO, BigDecimal::add)
	                    .movePointRight(2).longValue()) // $1.00 -> 100
	            .collect(Collectors.toList());

	    // 2. Find GCD of all costs
	    long commonDivisor = costs.get(0);
	    for (int i = 1; i < costs.size(); i++) {
	        commonDivisor = gcd(commonDivisor, costs.get(i));
	    }

	    // 3. The cycle length is the Sum / GCD
	    long totalCents = costs.stream().mapToLong(Long::longValue).sum();
	    return totalCents / commonDivisor;
	}

	private static long gcd(long a, long b) {
	    return b == 0 ? a : gcd(b, a % b);
	}
	
	@Override
	public String toString() {
	
	StringBuilder top = new StringBuilder();
	StringBuilder mid = new StringBuilder();
    StringBuilder bot = new StringBuilder();
	
    for (Person person : people) {
        String s = person.getName();
        int len = s.length();
        
        // Create the horizontal bar based on the string length plus padding
        String line = "─".repeat(len + 2); 
        
        top.append("┌").append(line).append("┐");
        mid.append("│ ").append(s).append(" │");
        bot.append("└").append(line).append("┘");
    }

//    System.out.println(top.toString());
//    System.out.println(mid.toString());
//    System.out.println(bot.toString());
    
    return top.append("\n").append(mid).append("\n").append(bot).append("\n").toString();
} 

}
