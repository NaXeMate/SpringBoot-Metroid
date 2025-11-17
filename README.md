# SpringBoot - Metroid

A Spring Boot REST API project that simulates Samus Aran's Power Suit upgrade management system across multiple planets from the Metroid universe.

## Overview
This application manages the Power Suit's upgrades, regional exploration data, and enemy encounters across three iconic planets: Zebes, SR388, and Tallon IV. The system tracks upgrade installations, compatibility requirements, regional locations, and combat statistics.

## Core Features
* **Power Suit Management:** Track suit configuration, energy status, and defense ratings.

* **Upgrade System:** Manage upgrades with prerequisite validation (displays "INCOMPATIBLE" when requirements aren't met).

* **Multi-Planet Regions:** Explore iconic Metroid locations, such as Zebes, SR388, and Tallon IV.

* **Enemy Database:** Register enemy encounters and combat statistics by region.

* **RESTful API:** Full CRRUD operations with calculated endpoints for advanced queries.

## Tech Stack
* Spring Boot

* Spring Data JPA

* MySQL Database

* Spring Web

## Key Entities
* **PowerSuit:** Central entity representing Samus' armor.

* **Upgrade:** Equipment improvements with compatibility checking.

* **Region:** Explorable areas across multiple planets.

* **Enemy:** Hostile creatures with combat statistics.

## Database Features
* Automatic schema generation on startup

* Data preloading from data.sql

* Multiple relationship types (1:N, N:M with/without additional data)

* Value Objects for complex data encapsulation

---

**Project Status:** In Early Development