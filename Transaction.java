package com.capstone.finance;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Transaction {
    private final long id;
    private final BigDecimal amount;
    private final LocalDate date;
    private final String category;
    private final String description;

    protected Transaction(long id, BigDecimal amount, LocalDate date, String category, String description) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        if (date == null) throw new IllegalArgumentException("Date is required.");
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.category = category == null || category.isBlank() ? "Other" : category.trim();
        this.description = description == null ? "" : description.trim();
    }

    public long getId() { return id; }
    public BigDecimal getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public abstract String getType();
}
