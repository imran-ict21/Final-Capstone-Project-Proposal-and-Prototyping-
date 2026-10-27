package com.capstone.finance;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Expense extends Transaction {
    public Expense(long id, BigDecimal amount, LocalDate date, String category, String description) {
        super(id, amount, date, category, description);
    }
    @Override public String getType() { return "EXPENSE"; }
}
