# University Management System

## Project Overview

This project is a Spring Boot based University Management System developed for WM2 Lab8.

The system manages:
- Students
- Courses
- Enrollments
- Course prerequisites

The application follows microservice architecture using:
- student-service
- course-service

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradle
- Docker
- Swagger / OpenAPI

---

## Project Structure

```text
student-service/
course-service/
docker-compose.yml
build.gradle
```

---

## How to Run the Project

### 1. Clone Repository

```bash
git clone <your-repository-link>
cd lab8-GulnarHasanli
```

### 2. Start Docker Services

```bash
docker-compose up -d
```

### 3. Run Application

```bash
./gradlew bootRun
```

If permission issue occurs:

```bash
chmod +x gradlew
```

---

## Database

PostgreSQL database is used.

Database containers are started using Docker Compose.

---

## Swagger URL

After application starts:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Example Endpoints

### Get All Students

```http
GET /students
```

### Get All Courses

```http
GET /courses
```

### Enroll Student

```http
POST /enrollments
```

Example request body:

```json
{
  "studentId": 1,
  "courseId": 2
}
```

### Get Courses By Student Name

```http
GET /students/{name}/courses
```

---

## Features Implemented

- Enrollment date feature
- Course prerequisite validation
- Course retrieval by student name
- Swagger Azerbaijani documentation

---

## Important Notes

- Docker Desktop must be running before starting containers.
- PostgreSQL must be active before running Spring Boot application.
- Swagger is used for API testing and documentation.

---

## Git Commit Structure

1. Initial import of university system project
2. Add enrollment date feature
3. Add prerequisite validation for course enrollment
4. Add course retrieval by student name
5. Add Azerbaijani Swagger documentation