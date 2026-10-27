package com.capstone.finance;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class CalendarService {
    private final TransactionService transactionService;
    public CalendarService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    public List<Transaction> transactionsOn(LocalDate date) {
        return transactionService.getTransactionsForDate(date);
    }
    public List<Transaction> transactionsIn(YearMonth month) {
        return transactionService.getTransactionsForMonth(month);
    }
}
