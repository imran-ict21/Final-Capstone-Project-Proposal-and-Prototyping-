package com.capstone.finance;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.YearMonth;

@Service
public class DashboardService {
    private final TransactionService transactionService;
    private final WalletService walletService;

    public DashboardService(TransactionService transactionService, WalletService walletService) {
        this.transactionService = transactionService;
        this.walletService = walletService;
    }

    public BigDecimal monthlyIncome(YearMonth month) {
        return transactionService.totalForMonth(month, "INCOME");
    }
    public BigDecimal monthlyExpenses(YearMonth month) {
        return transactionService.totalForMonth(month, "EXPENSE");
    }
    public BigDecimal monthlyNet(YearMonth month) {
        return monthlyIncome(month).subtract(monthlyExpenses(month));
    }
    public BigDecimal currentBalance() {
        return walletService.calculateBalance(BigDecimal.ZERO,
                transactionService.totalAll("INCOME"), transactionService.totalAll("EXPENSE"));
    }
}
