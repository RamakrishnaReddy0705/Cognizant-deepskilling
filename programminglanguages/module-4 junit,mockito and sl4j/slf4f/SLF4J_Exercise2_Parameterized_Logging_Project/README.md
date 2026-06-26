
# Exercise 2 - Parameterized Logging using SLF4J

Objective:
Demonstrate parameterized logging using SLF4J placeholders {}.

Features:
1. INFO level parameterized logging
2. WARN level parameterized logging
3. DEBUG level parameterized logging
4. Logback configuration
5. Maven project structure
6. JUnit 5 testing

Build:
mvn clean test
mvn clean package

Run:
java -cp target/slf4j-exercise2-1.0.0.jar com.cognizant.logging.Application

Expected Output:

Employee Details -> Id: 101, Name: Ramakrishna,
Designation: Java Developer, Salary: 85000.0

Employee Ramakrishna salary is being processed for payroll
