# Bus Ticket Management Simulator

A Java-based desktop/console application for searching routes, checking ticket fares, and managing bus reservation schedules backed by a relational MySQL database. Developed as part of the Object-Oriented Software Engineering coursework.

---

## 📌 Project Overview

This project provides an automated system for handling inter-city bus route schedules, stage-wise fare matrices, and ticket booking details. It uses a relational database schema to maintain entity relationships between buses, routes, fare stages, and passenger reservations.

### Key Features
* **Bus & Route Lookup:** Search available buses across regional destinations and fare stages.
* **Dynamic Fare Calculation:** Query stage-to-stage pricing matrix stored in MySQL.
* **Database Management:** Pre-configured SQL schema and automated sample data seeding.
* **Cross-Platform Execution:** Automated shell scripts for building and testing database connectivity.

---

## 🛠️ Tech Stack Used

* **Programming Language:** Java (JDK 17 or higher)
* **Database:** MySQL Server 8.0+ / 9.0+
* **IDE/Tools:** VS Code / Eclipse / IntelliJ IDEA, MySQL Workbench
* **Database Connector:** MySQL Connector/J (`mysql-connector-j-26.7.0.jar`)

---

## 📂 Project Structure

```text
├── src/                      # Java source code files (.java)
├── schema.sql                # DDL script creating database tables and relations
├── sample_data.sql           # DML script seeding initial route and fare data
├── build.sh                  # Shell script to compile Java source code
├── run.sh                    # Shell script to launch the application
├── test-db.sh                # Script to verify MySQL connection and queries
└── README.md                 # Project documentation
