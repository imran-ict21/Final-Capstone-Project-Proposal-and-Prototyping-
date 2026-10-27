# Daily Expense & Personal Finance Dashboard
**Software Engineering Capstone — Proposal, Planning, Diagrams, and Web Prototype**

> Student submission starter pack. Replace every `[YOUR ...]` placeholder with your actual details before submitting. Review the proposal and be prepared to explain the design; no project bundle can guarantee a particular grade.

## Project summary
A Java web application that lets a registered user manage one personal wallet, record income and expenses, review transactions on a date-based calendar, see monthly summaries, and export records to CSV. The prototype is built with Java 21, Spring Boot, Thymeleaf, Maven, and responsive CSS. The proposal and diagrams are in `docs/`.

## Contents
- `docs/PROPOSAL.md` — English academic project proposal.
- `docs/ASSIGNMENT_MAPPING.md` — mapping between assignment requirements and included deliverables.
- `docs/diagrams/` — DFD, Use Case, Activity, ER, Class, and Object diagrams in Mermaid/PlantUML source.
- `docs/planning/` — schedule, milestones, deliverables, and Gantt chart source.
- `prototype/` — minimal Spring Boot web prototype.
- `prototype/README.md` — setup and run instructions.

## Quick start
1. Install JDK 21 and Maven 3.9+.
2. Open a terminal in `prototype/`.
3. Run `mvn spring-boot:run`.
4. Open `http://localhost:8080`.
5. Use the prototype to add income/expenses and view the date calendar and monthly summary.

The prototype stores demo transactions in memory while the application is running. It is intentionally a **UI/functional prototype**, not the final secure multi-user application. MySQL persistence, authentication, user isolation, full XLSX export, and production security are planned implementation work and are documented as such. Do not describe these features as already implemented.

## Suggested GitHub upload
Create a repository with a clear name such as `daily-expense-finance-dashboard`, upload the contents of this folder (not only the ZIP), and verify that GitHub displays this README. Include your real name, student ID, course/section, instructor, and date where required by your department.

## Before submission checklist
- [ ] Replace all `[YOUR ...]` placeholders.
- [ ] Confirm the assignment's requested format and whether diagrams must also be exported as images/PDF.
- [ ] Render/check each diagram and ensure labels remain readable.
- [ ] Add your own screenshots of the running prototype if required.
- [ ] Run `mvn test` and `mvn spring-boot:run` locally.
- [ ] Review every section and be ready to explain the scope, assumptions, design, and limitations.
- [ ] Confirm the repository URL is the one submitted to the LMS.

## Diagram rendering
Mermaid files can be previewed on GitHub or in a Mermaid-compatible editor. The Class Diagram is in PlantUML source. Export diagrams to PNG/SVG/PDF if your instructor requires image files.

## Important scope note
The assignment asks for an initial proposal and prototype. This repository provides those deliverables plus a runnable prototype baseline. It does not claim to be a production-ready finance platform.
