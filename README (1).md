# Prototype Setup

## Requirements
- JDK 21
- Maven 3.9 or newer
- Internet access on the first run so Maven can download dependencies

## Run
From this directory:

```bash
mvn spring-boot:run
```

Then open `http://localhost:8080`.

## Test
```bash
mvn test
```

## Prototype features
- Dashboard cards: current balance, monthly income, monthly expenses, and net cash flow.
- Add income or expense with amount, date, category, and description.
- Select dates from the calendar to inspect that day's transactions.
- View all prototype transactions.
- Export the selected month's transactions as CSV.
- Uses Java `BigDecimal` for monetary calculations.

## Limitations
This is a classroom prototype, not a production finance application. It stores records in memory, has no account registration/login, does not persist data to MySQL, and does not yet implement XLSX export, edit/delete, or multi-user authorization. The design proposal describes these as planned features. Add database constraints, authenticated user-scoped queries, password hashing, CSRF protection, and integration tests before treating it as a real personal-finance product.
