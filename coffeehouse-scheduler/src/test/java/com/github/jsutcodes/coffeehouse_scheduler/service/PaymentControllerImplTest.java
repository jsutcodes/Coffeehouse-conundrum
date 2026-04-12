package com.github.jsutcodes.coffeehouse_scheduler.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.jsutcodes.coffeehouse_scheduler.entity.Menu;
import com.github.jsutcodes.coffeehouse_scheduler.entity.Person;
import com.github.jsutcodes.coffeehouse_scheduler.entity.Round;
import com.github.jsutcodes.coffeehouse_scheduler.entity.Schedule;

class PaymentControllerImplTest {

    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        paymentService = new PaymentServiceImpl();
    }

    @Test
    void givenWholeNumbers_whenCalculated_thenFollowsCorrectPayerSequence() {
        List<Person> input = generateInput(Map.of("A", 1.0, "B", 3.0, "C", 6.0));
        Schedule result = paymentService.calculatePaymentRotation(input);

        // The sequence based on your "Highest Debt" logic
        List<String> expectedPayers = Arrays.asList("C", "B", "C", "C", "B", "C", "A", "C", "B", "C");

        assertPayerSequence(expectedPayers, result);
    }


    @Test
    void givenDecimals_whenCalculated_thenHandlesRoundingPatterns() {
        List<Person> input = generateInput(Map.of(
            "A", 3.33, 
            "B", 4.67, 
            "C", 2.0
        ));
        
        Schedule result = paymentService.calculatePaymentRotation(input);

        List<String> expectedPayers = Arrays.asList("B", "A", "C", "B", "A", "B", "C", "B", "A", "B", "A", "B", "C", "A", "B");

        assertPayerSequence(expectedPayers, result);
    }

    @Test
    void givenScaledNumbers_whenCalculated_thenProducesSameSequenceAsDecimals() {
        // Multiplying the previous test case by 100 to ensure integer logic holds
        List<Person> input = generateInput(Map.of(
            "A", 333.0, 
            "B", 467.0, 
            "C", 200.0
        ));
        
        Schedule result = paymentService.calculatePaymentRotation(input);

        List<String> expectedPayers = Arrays.asList("B", "A", "C", "B", "A", "B", "C", "B", "A", "B", "A", "B", "C", "A", "B");

        assertPayerSequence(expectedPayers, result);
    }

    // Helpers --------------------------------------------------------------

    /**
     * Helper to create Person objects with Menu items based on a price map.
     */
    private List<Person> generateInput(Map<String, Double> map) {
        List<Person> people = new ArrayList<>();
        map.forEach((name, price) -> {
            Person p = new Person();
            p.setName(name);
            
            Menu item = new Menu();
            item.setName("Coffee");
            item.setPrice(BigDecimal.valueOf(price));
            
            p.setItems(new ArrayList<>(List.of(item)));
            people.add(p);
        });

        // FIX: Sort by name so tie-breakers are deterministic
        people.sort(Comparator.comparing(Person::getName));
        return people;
    }


    /**
     * Compares the generated payer names in order against an expected list.
     */
    private void assertPayerSequence(List<String> expectedNames, Schedule actualSchedule) {
        List<String> actualNames = actualSchedule.getRounds().stream()
                .map(Round::getPayerName)
                .collect(Collectors.toList());

        // Check if we got fewer rounds than we expected to test
        if (actualNames.size() < expectedNames.size()) {
            org.junit.jupiter.api.Assertions.fail("Schedule was too short. Expected at least " + 
                 expectedNames.size() + " rounds but got " + actualNames.size());
        }
        
        // Only compare the start of the list
        for (int i = 0; i < expectedNames.size(); i++) {
            assertEquals(expectedNames.get(i), actualNames.get(i), "Mismatch at Round " + (i + 1));
        }
    }


}
