# Employee Management API

A simple **Spring Boot REST API** for managing employees with **role-based access control** using Spring Security.  
Includes interactive API documentation with Swagger UI.

---

## 🚀 Features

- CRUD operations for employees
- Role-based access control:
    - **EMPLOYEE** → Read employee data
    - **MANAGER** → Create & Update employees
    - **ADMIN** → Delete employees
- In-memory authentication with predefined users
- Swagger UI integration for API testing
- Custom JSON error responses (401 Unauthorized, 404 Not Found, etc.)

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- H2 Database (or your configured DB)
- Swagger / OpenAPI 3

---

## 🔑 Authentication & Users

The API uses **Basic Authentication**.

| Username | Password | Roles                  |
|----------|----------|------------------------|
| john     | fun123   | EMPLOYEE               |
| mary     | fun123   | EMPLOYEE, MANAGER      |
| susan    | fun123   | EMPLOYEE, MANAGER, ADMIN |

---

## 📖 API Endpoints

| Method | Endpoint              | Role Required | Description                  |
|--------|------------------------|---------------|------------------------------|
| GET    | `/api/employees`      | EMPLOYEE      | Get all employees            |
| GET    | `/api/employees/{id}` | EMPLOYEE      | Get employee by ID           |
| POST   | `/api/employees`      | MANAGER       | Create new employee          |
| PUT    | `/api/employees/{id}` | MANAGER       | Update existing employee     |
| DELETE | `/api/employees/{id}` | ADMIN         | Delete employee by ID        |

---

## 📂 Project Structure
```
src/main/java/com/example/springboot/employees
│
├── controller         # REST controllers
├── dao                # Repositories / DAO layer
├── entity             # JPA entities
├── exception          # Custom exceptions
├── request            # Request DTOs
├── security           # Security configuration
└── service            # Service layer
```

---

## ▶️ Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/employee-management-api.git

cd employee-management-api

./mvnw spring-boot:run
```

### 2. Open the project in IntelliJ IDEA
- Launch IntelliJ IDEA.
- Click File > Open.
- Select the employee-management-api project folder.
- IntelliJ will automatically detect it as a Maven/Gradle project and download dependencies.


### 3. Build the project

- In IntelliJ, go to the menu bar and click Build > Build Project.
- Ensure there are no errors. 

### 4. Run the application
- Navigate to the main class:
```
src/main/java/com/example/springboot/employees/EmployeesApplication.java
```
- Right-click the file and select Run '**EmployeesApplication**'.
- IntelliJ will start the Spring Boot application on port **8080**.

### 5. Verify the application is running
  - Open your browser and go to the Swagger UI docs:
    - [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
  - You will see an interactive API documentation page.
  - From here, you can:
    1. Click on **Employee Rest API Endpoints**.
    2. Expand any operation (GET, POST, PUT, DELETE).
    3. Click **Try it out** to execute the request directly from Swagger UI.
    4. Enter one of the default usernames/passwords when prompted (see table below).

