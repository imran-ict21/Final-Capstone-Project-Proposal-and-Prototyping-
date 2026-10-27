package com.capstone.finance;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Controller
public class HomeController {
    private final TransactionService transactionService;
    private final DashboardService dashboardService;
    private final CalendarService calendarService;

    public HomeController(TransactionService transactionService, DashboardService dashboardService,
                          CalendarService calendarService) {
        this.transactionService = transactionService;
        this.dashboardService = dashboardService;
        this.calendarService = calendarService;
    }

    @GetMapping("/")
    public String showDashboard(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) String month,
            Model model) {
        LocalDate selectedDate = date == null ? LocalDate.now() : date;
        YearMonth selectedMonth = month == null || month.isBlank()
                ? YearMonth.from(selectedDate) : YearMonth.parse(month);
        List<Transaction> daily = calendarService.transactionsOn(selectedDate);
        model.addAttribute("selectedDate", selectedDate);
        model.addAttribute("selectedMonth", selectedMonth.toString());
        model.addAttribute("monthLabel", selectedMonth.getMonth().toString() + " " + selectedMonth.getYear());
        model.addAttribute("monthlyIncome", dashboardService.monthlyIncome(selectedMonth));
        model.addAttribute("monthlyExpenses", dashboardService.monthlyExpenses(selectedMonth));
        model.addAttribute("monthlyNet", dashboardService.monthlyNet(selectedMonth));
        model.addAttribute("balance", dashboardService.currentBalance());
        model.addAttribute("dailyTransactions", daily);
        model.addAttribute("allTransactions", transactionService.getAllTransactions());
        model.addAttribute("monthTransactions", calendarService.transactionsIn(selectedMonth));
        model.addAttribute("monthStart", selectedMonth.atDay(1));
        model.addAttribute("daysInMonth", selectedMonth.lengthOfMonth());
        model.addAttribute("firstDayOffset", selectedMonth.atDay(1).getDayOfWeek().getValue() % 7);
        model.addAttribute("transactionForm", new TransactionForm());
        return "index";
    }

    @PostMapping("/transactions")
    public String addTransaction(@ModelAttribute("transactionForm") TransactionForm form,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (form.getAmount() == null || form.getAmount().signum() <= 0) {
            bindingResult.rejectValue("amount", "amount.invalid", "Amount must be greater than zero.");
        }
        if (form.getDate() == null) {
            bindingResult.rejectValue("date", "date.required", "Date is required.");
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please provide a valid amount and date.");
            return "redirect:/";
        }
        try {
            transactionService.add(form.getType(), form.getAmount(), form.getDate(), form.getCategory(), form.getDescription());
            redirectAttributes.addFlashAttribute("successMessage", "Transaction added successfully.");
            return "redirect:/?date=" + form.getDate();
        } catch (IllegalArgumentException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
            return "redirect:/";
        }
    }

    @GetMapping("/export.csv")
    public void exportCsv(@RequestParam(required = false) String month, HttpServletResponse response) throws IOException {
        YearMonth selectedMonth = month == null || month.isBlank() ? YearMonth.now() : YearMonth.parse(month);
        response.setContentType("text/csv; charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=\"finance-" + selectedMonth + ".csv\"");
        StringBuilder csv = new StringBuilder("Date,Type,Category,Amount,Description\\r\\n");
        for (Transaction t : calendarService.transactionsIn(selectedMonth)) {
            csv.append(csv(t.getDate().toString())).append(',')
               .append(csv(t.getType())).append(',')
               .append(csv(t.getCategory())).append(',')
               .append(csv(t.getAmount().toPlainString())).append(',')
               .append(csv(t.getDescription())).append("\\r\\n");
        }
        response.getOutputStream().write(("\\uFEFF" + csv).getBytes(StandardCharsets.UTF_8));
    }

    private String csv(String value) {
        String safe = value == null ? "" : value;
        return "\"" + safe.replace("\"", "\"\"") + "\"";
    }

    public static class TransactionForm {
        private String type = "EXPENSE";
        @NotNull @DecimalMin(value = "0.01") private BigDecimal amount;
        @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) private LocalDate date = LocalDate.now();
        private String category = "Food & Dining";
        private String description = "";
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public BigDecimal getAmount() { return amount; }
        public void setAmount(BigDecimal amount) { this.amount = amount; }
        public LocalDate getDate() { return date; }
        public void setDate(LocalDate date) { this.date = date; }
        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }
}
