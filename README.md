# JPMorgan Chase Midas Core Banking System

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![Apache Kafka](https://img.shields.io/badge/Apache_Kafka-Streaming-black)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![Status](https://img.shields.io/badge/Status-Completed-success)

## Overview

This project was completed as part of the JPMorgan Chase Software Engineering Virtual Experience Program on Forage.

The application simulates a core banking service responsible for processing financial transactions and maintaining account balances. It demonstrates enterprise backend development practices using Java and Spring Boot, including transaction handling, database persistence, testing, and RESTful API design.

---

## Features

- Process financial transactions
- Manage account balances
- Store transaction records in a database
- RESTful API endpoints
- Input validation and error handling
- Unit and integration testing
- Layered Spring Boot architecture

---

## Technologies Used

| Technology | Purpose |
|------------|----------|
| Java 17 | Core application development |
| Spring Boot | Backend framework |
| Apache Kafka | Event streaming and transaction processing |
| Spring Data JPA | Database access |
| H2 Database | Data persistence |
| Maven | Build automation |
| JUnit 5 | Testing |
| Mockito | Mocking framework |

---

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com/jpmc/midascore
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── entity
│   │       └── config
│   └── resources
│
└── test/
    └── java/
```

---

## Getting Started

### Prerequisites

Make sure you have installed:

- Java 17+
- Maven 3.8+

### Clone the Repository

```bash
git clone https://github.com/mhamadghourani/forage-midas.git
cd forage-midas
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

---

## Running Tests

Execute all tests using:

```bash
mvn test
```

---

## Learning Outcomes

Through this project I gained practical experience with:

- Enterprise Java development
- Spring Boot application architecture
- REST API design and implementation
- Database persistence using JPA
- Financial transaction processing workflows
- Automated testing with JUnit and Mockito
- Maven project management
- Backend software engineering best practices

---

## Example Workflow

```text
Transaction Request
        │
        ▼
REST Controller
        │
        ▼
Service Layer
        │
        ▼
Repository Layer
        │
        ▼
Database
```

---

## Key Concepts Demonstrated

- Dependency Injection
- Layered Architecture
- Repository Pattern
- RESTful Services
- Transaction Management
- Object Relational Mapping (ORM)
- Test-Driven Development Principles

---

## About the Program

The JPMorgan Chase Software Engineering Virtual Experience Program on Forage provides participants with hands-on experience solving real-world software engineering tasks inspired by work performed at JPMorgan Chase.

This project represents the successful completion of the program's backend engineering challenge and showcases practical experience with technologies commonly used in enterprise financial systems.

---

## Future Improvements

- Docker containerization
- PostgreSQL integration
- API documentation with Swagger/OpenAPI
- Authentication and authorization
- CI/CD pipeline integration
- Cloud deployment

---

## Author

**Mohamad Ghourani**

GitHub: https://github.com/mhamadghourani

---

## License

This project is intended for educational and portfolio purposes.


