# Daily Expense & Personal Finance Dashboard
## Software Engineering Capstone Project Proposal

**Student Name:** [YOUR NAME]  
**Student ID:** [YOUR STUDENT ID]  
**Department:** Information and Communication Technology  
**Institution:** [YOUR UNIVERSITY]  
**Course:** Software Engineering / Capstone Project  
**Instructor:** [YOUR INSTRUCTOR]  
**Submission Date:** [DATE]  
**Repository URL:** [GITHUB REPOSITORY URL]

---

## Abstract
The Daily Expense & Personal Finance Dashboard is a Java-based web application proposed to help an individual record income and expenses, monitor a single personal wallet, review transactions by date, understand monthly spending patterns, and export financial records. Many people track spending informally in notebooks or scattered notes, making it difficult to calculate balances, identify high-spending categories, and prepare monthly summaries. The proposed system centralizes these activities in a simple browser-based interface. The initial prototype demonstrates transaction entry, a date-based calendar, and dashboard summaries. The planned complete system will add persistent MySQL storage, authenticated user accounts, category management, filtering, and CSV/Excel reporting. The project will follow an iterative and incremental software process, with requirements, design, implementation, testing, and evaluation reviewed at each increment.

## 1. Introduction
Personal financial awareness depends on consistently recording money received and money spent. Manual methods can be time-consuming and may contain calculation errors. A lightweight web application can make records easier to maintain and allow a user to inspect transactions for a specific date or month. This project proposes a personal finance dashboard with a deliberately limited initial scope: one user account owns one wallet, and each transaction is classified as income or expense.

## 2. Problem Statement
People who track their daily spending manually may face the following problems:
- Income and expense records are spread across notebooks, messages, or separate files.
- Daily and monthly totals require manual calculations.
- It is difficult to see all transactions associated with a particular date.
- Users may not notice which categories consume the largest share of their budget.
- Preparing a monthly report can require copying and formatting data by hand.
- Records can be lost or become inconsistent when calculations are not updated carefully.

The proposed application aims to address these problems through centralized transaction records, automated balance calculations, a calendar view, and exportable reports.

## 3. Aim and Objectives
### 3.1 Aim
To design and prototype a user-friendly Java web application for managing daily income and expenses through a single personal wallet.

### 3.2 Specific objectives
1. Provide a clear dashboard showing wallet balance, monthly income, monthly expenses, and net cash flow.
2. Allow a user to add, edit, view, and delete income and expense transactions.
3. Present a monthly calendar and show the selected date's transactions.
4. Classify transactions using categories such as Food & Dining, Transportation, Shopping, Education, Bills, Health, Entertainment, and Other.
5. Calculate totals using decimal-safe monetary arithmetic.
6. Allow filtering by date range, transaction type, and category.
7. Export transaction data for a selected period to CSV and, in the full implementation, Excel XLSX.
8. Design a secure, maintainable layered architecture that can later use MySQL persistence and authenticated accounts.

## 4. Scope
### 4.1 In scope
- Registration and login in the planned full application.
- One wallet per user, with an optional opening balance.
- Recording income and expense transactions in Bangladeshi Taka (BDT).
- Transaction date, amount, type, category, and optional description.
- Edit and delete transaction operations.
- Calendar-based daily transaction review.
- Current wallet balance and selected-month summaries.
- Category-based spending summaries.
- Date/type/category filters.
- CSV export in the complete implementation.
- Excel XLSX export in the complete implementation.
- Responsive English-language interface.
- Java web architecture using Spring Boot and Thymeleaf.

### 4.2 Out of scope for the initial capstone
- Bank account linking or automatic bank feeds.
- Mobile native applications.
- Multiple wallets, foreign-currency conversion, investments, loans, or tax advice.
- Payment processing and money transfers.
- Shared household accounts.
- AI-generated financial advice.
- Production deployment and external security audit.

### 4.3 Prototype boundary
The included prototype is a small demonstration of the central interaction: record income/expenses, view the calendar, and inspect summary totals. It uses in-memory sample data and does not yet implement real authentication, MySQL persistence, or XLSX export. Those are planned features, not claims about the current prototype.

## 5. Stakeholders and User Profile
**Primary stakeholder:** an individual who wants to track personal income and spending.  
**Secondary stakeholders:** course instructor and evaluator, who assess requirements analysis, design quality, schedule, and prototype implementation.  
**User profile:** a person with basic browser and computer/mobile web skills who needs a straightforward English interface and clear financial totals.

