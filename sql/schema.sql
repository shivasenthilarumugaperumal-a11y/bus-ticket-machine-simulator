-- ============================================================
-- TNSTC Bus Ticket Machine - Database Schema
-- ============================================================

CREATE DATABASE IF NOT EXISTS bus_ticket_machine;
USE bus_ticket_machine;

CREATE TABLE bus (
    bus_id          INT PRIMARY KEY AUTO_INCREMENT,
    region_name     VARCHAR(100) NOT NULL,
    sub_region      VARCHAR(100),
    depot_name      VARCHAR(100) NOT NULL,
    service_number  VARCHAR(20)  NOT NULL,
    bus_category    ENUM('TOWN','MOFUSSIL') NOT NULL,
    bus_type        VARCHAR(50)  NOT NULL,
    vehicle_reg_no  VARCHAR(20)  NOT NULL,
    luggage_fare    DECIMAL(6,2) NOT NULL DEFAULT 10.00,
    ticket_class    VARCHAR(20)  NOT NULL
);

CREATE TABLE stage (
    stage_id            INT PRIMARY KEY AUTO_INCREMENT,
    bus_id              INT NOT NULL,
    stage_no            INT NOT NULL,
    stage_name          VARCHAR(100) NOT NULL,
    distance_from_origin DECIMAL(6,2) NOT NULL,
    FOREIGN KEY (bus_id) REFERENCES bus(bus_id) ON DELETE CASCADE,
    UNIQUE KEY uq_bus_stage (bus_id, stage_no)
);

CREATE TABLE fare_matrix (
    bus_id        INT NOT NULL,
    from_stage_no INT NOT NULL,
    to_stage_no   INT NOT NULL,
    fare          DECIMAL(6,2) NOT NULL,
    PRIMARY KEY (bus_id, from_stage_no, to_stage_no),
    FOREIGN KEY (bus_id) REFERENCES bus(bus_id) ON DELETE CASCADE,
    CHECK (from_stage_no < to_stage_no)
);

CREATE TABLE trip (
    trip_id               INT PRIMARY KEY AUTO_INCREMENT,
    bus_id                INT NOT NULL,
    trip_no               INT NOT NULL,
    direction              ENUM('UP','DN') NOT NULL,
    current_boarding_stage INT NOT NULL DEFAULT 1,
    start_time             DATETIME NOT NULL,
    end_time               DATETIME NULL,
    closed                 BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (bus_id) REFERENCES bus(bus_id)
);

CREATE TABLE ticket (
    ticket_id           INT PRIMARY KEY AUTO_INCREMENT,
    formatted_ticket_no VARCHAR(30) NOT NULL,
    trip_id              INT NOT NULL,
    boarding_stage_no    INT NOT NULL,
    alighting_stage_no   INT NOT NULL,
    adult                INT NOT NULL DEFAULT 0,
    children             INT NOT NULL DEFAULT 0,
    handicap             INT NOT NULL DEFAULT 0,
    transgender          INT NOT NULL DEFAULT 0,
    luggage              INT NOT NULL DEFAULT 0,
    distance_km          DECIMAL(6,2) NOT NULL,
    total_fare            DECIMAL(8,2) NOT NULL,
    payment_mode          ENUM('CASH','UPI') NOT NULL,
    issued_at             DATETIME NOT NULL,
    FOREIGN KEY (trip_id) REFERENCES trip(trip_id)
);