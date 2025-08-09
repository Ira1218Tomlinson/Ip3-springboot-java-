# Grading Microservice

A Spring Boot microservice for calculating letter grades based on total points scored by students.

## Features

- RESTful API for grade calculation
- Input validation and error handling
- Support for both POST and GET requests
- Comprehensive unit tests
- Health check endpoint

## Grading Scale

| Points Range | Letter Grade | Description |
|-------------|--------------|-------------|
| 900-1000    | A            | Excellent   |
| 800-899     | B            | Good        |
| 700-799     | C            | Satisfactory|
| 0-699       | F            | Fail        |

## Prerequisites

1. **Java Development Kit (JDK) 17 or higher**
2. **Maven 3.6 or higher**
3. **IDE** (IntelliJ IDEA, Eclipse, VS Code, etc.)

## Running the Application

### Method 1: Using Maven
```bash
# Navigate to project directory
cd grading-microservice

# Download dependencies
mvn clean install

# Run the application
mvn spring-boot:run
```

### Method 2: Using IDE
1. Import the project into your IDE
2. Wait for dependencies to download
3. Run the `GradingMicroserviceApplication.java` main class

### Method 3: Using JAR file
```bash
# Build the JAR file
mvn clean package

# Run the JAR file
java -jar target/grading-microservice-0.0.1-SNAPSHOT.jar
```

## API Endpoints

### 1. Calculate Grade (POST)
```http
POST http://localhost:8080/api/v1/grading/calculate
Content-Type: application/json

{
    "totalPoints": 850
}
```

**Response:**
```json
{
    "totalPoints": 850,
    "letterGrade": "B",
    "description": "Good"
}
```

### 2. Calculate Grade (GET)
```http
GET http://localhost:8080/api/v1/grading/calculate?totalPoints=750
```

### 3. Health Check
```http
GET http://localhost:8080/api/v1/grading/health
```

## Testing the API

### Using cURL
```bash
# POST request
curl -X POST http://localhost:8080/api/v1/grading/calculate \
     -H "Content-Type: application/json" \
     -d '{"totalPoints": 950}'

# GET request
curl "http://localhost:8080/api/v1/grading/calculate?totalPoints=650"

# Health check
curl http://localhost:8080/api/v1/grading/health
```

## Running Tests

```bash
# Run all tests
mvn test

# Run tests with coverage
mvn test jacoco:report

# Run specific test class
mvn test -Dtest=GradingServiceTest
```

## Project Structure

```
grading-microservice/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── university/
│   │   │           └── grading/
│   │   │               ├── GradingMicroserviceApplication.java
│   │   │               ├── controller/
│   │   │               │   └── GradingController.java
│   │   │               ├── dto/
│   │   │               │   ├── GradeRequest.java
│   │   │               │   └── GradeResponse.java
│   │   │               ├── service/
│   │   │               │   └── GradingService.java
│   │   │               └── exception/
│   │   │                   └── GlobalExceptionHandler.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── university/
│                   └── grading/
│                       └── service/
│                           └── GradingServiceTest.java
```

## Support

For questions or issues:
1. Check the logs for error details
2. Verify all dependencies are properly installed
3. Ensure Java 17+ and Maven are correctly configured
4. Check that port 8080 is not already in use