## 6. Functional Requirements
| ID | Requirement | Priority |
|---|---|---|
| FR-01 | The full system shall allow a user to register with a name, email, and password. | Must |
| FR-02 | The full system shall authenticate users and support logout. | Must |
| FR-03 | The system shall show wallet balance, selected-month income, expenses, and net cash flow. | Must |
| FR-04 | The system shall allow the user to add an income transaction. | Must |
| FR-05 | The system shall allow the user to add an expense transaction. | Must |
| FR-06 | The system shall allow the user to view, edit, and delete their own transactions. | Must |
| FR-07 | The system shall display a monthly calendar with dates containing transactions. | Must |
| FR-08 | Selecting a date shall show transactions recorded for that date. | Must |
| FR-09 | The system shall calculate totals from transaction records. | Must |
| FR-10 | The system shall support default categories and user-defined categories in the full version. | Should |
| FR-11 | The system shall prepare a report for a selected month or date range. | Must |
| FR-12 | The full system shall export selected transaction data as CSV. | Must |
| FR-13 | The full system shall export selected transaction data as a valid XLSX workbook. | Should |
| FR-14 | The full system shall filter transactions by date range, type, and category. | Should |
| FR-15 | Each user shall access only their own wallet and financial records. | Must |
| FR-16 | The system shall validate positive transaction amounts and required fields. | Must |

## 7. Non-Functional Requirements
- **Security:** password hashes rather than plaintext passwords; authenticated routes; authorization checks on every user-owned record.
- **Privacy:** financial records must not be visible to another account.
- **Accuracy:** monetary amounts use `BigDecimal` in Java and `DECIMAL` in MySQL; no binary floating-point arithmetic for currency.
- **Integrity:** database constraints and server-side validation prevent invalid amounts and inconsistent ownership.
- **Usability:** common tasks should be understandable without technical training; forms should provide clear validation feedback.
- **Performance:** dashboard and date queries should respond promptly for ordinary personal use; a target of under two seconds is proposed for a dataset of up to 10,000 transactions on a typical development machine, subject to testing.
- **Maintainability:** presentation, controller, service, and data-access responsibilities remain separated.
- **Compatibility:** support current mainstream desktop and mobile browsers.
- **Reliability:** persistent records in the full version should survive application restarts.
- **Testability:** core calculations and validation should have automated unit tests.

## 8. Software Process Model
### 8.1 Selected model: Iterative and Incremental Development
The project will be developed in small, reviewable increments. Each increment includes a limited set of requirements, design, implementation, testing, and review.

### 8.2 Justification
- Requirements and visual details can be refined after a working prototype is reviewed.
- Calendar, transaction forms, dashboard calculations, and exports can be implemented and tested separately.
- Early prototype feedback can reveal usability problems before the complete application is built.
- A small student project benefits from visible milestones and manageable increments.
- The model supports the assignment's need to present an early proposal and prototype before the full product is complete.

### 8.3 Iteration cycle
1. Select and clarify requirements.
2. Update diagrams and design.
3. Implement a small increment.
4. Run unit and integration tests.
5. Review the result and record issues.
6. Prioritize improvements for the next increment.

## 9. Proposed Technology Stack
| Layer / purpose | Technology |
|---|---|
| Language | Java 21 |
| Web framework | Spring Boot, Spring MVC |
| Server-rendered interface | Thymeleaf, HTML5, CSS3, JavaScript |
| Responsive styling | Custom CSS; Bootstrap may be added |
| Database for full version | MySQL 8 |
| Data access | JDBC / Spring JDBC with parameterized queries |
| Build | Maven |
| Testing | JUnit 5 and Spring test support |
| CSV export | Java I/O with proper CSV escaping |
| XLSX export | Apache POI (planned full version) |
| Diagrams | Mermaid and PlantUML |
| Version control | Git and GitHub |

## 10. System Architecture
The planned full system follows a layered MVC architecture:

**Browser / Thymeleaf UI → Controller → Service layer → DAO / Repository → MySQL**

- **Presentation layer:** forms, dashboard cards, calendar, tables, filters, and report controls.
- **Controller layer:** handles HTTP requests, validates request shape, and selects views.
- **Service layer:** applies business rules, computes balances, checks transaction ownership, and prepares reports.
- **Data-access layer:** executes parameterized database queries.
- **Database layer:** persists users, wallets, categories, and transactions.

The prototype currently demonstrates the presentation/controller/service/domain flow with in-memory data. Database integration and authentication remain future increments.

## 11. Data Model and Business Rules
### 11.1 Main entities
- **User:** account identity and password hash.
- **Wallet:** one personal wallet belonging to one user.
- **Category:** classifies transactions as income or expense; defaults may be shared, while custom categories belong to a user.
- **Transaction:** amount, date, type, category, description, and ownership.

### 11.2 Relationships
- One User owns exactly one Wallet in the proposed single-wallet model.
- One User has many Transactions.
- One Wallet contains many Transactions.
- One Category may classify many Transactions.
- Each Transaction belongs to one User and one Wallet, and may reference one Category.

### 11.3 Financial calculation rules
- `Current balance = opening balance + lifetime income − lifetime expenses`
- `Monthly net cash flow = selected-month income − selected-month expenses`
- The wallet balance is based on all applicable records; month cards and reports are scoped to the selected month.
- Amounts must be greater than zero.
- Income and expense type must be explicit; an expense is not stored as a negative amount.
- Use `BigDecimal` in Java and `DECIMAL(12,2)` in MySQL.
- Store dates in a consistent application/database convention and display them in the user's local format.

## 12. User Stories and Acceptance Criteria
### Story A — Add expense
**As a user,** I want to record an expense with an amount, date, category, and description so that my spending history stays accurate.

