package com.capstone.finance;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class WalletService {
    public BigDecimal calculateBalance(BigDecimal openingBalance, BigDecimal income, BigDecimal expenses) {
        return openingBalance.add(income).subtract(expenses);
    }
}
