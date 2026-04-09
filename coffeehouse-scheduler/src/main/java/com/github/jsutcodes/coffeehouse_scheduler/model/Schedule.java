package com.github.jsutcodes.coffeehouse_scheduler.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Schedule {
	
	private Long id;
	private List<Person> people; 
	
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
