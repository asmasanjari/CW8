# Library Management System

A console-based Library Management System built with **Java**, **JDBC**, and **PostgreSQL**, following a clean
**three-layer architecture** (Entity → Repository → Service).

This project was developed as a collaborative exercise to practice database design, JDBC, layered architecture, and
Git-based teamwork.

---

## ✨ Features

- **Member Management** — Add, update, delete, and list library members.
- **Book Management** — Add, update, delete, and list books.
- **Lending** — Lend a book to a member (with availability checks).
- **Returns** — Return a borrowed book and update its status.
- **Active Loans** — View all currently active loans with the member's name and the book's title.

---

## 🏗️ Architecture

The project follows a strict three-layer architecture:

```
┌─────────────────────────────┐
│         Service Layer       │  Business logic, validation, orchestration
├─────────────────────────────┤
│       Repository Layer      │  JDBC data access (CRUD, queries)
├─────────────────────────────┤
│         Entity Layer        │  Plain Java models (Member, Book, Loan)
└─────────────────────────────┘
              │
              ▼
       PostgreSQL Database
```

### Layers

| Layer          | Responsibility                                                                                    |
|----------------|---------------------------------------------------------------------------------------------------|
| **Entity**     | POJOs representing database tables (`Member`, `Book`, `Loan`).                                    |
| **Repository** | Handles all JDBC operations — connection handling, prepared statements, result set mapping.       |
| **Service**    | Contains business rules (e.g., a book cannot be lent if already on loan), and calls repositories. |

---

## 🗄️ Database Schema

The database is defined in `db.sql`. It includes the following tables and relationships:

- **members** — library members (`id`, `name`, `email`).
- **books** — library books (`id`, `name`, `author`).
- **loans** — loan records linking members and books (`id`, `member_id`, `book_id`, `borrow_date`, `return_date`).

**Relationships:**

- A `member` can have many `loans` (1 → N).
- A `book` can appear in many `loans` over time (1 → N).
- Each `loan` references exactly one `member` and one `book`.

---

## 🛠️ Tech Stack

- **Java** (JDK 25+ recommended)
- **JDBC** (PostgreSQL JDBC Driver)
- **PostgreSQL** (12+)
- **Git** for version control and collaboration
- *(Optional)* Maven or Gradle for dependency management

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/<your-org>/library-management-system.git
cd library-management-system
```

### 2. Set up the database

Make sure PostgreSQL is running, then create the database and apply the migration:

```bash
createdb library_db
psql -d library_db -f db.sql
```

Or from within `psql`:

```postgresql
CREATE DATABASE library_db;
\c library_db
\i db.sql
```

### 3. Configure the connection

Update your database credentials in the connection config (e.g., `DatabaseConnection.java` or a `db.properties` file):

```properties
db.url=jdbc:postgresql://localhost:5432/library_db
db.user=postgres
db.password=your_password
```

### 4. Build & run

If using Maven:

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="ir.maktabsharif.library.Main"
```

If using plain `javac`:

```bash
javac -d out $(find src -name "*.java")
java -cp "out:lib/postgresql.jar" ir.maktabsharif.library.Main
```

---

## 📁 Project Structure

```
library-management-system/
├── db.sql
├── README.md
└── src/
    └── main/
        └── java/
            └── com/library/
                ├── entity/
                │   ├── Member.java
                │   ├── Book.java
                │   └── Loan.java
                ├── repository/
                │   ├── MemberRepository.java
                │   ├── BookRepository.java
                │   └── LoanRepository.java
                ├── service/
                │   ├── MemberService.java
                │   ├── BookService.java
                │   └── LoanService.java
                ├── util/
                │   └── DatabaseConnection.java
                └── Main.java
```

---

## 📖 Usage

Once running, the application presents a menu:

```
===== Library Management System =====
1. Manage Members
2. Manage Books
3. Lend a Book
4. Return a Book
5. View Active Loans
0. Exit
Choose an option:
```

Follow the on-screen prompts to perform operations.

---

## 🤝 Collaboration

This project uses Git for version control. To contribute:

1. Create a feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
2. Commit your changes with clear messages:
   ```bash
   git commit -m "Add: lend book service logic"
   ```
3. Push and open a Pull Request:
   ```bash
   git push origin feature/your-feature-name
   ```

Please keep commits focused and descriptive, and open a PR for every feature.

---

## 📌 Notes

- All SQL statements use **PreparedStatement** to prevent SQL injection.
- Database connections are closed properly using try-with-resources.
- Business rules (e.g., preventing double-lending) live in the **Service** layer, keeping repositories thin.

---

## 📄 License

This project is created for educational purposes. Feel free to use and adapt it.