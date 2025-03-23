# Freelancer Management System – Backend

## Overview

This is a Spring Boot backend system for managing freelancer registration, project portfolios, and search functionality. The backend leverages PostgreSQL for data persistence and includes a RESTful API for managing freelancers and their projects.

---

## Features

✅ **User Management**

- Joined inheritance using the `@Inheritance` strategy:
  - **BaseUser** → Contains common attributes like `id`, `name`, `email`, and `password`.
  - **User** → Extends `BaseUser` with application-specific attributes.
  - **Freelancer** → Extends `User` and includes a `specialization` field (e.g., "Web Development", "Graphic Design").

✅ **Portfolio Management**

- **Project** entity linked to `Freelancer` with the following attributes:
  - `title` – Project name
  - `description` – Brief summary of the project
  - `technologiesUsed` – List of technologies used

✅ **Full-Text Search**

- PostgreSQL `tsvector` and `plainto_tsquery` enable searching by project title and technologies used.

✅ **RESTful API Endpoints**
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/register` | Register a freelancer |
| `POST` | `/portfolio/add` | Add a project to a freelancer's portfolio |
| `GET` | `/portfolio/search?query=` | Search for projects by title or technologies used |

---

## Tech Stack

- Java
- Spring Boot
- PostgreSQL
- Spring Data JPA
- Maven

---

## Setup

### Prerequisites

Ensure the following technologies are installed on your machine:

- ✅ **Java** → [Download](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- ✅ **Maven** → [Download](https://maven.apache.org/download.cgi)
- ✅ **PostgreSQL** → [Download](https://www.postgresql.org/download/)
- ✅ **Postman** (Optional, for testing API) → [Download](https://www.postman.com/downloads/)

---

## PostgreSQL Setup

1. Open the terminal in VS Code and log in to PostgreSQL
   ``` psql -U postgres```

🔐 You will be prompted for your PostgreSQL password.
Make sure to update the application.properties file accordingly.

2. List all databases
   ```\l```

3. Create the database (if it doesn't exist)
   ``` CREATE DATABASE freelancer_db;```

4. Connect to the database
   ``` \c freelancer_db```

5. Update your Spring Boot configuration (src/main/resources/application.properties)
   Replace 'your_actual_password' with your real password

```
spring.datasource.username=postgres
spring.datasource.password=your_actual_password
```

## 🚀 Running the Application

To start the Spring Boot application, run the following command:

```.\mvnw.cmd spring-boot:run```

## Postman Collection

You can test all API endpoints using the provided Postman collection:

📁 [`freelancer-management.postman_collection.json`](./freelancer-management.postman_collection.json)

To use it:
1. Open [Postman]
2. Click **Import**
3. Choose the `.json` file
