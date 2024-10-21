# College Departments API

This project is part of my **Spring Boot course** (Week 2), where I learned about building web applications using **Spring MVC** and **REST APIs**. The application focuses on managing the **Departments** of a college, allowing for operations like creating, reading, updating, and deleting departments (CRUD functionality).

## Project Overview

In this project, I have implemented:
- **Presentation Layer**: Managed through controllers, DTOs (Data Transfer Objects), and services to handle requests and responses.
- **Business Logic**: Encapsulated in the service layer, with proper separation of concerns from the persistence layer.
- **Persistence Layer**: Managed using **JPA Repository** to interact with the database.
- **Validation**: Implemented validation annotations to ensure data integrity during create/update operations.
- **Exception Handling**: Robust error handling with meaningful messages and **production-ready status codes**.
- **API Response Formatting**: API responses are structured in a format that makes it easier for frontend integration.

## Key Features
- **CRUD Operations**: You can create, retrieve, update, and delete department records.
- **Spring MVC**: Used for handling HTTP requests and routing.
- **REST API**: Built using REST principles for easy interaction with other services or a frontend.
- **Validation Annotations**: Ensures valid input data before processing (e.g., `@NotNull`, `@Size`).
- **Exception Handling**: Managed via custom exceptions and global handlers, providing clear and descriptive error responses.
- **Status Codes**: Appropriate HTTP status codes (e.g., 200, 201, 400, 404, 500) are used to represent the outcome of operations.

## Layers Overview
1. **Presentation Layer**: Controllers handle incoming requests and map them to services.
2. **DTO Layer**: Used to decouple the API from the internal model structure.
3. **Service Layer**: Contains business logic and communicates with the persistence layer.
4. **Persistence Layer**: JPA repository interfaces handle CRUD operations with the database.

## Technologies Used
- **Java 23**
- **Spring Boot** (Spring MVC, REST API)
- **JPA (Java Persistence API)** for database interaction
- **h2 (In-memory database)
- **Maven** for project management
- **Postman** for API testing

## API Documentation

For detailed API documentation, visit [Alaap Documentation](https://documenter.getpostman.com/view/30415721/2sAXxY48ih).

## How to Run

1. **Clone the Repository**:
    ```bash
    git clone <https://github.com/rupal-draft/Springboot-MVC-and-Restful-API.git>
    ```

2. **Navigate to the Project Directory**:
    ```bash
    cd springboot-college-departments
    ```

3. **Run the Application**:
    ```bash
    ./mvnw spring-boot:run
    ```

4. The application will be running at `http://localhost:8080/departments`.

## Example API Endpoints

- **GET /departments**: Get a list of all departments.
- **GET /departments/{id}**: Get details of a specific department by ID.
- **POST /departments**: Create a new department (with validation).
- **PUT /departments/{id}**: Update an existing department.
- **PATCH /departments/{id}**: Partial update an existing department.
- **DELETE /departments/{id}**: Delete a department by ID.

## Validation
The following validation annotations are used:
- `@NotBlank`: Ensures that a field is not blank.
- `@Size`: Enforces size constraints on string fields.

## Exception Handling
The project has robust exception handling:
- Custom exceptions for resource not found, invalid input, etc.
- Global exception handler to catch and format errors with relevant status codes.

