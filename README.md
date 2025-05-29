# 🏛️ Department Management System - Day10 (2025-05-23)

## 🏷️ Department Management Service

A Spring Boot REST API service for managing department information with comprehensive error handling and JPA integration.

---

## 📋 Overview

This service provides CRUD operations for department management with built-in exception handling and data validation. It's designed for educational institutions or organizations that need to manage departmental information and employee associations.

---

## 🏗 Architecture

The application follows a layered architecture pattern:

- **Model Layer**: JPA entities with proper relationships  
- **Repository Layer**: Spring Data JPA repositories  
- **Service Layer**: Business logic implementation  
- **Exception Handler**: Centralized error handling  

---

## ✨ Features

### ✔️ Department CRUD Operations

- Retrieve all departments  
- Get department by ID  
- Add new departments with duplicate validation  
- Update existing departments  
- Delete departments  

### ✔️ Robust Error Handling

- Entity not found exceptions  
- Duplicate key validation  
- Generic exception handling  
- Structured error responses  

### ✔️ Data Validation

- Unique department ID enforcement  
- Required field validation  
- Proper HTTP status codes  

---

## 🔗 API Endpoints

---

### 📄 Get All Departments

```

GET /api/departments

````

**Response (200 OK):**

![1 get all departments output](https://github.com/user-attachments/assets/36fbc179-8cd5-42a5-ac6c-e2bea116e0b9)

---

### 🔍 Get Department by ID

```
GET /api/departments/{id}
```

**Response (200 OK):**

![2 get department by id output](https://github.com/user-attachments/assets/4a158915-2154-4343-a57a-57b97a24fb22)

**Error Response (404 Not Found):**

![3 error response output](https://github.com/user-attachments/assets/346024ed-df19-47b5-93ff-604dbaee826c)

---

### ➕ Add New Department

```
POST /api/departments
```

**Response (201 Created):**

![4 add new department output](https://github.com/user-attachments/assets/f237bf3d-fe94-4c80-8ece-1c9af444ac8e)

**Error Response (400 Bad Request) - Duplicate ID:**

![5 duplicate error output](https://github.com/user-attachments/assets/2830f5a9-7655-4c20-b5fb-e64dc8a7cc55)

---

### ✏️ Update Department

```
PUT /api/departments/{id}
```

**Response (200 OK):**

![6 update output](https://github.com/user-attachments/assets/ba2df538-2655-4e27-8b2f-b72fa2973af6)


---

### 🗑️ Delete Department

```
DELETE /api/departments/{id}
```

**Response (200 OK):**

![7 delete output](https://github.com/user-attachments/assets/da3cb44b-d90f-4e14-b428-2814f60b6a1e)

**Error Response (404 Not Found):**

![8 to delete not found output](https://github.com/user-attachments/assets/5038be15-c4b3-4518-80f0-17bcc7637809)

---

## 📊 Data Model

### ⚠️ Error Response Model

* `statusCode` (Integer): HTTP status code
* `errorMessage` (String): Descriptive error message

---

## 🛠 Technology Stack

* **Framework**: Spring Boot
* **ORM**: Spring Data JPA / Hibernate
* **Database**: JPA-compatible (MySQL, PostgreSQL, H2, etc.)
* **Exception Handling**: Spring Boot's `@RestControllerAdvice`
* **Validation**: Custom business logic validation

---

## 🚨 Exception Handling

| Exception Type            | HTTP Status | Description             |
| ------------------------- | ----------- | ----------------------- |
| `EntityNotFoundException` | 404         | Department not found    |
| `DuplicateKeyException`   | 400         | Duplicate department ID |
| `Exception`               | 500         | Generic server errors   |

---

## 🚀 Getting Started

### ✅ Prerequisites

* Java 17 or higher
* Spring Boot 3.x
* JPA-compatible database

### ⚙️ Configuration

Update your `application.properties` with database configuration:

```properties
# Database Configuration
spring.application.name=employeeapp
spring.datasource.url=jdbc:mysql://localhost:3306/employee
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```
---

## 🧠 Business Logic

### ➕ Department Addition

* Validates department ID uniqueness
* Throws `DuplicateKeyException` if ID exists
* Saves department to database
* Returns success message

### 🔍 Department Retrieval

* Checks if department exists by ID
* Throws `EntityNotFoundException` if not found
* Returns department data

### ✏️ Department Update

* Checks if department exists
* Throws `EntityNotFoundException` if missing
* Saves updated department data
* Returns update confirmation

### 🗑️ Department Deletion

* Checks if department exists
* Throws `EntityNotFoundException` if missing
* Deletes department record
* Returns deletion confirmation

---

## 📤 Error Response Format

All errors follow a consistent JSON structure:

```json
{
  "statusCode": <HTTP_STATUS_CODE>,
  "errorMessage": "<DESCRIPTIVE_MESSAGE>"
}
```

---

## 📄 License

This project is part of an academic curriculum.
