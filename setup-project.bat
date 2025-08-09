@echo off
REM Grading Microservice Project Setup Script

echo Creating project structure...

REM Create directories
mkdir grading-microservice\src\main\java\com\university\grading\controller 2>nul
mkdir grading-microservice\src\main\java\com\university\grading\dto 2>nul
mkdir grading-microservice\src\main\java\com\university\grading\service 2>nul
mkdir grading-microservice\src\main\java\com\university\grading\exception 2>nul
mkdir grading-microservice\src\main\resources 2>nul
mkdir grading-microservice\src\test\java\com\university\grading\service 2>nul

cd grading-microservice

echo Project structure created successfully!
echo Now copy the individual files from the download page into their respective directories.
echo.
echo Quick start:
echo 1. Copy all files to their correct locations
echo 2. Run: mvn clean install
echo 3. Run: mvn spring-boot:run
echo 4. Open: http://localhost:8080/api/v1/grading/health

pause