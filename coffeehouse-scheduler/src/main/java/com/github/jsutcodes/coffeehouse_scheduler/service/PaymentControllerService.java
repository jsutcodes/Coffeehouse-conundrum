package com.github.jsutcodes.coffeehouse_scheduler.service;

import java.util.List;

import com.github.jsutcodes.coffeehouse_scheduler.model.Person;
import com.github.jsutcodes.coffeehouse_scheduler.model.Schedule;


public interface PaymentControllerService {
	
	
	// used only for testing TDD purposes (this should become a spring obj )
	public record Tuple(String name, Number price) {};
	
	public Schedule getSchedule();
	/**
	 * @param list 
	 * @return list of rotation
	 */
	public Schedule	calculatePaymentRotation(List<Person> list);
	
//	default void printSchedule() {
//		
//		StringBuilder top = new StringBuilder();
//		StringBuilder mid = new StringBuilder();
//	    StringBuilder bot = new StringBuilder();
//		
//	    for (Person person : getSchedule().getPeople()) {
//            String s = person.getName();
//            int len = s.length();
//            
//            // Create the horizontal bar based on the string length plus padding
//            String line = "─".repeat(len + 2); 
//            
//            top.append("┌").append(line).append("┐");
//            mid.append("│ ").append(s).append(" │");
//            bot.append("└").append(line).append("┘");
//        }
//
//        System.out.println(top.toString());
//        System.out.println(mid.toString());
//        System.out.println(bot.toString());
//	} 

}
