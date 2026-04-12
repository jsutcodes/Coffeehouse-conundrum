package com.github.jsutcodes.coffeehouse_scheduler.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class DebtEntry extends BaseEntity {
    private String personName; // Store name to avoid complex joins if a person is deleted
    private BigDecimal balance; // Positive = credit, Negative = debt
}