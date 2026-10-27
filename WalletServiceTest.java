package com.capstone.finance;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WalletServiceTest {
    @Test
    void calculatesBalanceFromOpeningBalanceIncomeAndExpenses() {
        WalletService service = new WalletService();
        assertEquals(new BigDecimal("1150.00"),
                service.calculateBalance(new BigDecimal("1000.00"),
                        new BigDecimal("500.00"), new BigDecimal("350.00")));
    }
}
