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

Additional implemented features:
- Enrollment date tracking
- Prerequisite validation during enrollment
- Course retrieval by student name
- Swagger/OpenAPI documentation in Azerbaijani

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradle
- Docker
- OpenFeign
- Swagger / OpenAPI

---

## Project Structure

```text
student-service/
course-service/
docker-compose.yml
build.gradle
````

---

## How to Run the Project

### 1. Clone Repository

```bash
git clone <your-repository-link>
cd lab8-GulnarHasanli
```

---

### 2. Start Database Services

Start PostgreSQL containers using Docker Compose:

```bash
docker-compose up -d
```

Make sure Docker Desktop is running before executing the command.

---

### 3. Run Applications

Run student-service:

```bash
cd student-service
./gradlew bootRun
```

Run course-service in another terminal:

```bash
cd course-service
./gradlew bootRun
```

If permission issue occurs:

```bash
chmod +x gradlew
```

---

## Database

PostgreSQL database is used.

Database containers are automatically started using Docker Compose.

---

## Swagger URLs

### Student Service Swagger

```text
http://localhost:8081/swagger-ui/index.html
```

### Course Service Swagger

```text
http://localhost:8082/swagger-ui/index.html
```

---

## How to Test Endpoints

Endpoints can be tested using:

* Swagger UI
* Postman
* cURL

---

## Example Requests

### Create Student

```http
POST /api/v1/students
```

Example request body:

```json
{
  "firstName": "Nicat",
  "lastName": "Aliyev",
  "email": "nicat.aliyev@example.com",
  "age": 20
}
```

---

### Get All Students

```http
GET /api/v1/students
```

---

### Search Students By Name

```http
GET /api/v1/students/search?name=Nicat
```

---

### Create Course

```http
POST /api/v1/courses
```

Example request body:

```json
{
  "title": "Data Structures",
  "code": "CS201",
  "credits": 4,
  "prerequisiteCourseId": null
}
```

---

### Get All Courses

```http
GET /api/v1/courses
```

---

### Get Courses By Student Name

```http
GET /api/v1/courses/by-student-name?name=Nicat
```

---

### Enroll Student Into Course

```http
POST /api/v1/courses/{courseId}/students/{studentId}
```

Example:

```http
POST /api/v1/courses/1/students/2
```

---

### Get Students In Course

```http
GET /api/v1/courses/{courseId}/students
```

---

## Features Implemented

* Enrollment date feature
* Course prerequisite validation
* Course retrieval by student name
* Azerbaijani Swagger documentation
* Custom exception handling
* Feign Client based inter-service communication

---

## Architecture Decisions

* Enrollment date is stored inside Enrollment entity.
* Course prerequisite information is stored inside Course entity.
* Student search functionality is exposed by student-service.
* Course retrieval by student name is handled by course-service using Feign Client communication.
* Prerequisite validation is handled inside course-service before enrollment.

---

## Error Handling

The system includes custom exception handling for:

* course not found
* student not found
* duplicate enrollment
* prerequisite validation failure
* student-service communication errors

---

## Important Notes

* Docker Desktop must be running before starting containers.
* PostgreSQL must be active before running Spring Boot applications.
* Swagger is used for API testing and documentation.
* Both services must run simultaneously for inter-service communication.
* The project uses microservice architecture with separate services for students and courses.

---

## Git Commit Structure

1. Initial import of university system project
2. Add Azerbaijani Swagger documentation
3. Add enrollment date feature
4. Add prerequisite validation during enrollment
5. Add course retrieval by student name


