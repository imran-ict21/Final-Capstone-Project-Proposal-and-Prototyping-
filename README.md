# Daily Expense & Personal Finance Dashboard

> A Java-based web application prototype for tracking personal income, expenses, wallet balance, and monthly financial activity.

![Project Status](https://img.shields.io/badge/Status-Academic%20Prototype-blue)
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Database](https://img.shields.io/badge/Database-MySQL%208-blue)

---

## 1. Project Overview

The **Daily Expense & Personal Finance Dashboard** is a personal finance management system designed to help individuals record, organize, monitor, and analyze their daily financial activities from a single dashboard.

Many people find it difficult to maintain accurate records of daily expenses and income. Manual notebooks and scattered spreadsheets make it hard to understand spending habits, calculate balances, or review monthly financial performance. This project aims to provide a simple, structured, and user-friendly digital solution.

The proposed system allows a user to maintain one personal wallet, record income and expenses, view transaction history, explore transactions by date, and review monthly financial summaries. It is being developed as a Software Engineering capstone project, emphasizing requirements analysis, software process planning, system modeling, object-oriented design, and prototype development.

### Project Information

| Item | Description |
|---|---|
| Project Name | Daily Expense & Personal Finance Dashboard |
| Project Type | Java Web Application |
| Project Category | Personal Finance Management |
| Currency | Bangladeshi Taka (BDT) |
| Interface Language | English |
| Backend Language | Java 21 |
| Framework | Spring Boot |
| Database | MySQL 8 (planned for full implementation) |
| Architecture | Layered Architecture (Controller–Service–DAO) |
| Project Purpose | Software Engineering Capstone Project |

## 2. Vision and Objectives

### Vision

To develop a reliable, accessible, and easy-to-use personal finance management application that helps users understand where their money comes from, where it goes, and how their financial balance changes over time.

### Main Objectives

- Provide a centralized place to record personal income and expenses.
- Maintain a single wallet for each registered user.
- Automatically calculate the current wallet balance.
- Present daily and monthly financial summaries.
- Make transaction history easy to explore by date.
- Organize transactions using meaningful categories.
- Support searching and filtering of financial records.
- Allow users to export financial reports.
- Apply software engineering principles throughout planning, design, implementation, and testing.

## 3. Key Features

### 3.1 User Account Management

Planned functionality:

- User registration and login.
- Individual user profile.
- Secure password handling.
- User-specific financial records.
- Data isolation so one user cannot access another user's transactions.

### 3.2 Single Wallet Management

Each user will have exactly one personal wallet. The wallet provides an overview of the user's overall financial position.

**Wallet balance formula:**

```text
Current Balance = Opening Balance + Total Income - Total Expenses
```

The wallet balance represents the overall balance, while dashboard income and expense summaries can be calculated for a selected month.

### 3.3 Income Management

Users will be able to record income with amount, category, date, and description/note.

Example income categories:

- Salary
- Business
- Freelancing
- Gifts
- Other

### 3.4 Expense Management

Users will be able to record daily expenses with amount, category, date, and description/note.

Example expense categories:

- Food & Dining
- Transportation
- Shopping
- Education
- Housing & Bills
- Health
- Entertainment
- Personal Care
- Other

### 3.5 Dashboard

The dashboard is intended to provide a quick overview of:

- Current wallet balance
- Total income for the selected month
- Total expenses for the selected month
- Monthly savings or net cash flow
- Recent transactions
- Selected-month financial overview

### 3.6 Calendar-Based Transaction View

Planned capabilities:

- Navigate between months.
- Select a specific date.
- View transactions recorded on that date.
- Identify dates with recorded financial activity.
- Review daily income and expense totals.

### 3.7 Transaction History

Planned capabilities:

- View transaction date, type, category, amount, and description.
- Filter transactions by date range.
- Filter by income or expense.
- Filter by category.
- Search transaction descriptions.
- Edit or delete existing records.

### 3.8 Reports and Export

Planned reporting capabilities:

- Monthly income and expense summaries.
- Date-range-based reports.
- CSV export.
- Excel (XLSX) export.

Exported reports will help users maintain offline records and analyze spending.

## 4. Prototype Implementation Status

This repository includes an initial Spring Boot prototype. It demonstrates the main user workflow and selected application classes; it is not yet the complete production-ready system.

| Feature | Current Prototype Status |
|---|---|
| Dashboard summary cards | Implemented |
| Add income transaction | Implemented |
| Add expense transaction | Implemented |
| Wallet balance calculation | Implemented in application logic |
| Calendar/date-based view | Implemented in basic form |
| Transaction history | Implemented |
| Monthly CSV export | Implemented |
| MySQL database persistence | Planned |
| User registration and authentication | Planned |
| User-specific data isolation | Planned |
| Edit and delete transactions | Planned |
| Advanced search and filters | Planned |
| Excel (XLSX) export | Planned |
| Production security configuration | Planned |

**Important:** The current prototype uses in-memory data. Records may be lost when the application is restarted. MySQL persistence and the remaining planned features are part of future implementation. A planned feature must not be interpreted as an already completed feature.

## 5. Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Main programming language |
| Spring Boot | Backend application framework |
| Spring MVC | Web request and controller handling |
| Thymeleaf | Server-side HTML template rendering |
| HTML5 | Page structure |
| CSS3 | User interface styling |
| JavaScript | Client-side interactions |
| Maven | Dependency and build management |
| MySQL 8 | Planned relational database |
| JDBC / Spring JDBC | Planned database connectivity without an ORM |
| JUnit 5 | Unit testing |
| Apache POI | Planned Excel (XLSX) export |
| Mermaid | DFD, use case, activity, ERD, and Gantt diagram source |
| PlantUML | Class and object diagram source |
| Git and GitHub | Version control and project hosting |

## 6. System Architecture

The planned application follows a layered architecture. Each layer has a clear responsibility, making the system easier to maintain, test, and extend.

```text
+-------------------------------+
|       Presentation Layer      |
| Browser / HTML / CSS / JS      |
|       Thymeleaf Templates      |
+---------------+---------------+
                |
                v
+-------------------------------+
|         Controller Layer      |
|       Spring MVC Controllers  |
|   Receives and routes requests|
+---------------+---------------+
                |
                v
+-------------------------------+
|           Service Layer       |
| Business Rules and Validation |
| Wallet / Transaction / Report |
+---------------+---------------+
                |
                v
+-------------------------------+
|       DAO / Repository Layer  |
|         JDBC / Spring JDBC    |
|      Database access          |
+---------------+---------------+
                |
                v
+-------------------------------+
|          Database Layer       |
|             MySQL 8           |
+-------------------------------+
```

### Layer Responsibilities

- **Presentation Layer:** Displays information and collects user input.
- **Controller Layer:** Handles HTTP requests and routes application operations.
- **Service Layer:** Implements business rules, calculations, and validation.
- **DAO/Repository Layer:** Handles database queries and persistence.
- **Database Layer:** Stores users, wallets, categories, and transactions.

## 7. Main System Entities

| Entity | Purpose |
|---|---|
| User | Stores registered user information |
| Wallet | Stores the single wallet associated with a user |
| Category | Stores income and expense categories |
| Transaction | Stores income and expense records |

### Main Relationships

- One user has exactly one wallet.
- One user can have many transactions.
- One wallet can contain many transactions.
- One category can be associated with many transactions.
- Each transaction belongs to its owning user and wallet.

### Data Integrity Considerations

- Monetary values should use `BigDecimal` in Java.
- Monetary database columns should use `DECIMAL`, not floating-point types.
- Transaction amounts must be greater than zero.
- Database queries must be parameterized.
- Every transaction must be associated with its owner.
- The application must verify ownership before displaying, editing, or deleting a record.

## 8. Core Classes and Object-Oriented Design

The prototype and planned full system use object-oriented design. Important classes include:

| Class | Responsibility |
|---|---|
| `User` | Represents a registered application user |
| `Wallet` | Represents the user's single wallet |
| `Transaction` | Represents a financial transaction |
| `Income` | Represents an income transaction |
| `Expense` | Represents an expense transaction |
| `Category` | Represents a transaction category |
| `WalletService` | Calculates and manages wallet-related operations |
| `TransactionService` | Handles transaction-related business logic |
| `DashboardService` | Prepares dashboard summaries |
| `CalendarService` | Organizes transactions by date |
| `ReportService` | Generates financial summaries and reports |
| `UserDAO` | Handles user database operations |
| `TransactionDAO` | Handles transaction database operations |

The prototype demonstrates multiple application classes. The class diagram describes the broader planned design.

## 9. Software Engineering Deliverables

This repository is organized to support the capstone proposal and prototyping requirements.

| Assignment Requirement | Project Deliverable |
|---|---|
| Project idea and proposal | `docs/PROPOSAL.md` |
| Requirements and scope | `docs/PROPOSAL.md` |
| Software process model | `docs/PROPOSAL.md` |
| Project schedule and milestones | `docs/planning/PROJECT_SCHEDULE.md` |
| Gantt chart source | `docs/planning/GANTT.mmd` |
| Data Flow Diagram | `docs/diagrams/DFD.mmd` |
| Level 1 Data Flow Diagram | `docs/diagrams/DFD_LEVEL_1.mmd` |
| Use Case Diagram | `docs/diagrams/USE_CASE.mmd` |
| Activity Diagram | `docs/diagrams/ACTIVITY.mmd` |
| Entity Relationship Diagram | `docs/diagrams/ERD.mmd` |
| Class Diagram | `docs/diagrams/CLASS_DIAGRAM.puml` |
| Object Diagram | `docs/diagrams/OBJECT_DIAGRAM.puml` |
| Working interface prototype | `prototype/` |
| Prototype test example | `prototype/src/test/` |

### Software Process Model

The project uses an **iterative and incremental development approach**. The system is divided into manageable modules, and each iteration can refine requirements, design, implementation, and testing.

This approach is appropriate because the project has several independent but connected features, and the prototype can be improved gradually as feedback is received.

## 10. Project Milestones

1. **Project Initiation:** Select the project idea, define the problem, and identify objectives.
2. **Requirements Analysis:** Identify stakeholders, functional requirements, non-functional requirements, and project scope.
3. **System Design:** Prepare architecture, database design, UML diagrams, and interface plans.
4. **Prototype Development:** Build the initial web interface and demonstrate core workflows.
5. **Testing:** Prepare and execute unit, integration, and user-interface tests.
6. **Documentation:** Complete the proposal, diagrams, schedules, setup instructions, and project documentation.
7. **Final Review and Submission:** Review deliverables, update the repository, and prepare the GitHub submission link.

See `docs/planning/PROJECT_SCHEDULE.md` and `docs/planning/GANTT.mmd` for the detailed schedule.

## 11. Project Structure

```text
Daily_Expense_Finance_Dashboard/
│
├── README.md
├── docs/
│   ├── PROPOSAL.md
│   ├── ASSIGNMENT_MAPPING.md
│   ├── diagrams/
│   │   ├── DFD.mmd
│   │   ├── DFD_LEVEL_1.mmd
│   │   ├── USE_CASE.mmd
│   │   ├── ACTIVITY.mmd
│   │   ├── ERD.mmd
│   │   ├── CLASS_DIAGRAM.puml
│   │   └── OBJECT_DIAGRAM.puml
│   └── planning/
│       ├── PROJECT_SCHEDULE.md
│       └── GANTT.mmd
└── prototype/
    ├── pom.xml
    ├── README.md
    └── src/
        ├── main/
        │   ├── java/
        │   └── resources/
        │       ├── templates/
        │       └── static/
        └── test/
            └── java/
```

## 12. Getting Started

### Prerequisites

Install:

- JDK 21 (Eclipse Temurin/Adoptium or Oracle JDK)
- IntelliJ IDEA or another Java IDE
- Git
- Maven (if not using IDE-integrated Maven)

Verify Java installation:

```bash
java -version
```

The output should indicate Java 21.

### Clone the Repository

Replace the placeholder with the actual GitHub repository URL:

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
cd YOUR_REPOSITORY
```

### Run the Prototype

Move into the prototype directory:

```bash
cd prototype
```

Run the application using Maven:

```bash
mvn spring-boot:run
```

Open this address in a browser:

```text
http://localhost:8080
```

### Run Tests

From the `prototype` directory:

```bash
mvn test
```

**Note:** These are setup instructions for the included prototype. They do not imply that the application has been deployed to production. If a command fails, check the installed JDK version, Maven configuration, and IDE project settings.

## 13. Testing Strategy

Testing is important for ensuring the correctness and reliability of the application.

### Unit Testing

Test individual classes and business operations, such as:

- Wallet balance calculation.
- Income and expense handling.
- Transaction validation.
- Monthly summary calculation.
- Date-based transaction retrieval.

### Integration Testing

For the full database-backed implementation, test:

- Service-to-database interactions.
- User and wallet relationships.
- Transaction creation and retrieval.
- Transaction ownership checks.
- Report data retrieval.

### User Interface Testing

Verify that:

- Forms accept valid input.
- Invalid values are rejected with understandable feedback.
- Dashboard figures are displayed correctly.
- Date selection shows the appropriate transactions.
- Export actions generate the expected report.

### Example Test Cases

| Test Case | Input | Expected Result |
|---|---|---|
| Add income | Valid positive amount | Income is recorded |
| Add expense | Valid positive amount | Expense is recorded |
| Calculate balance | Opening balance + income − expenses | Correct balance is returned |
| Add invalid amount | Zero or negative amount | Validation error |
| View daily transactions | A selected date | Only that date's transactions are shown |

## 14. Security and Data Integrity

Security and data integrity are considered in the planned full implementation.

- Passwords must be stored using a secure password-hashing mechanism, never as plain text.
- User-specific data must be protected through authentication and authorization.
- Database access must use prepared statements or parameterized queries.
- Inputs must be validated on the server side.
- Users must only be able to access their own wallets and transactions.
- Monetary values must use precision-safe data types.
- Sensitive configuration values must not be committed to the public repository.

These are design requirements for the complete system; they should not be interpreted as proof that all production security controls are already implemented in the prototype.

## 15. Future Enhancements

The following improvements are planned for later development:

- MySQL database integration.
- Complete user registration and authentication.
- Secure session management and authorization.
- Persistent wallet and transaction records.
- Edit and delete transaction operations.
- Advanced transaction search and filtering.
- Monthly and yearly charts.
- Excel (XLSX) report export.
- Improved validation and error handling.
- Responsive interface improvements.
- More comprehensive automated tests.

## 16. Expected Outcomes

After completion, the project is expected to provide:

- A usable personal finance management web application.
- A clear overview of income, expenses, and wallet balance.
- Organized daily and monthly financial records.
- A calendar-based way to review transactions.
- Downloadable financial reports.
- A maintainable codebase based on layered architecture and object-oriented design.
- Complete software engineering documentation and system diagrams.

## 17. Academic Information

Update the following information before submission.

| Field | Information |
|---|---|
| Student Name | [YOUR NAME] |
| Student ID | [YOUR STUDENT ID] |
| Department | Information and Communication Technology (ICT) |
| University | [YOUR UNIVERSITY] |
| Course | Software Engineering Capstone Project |
| Instructor | [YOUR INSTRUCTOR] |
| Submission Date | [DATE] |
| GitHub Repository | [GITHUB REPOSITORY URL] |

## 18. References and Tools

- [Java Documentation](https://docs.oracle.com/en/java/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/index.html)
- [Spring MVC Documentation](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Mermaid Documentation](https://mermaid.js.org/)
- [PlantUML Documentation](https://plantuml.com/)

## 19. Final Submission Checklist

Before submitting the GitHub repository, verify the following:

- [ ] Replace all academic placeholders with correct information.
- [ ] Confirm that the GitHub repository is accessible to the instructor.
- [ ] Ensure that `README.md` appears on the repository homepage.
- [ ] Include the complete project proposal.
- [ ] Include all required diagram source files.
- [ ] Include the project schedule and Gantt chart.
- [ ] Include the prototype source code.
- [ ] Add genuine screenshots of the running prototype, if required.
- [ ] Ensure that the README's implementation-status table matches the actual code.
- [ ] Review spelling, formatting, links, and folder names.
- [ ] Test the prototype locally before claiming that it runs successfully.

---

## Conclusion

The **Daily Expense & Personal Finance Dashboard** aims to make personal money management more organized, understandable, and accessible. By combining transaction management, wallet balance calculation, calendar-based activity tracking, and financial reporting, the project provides a practical solution to a common everyday problem.

Beyond application development, this capstone project demonstrates software engineering practices, including requirements analysis, iterative planning, system modeling, object-oriented design, prototyping, and testing.

**Track your money. Understand your habits. Make better financial decisions.**