Acceptance criteria:
- Amount and date are required; amount must be greater than zero.
- A valid record appears in the transaction list and selected date.
- Expense totals and wallet balance update consistently.
- Invalid input produces a clear message and is not saved.

### Story B — Review a date
**As a user,** I want to select a calendar date and see its transactions so that I can understand what I spent money on that day.

Acceptance criteria:
- The calendar shows the selected month.
- Selecting a date displays only transactions for that date.
- A date with no transactions shows an understandable empty state.
- Changing month does not change transaction records.

### Story C — Export monthly records
**As a user,** I want to export a selected month's transactions so that I can archive or analyze them.

Acceptance criteria:
- The selected period is applied to the export.
- The file contains date, type, category, amount, and description columns.
- CSV fields are escaped correctly; the full version produces a valid XLSX workbook.
- Exported totals reconcile with the dashboard for the same period.

### Story D — Protect financial records
**As a user,** I want my finance records private so that another user cannot view or modify them.

Acceptance criteria:
- Every request in the full version requires authentication where appropriate.
- Data queries are scoped to the authenticated user's ID.
- Unauthorized attempts are rejected and tested.
- Passwords are stored as secure hashes, never plaintext.

## 13. Interface and Prototype Plan
The initial interface includes:
1. A top navigation/title area.
2. Summary cards for wallet balance, monthly income, monthly expenses, and net cash flow.
3. A transaction form with type, amount, date, category, and description.
4. A monthly calendar with clickable dates.
5. A transaction list for the selected date.
6. A CSV download action for the prototype's current in-memory records.

The prototype is intentionally small but connects multiple domain/service/controller classes to the visible interface. Screenshots of the running application should be captured by the student after running it locally.

## 14. Testing Strategy
- **Unit testing:** balance calculation, monthly totals, positive amount validation, category/type handling.
- **Controller testing:** route responses, form submission, and validation feedback.
- **Integration testing (planned):** service and DAO operations against a test database.
- **Acceptance testing:** verify the four user stories and their criteria.
- **Security testing (planned):** cross-user access checks, invalid login, and input validation.
- **Export testing (planned):** correct date range, CSV escaping, and XLSX file structure.
- **Regression testing:** rerun relevant tests after each increment.

## 15. Risks and Mitigation
| Risk | Likelihood / impact | Mitigation |
|---|---|---|
| Scope grows beyond the assignment timeline | Medium / High | Keep Must-Have features first; move optional features to future work. |
| Database integration takes longer than expected | Medium / Medium | Build and test the domain/service layer first; use clear DAO boundaries. |
| Incorrect balance calculations | Medium / High | Use `BigDecimal`; add unit tests for income, expense, and opening balance. |
| User data exposure | Low-to-medium / High | Enforce authentication and user-scoped queries; test authorization. |
| Export formatting errors | Medium / Medium | Test exported rows and totals against source transactions. |
| Diagram and implementation become inconsistent | Medium / Medium | Update diagrams during each design review and keep class names consistent. |
| Limited time for testing | Medium / High | Reserve a dedicated testing and documentation period in the schedule. |

## 16. Schedule, Milestones, and Deliverables
The proposed full project schedule is in `planning/PROJECT_SCHEDULE.md`; the visual Gantt source is in `planning/GANTT.mmd`.

Major milestones:
- **M1 — Requirements baseline:** approved scope, user stories, and requirements.
- **M2 — Design baseline:** architecture and six diagrams reviewed.
- **M3 — Prototype review:** transaction entry, calendar, and dashboard demonstration.
- **M4 — Core implementation:** authentication, MySQL persistence, and transaction management.
- **M5 — Reporting complete:** filters and exports.
- **M6 — Final verification:** tests, documentation, screenshots, and repository cleanup.

## 17. Expected Outcomes
The expected outcome is a clear, extensible prototype and a design baseline for a Java personal finance web application. The completed system should reduce manual calculations, make date-wise records easier to inspect, summarize monthly cash flow, and provide exportable records. The project also demonstrates requirements engineering, process-model selection, diagramming, layered design, prototype implementation, and testing.

## 18. Future Enhancements
Possible future improvements include monthly budgets, budget threshold alerts, recurring transactions, dark mode, PDF reports, charts by category, and deployment. These are not required for the initial prototype and should be attempted only after core features are stable.

## 19. Conclusion
The Daily Expense & Personal Finance Dashboard is a feasible student capstone because it addresses a practical problem and can be developed incrementally. Its initial deliverables define requirements, architecture, data relationships, schedule, diagrams, and a working web prototype. The proposal distinguishes clearly between what the prototype demonstrates and what remains planned for the full implementation.

## References
1. Oracle. *Java Documentation*. https://docs.oracle.com/en/java/
2. Spring. *Spring Boot Reference Documentation*. https://docs.spring.io/spring-boot/
3. MySQL. *MySQL 8.0 Reference Manual*. https://dev.mysql.com/doc/
4. Mermaid. *Mermaid Documentation*. https://mermaid.js.org/
5. PlantUML. *PlantUML Language Reference Guide*. https://plantuml.com/
