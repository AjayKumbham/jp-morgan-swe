# Midas Core &nbsp; <img src="https://img.shields.io/badge/Forage-J.P.%20Morgan%20Software%20Engineering-blue" alt="Forage"/>  <img src="https://img.shields.io/badge/Java-17-blue.svg" alt="Java 17"/>  <img src="https://img.shields.io/badge/Build-Passing-brightgreen.svg" alt="Build Passing"/>  <img src="https://img.shields.io/badge/License-MIT-green.svg" alt="License: MIT"/>

> **J.P. Morgan Software Engineering Job Simulation — Certificate of Completion**

---

<p align="center">
  <img src="https://forage-uploads-prod.s3.amazonaws.com/organization-institution-logos/JP%20Morgan%20Chase%20%26%20Co.%20Logo.png" alt="J.P. Morgan" width="200"/>
</p>

---

## 🚀 Project Overview

Midas Core is a Java-based Spring Boot application designed to process financial transactions. It listens for incoming transactions from a Kafka topic, validates them against business rules, persists them to a database, and integrates with an external service for calculating incentives. It also exposes a REST API to allow clients to query user account balances.

---

## 🏆 Key Features

- **Event-Driven Architecture**: Utilizes Apache Kafka to consume transaction events in real-time.
- **Database Integration**: Integrates with an in-memory H2 database using Spring Data JPA for transaction and user data persistence.
- **Transactional Integrity**: Ensures that transactions are processed atomically, with balance updates and record creation succeeding or failing together.
- **REST API Communication**:
    - **Incentives API**: Connects to an external REST service to fetch and apply incentives to transactions.
    - **Balance API**: Exposes a secure REST endpoint (`/balance`) for clients to query user balances.
- **Configuration Management**: Uses `application.yml` for managing application properties, including server ports and Kafka topics.
- **Comprehensive Testing**: Includes a suite of integration tests using Testcontainers and an embedded Kafka instance to validate each functional component.

---

## 🛠️ Technologies Used

- **Language**: Java 17
- **Framework**: Spring Boot 3.2.5
- **Build Tool**: Apache Maven
- **Core Components**:
    - Spring Web (for REST APIs)
    - Spring Data JPA (for database interaction)
    - Spring Kafka (for Kafka integration)
- **Database**: H2 (In-memory)
- **Testing**:
    - JUnit 5
    - Spring Boot Starter Test
    - Testcontainers (for Kafka)
    - Spring Kafka Test

---

## 📋 Completed Simulation Tasks

This project is the result of successfully completing five core software engineering tasks:

### 1️⃣ Project Setup
- Cloned the initial project scaffold from the repository.
- Configured the development environment to use Java 17.
- Added and configured all necessary dependencies in the `pom.xml`, including Spring Boot starters for Data JPA, Web, and Kafka, as well as the H2 database driver and testing libraries.

### 2️⃣ Kafka Integration
- Implemented a `TransactionListener` service to consume `Transaction` objects from a Kafka topic.
- Configured Kafka consumers and producers to correctly serialize and deserialize transaction data using JSON, ensuring seamless communication within the event stream.

### 3️⃣ H2 Database Integration
- Created `UserRecord` and `TransactionRecord` entities with appropriate JPA annotations and relationships.
- Implemented a `TransactionService` to handle the core business logic:
    - Validating transactions against user existence and sufficient funds.
    - Atomically updating sender and recipient balances.
    - Persisting valid transactions to the H2 database.

### 4️⃣ External REST API Integration
- Integrated the application with an external Incentives API.
- For each valid transaction, the system makes a POST request to the `/incentive` endpoint.
- The returned incentive amount is added to the recipient's balance and stored as part of the transaction record, demonstrating inter-service communication.

### 5️⃣ REST API Controller Implementation
- Developed a `BalanceController` to expose a public-facing REST API.
- The controller provides a `GET /balance` endpoint that accepts a `userId` and returns the user's current balance.
- The application was configured to run on a custom port (`33400`) as required.

---

## 🏃‍♂️ How to Run the Project

### Prerequisites
- Java 17
- Apache Maven

### 1. Build the Project
Navigate to the project's root directory and run the following Maven command to build the application:
```bash
./mvnw clean install
```

### 2. Run the Incentives API
The Incentives API is a required dependency for the application to be fully functional. It is provided as a JAR file in the `/services` directory. Open a new terminal and run:
```bash
java -jar services/transaction-incentive-api.jar
```
This will start the Incentives API on `http://localhost:8080`.

### 3. Run Midas Core
With the Incentives API running, open another terminal and start the main application:
```bash
java -jar target/midas-core-0.0.1-SNAPSHOT.jar
```
The Midas Core application will start and be accessible on `http://localhost:33400`.

---

## 🧪 How to Run Tests

To run the complete suite of integration tests, execute the following command from the project root:
```bash
./mvnw test
```

To run a specific test file (e.g., `TaskFiveTests`):
```bash
./mvnw test -Dtest=TaskFiveTests
```

---

## 📜 Certification

> **Software Engineering Job Simulation Certificate of Completion**<br/>
> Awarded by J.P. Morgan via Forage for successfully completing all simulation tasks.

---

<p align="center">
  <em>Developed as part of the J.P. Morgan Software Engineering Job Simulation on Forage.</em>
</p> 