package com.capstone.finance;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final List<Transaction> transactions = new CopyOnWriteArrayList<>();
    private final AtomicLong ids = new AtomicLong(100);

    public TransactionService() {
        transactions.add(new Income(ids.incrementAndGet(), new BigDecimal("25000.00"),
                LocalDate.now().withDayOfMonth(1), "Salary", "Monthly salary"));
        transactions.add(new Expense(ids.incrementAndGet(), new BigDecimal("300.00"),
                LocalDate.now(), "Transportation", "Bus and rickshaw"));
        transactions.add(new Expense(ids.incrementAndGet(), new BigDecimal("200.00"),
                LocalDate.now(), "Food & Dining", "Lunch"));
    }

    public synchronized void add(String type, BigDecimal amount, LocalDate date, String category, String description) {
        long id = ids.incrementAndGet();
        if ("INCOME".equalsIgnoreCase(type)) {
            transactions.add(new Income(id, amount, date, category, description));
        } else {
            transactions.add(new Expense(id, amount, date, category, description));
        }
    }

    public List<Transaction> getAllTransactions() {
        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getDate).reversed()
                        .thenComparing(Transaction::getId).reversed())
                .collect(Collectors.toList());
    }

    public List<Transaction> getTransactionsForDate(LocalDate date) {
        return getAllTransactions().stream().filter(t -> t.getDate().equals(date)).toList();
    }

    public List<Transaction> getTransactionsForMonth(YearMonth month) {
        return getAllTransactions().stream().filter(t -> YearMonth.from(t.getDate()).equals(month)).toList();
    }

    public BigDecimal totalForMonth(YearMonth month, String type) {
        return getTransactionsForMonth(month).stream()
                .filter(t -> t.getType().equals(type))
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal totalAll(String type) {
        return getAllTransactions().stream().filter(t -> t.getType().equals(type))
                .map(Transaction::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
