# Spring Boot REST API Practice

This repository contains my Spring Boot practice code where I implemented RESTful APIs using best practices such as DTOs, validation, and layered architecture.

## Features
- RESTful API design
- CRUD operations
- DTO pattern
- ModelMapper usage
- Validation using @Valid and Bean Validation
- HTTP methods: GET, POST, PUT, PATCH, DELETE
- Exception handling (basic)

## Tech Stack
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- ModelMapper
- Bean Validation
- H2 / MySQL
- Maven

## Project Structure
src/main/java
├── controller
├── service
├── repository
├── model (entity)
├── dto
├── exception
└── config

## API Endpoints
- GET    /students
- GET    /students/{id}
- POST   /students
- PUT    /students/{id}
- PATCH  /students/{id}
- DELETE /students/{id}

## How to Run
1. Clone the repository
2. Import into IntelliJ / Eclipse / STS
3. Run the main Spring Boot application
4. Test APIs using Postman

