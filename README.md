# Selenium Automation Framework

A robust UI Automation Testing Framework built using Java, Selenium WebDriver, Cucumber BDD, TestNG, Maven, and Page Object Model (POM).

## Project Overview

This framework automates login functionality of the Automation Exercise application and demonstrates industry-standard test automation practices using:

- Java
- Selenium WebDriver
- Cucumber BDD
- TestNG
- Maven
- Page Object Model (POM)
- WebDriverManager
- Log4j/SLF4J Logging

## Features

 Login with valid credentials

 Login with invalid credentials

 Cucumber BDD Scenarios

 Page Object Model Design Pattern

 Reusable Selenium Utilities

 Maven Dependency Management

 Detailed Logging

 Cross-browser support ready

## Technology Stack

| Technology | Version |
|------------|----------|
| Java | 17+ |
| Selenium WebDriver | Latest |
| Cucumber | Latest |
| TestNG | Latest |
| Maven | Latest |
| WebDriverManager | Latest |

## Project Structure

```text
automationexercise
│
├── src
│   ├── test
│   │   ├── java
│   │   │   ├── base
│   │   │   ├── hooks
│   │   │   ├── pages
│   │   │   ├── stepdefinitions
│   │   │   ├── runners
│   │   │   └── utils
│   │   │
│   │   └── resources
│   │       └── features
│   │           └── Login.feature
│
├── pom.xml
├── testng.xml
└── README.md
```

## Test Scenarios

### Scenario 1: Successful Login

```gherkin
Scenario: Verify successful login
Given user is on login page
When user enters valid username and password
Then user should be logged in successfully
And user should be able to logout
```

### Scenario 2: Invalid Login

```gherkin
Scenario: Verify login fails with invalid credentials
Given user is on login page
When user enters invalid username and password
Then login error message should be displayed
```

## Running the Tests

### Clone the Repository

```bash
git clone https://github.com/your-username/your-repository.git
```

### Navigate to Project

```bash
cd automationexercise
```

### Execute Tests

```bash
mvn clean test
```

Or run the TestNG Runner:

```bash
mvn test
```

## Test Results

Sample execution summary:

```text
Tests run: 2
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

## Design Patterns Used

### Page Object Model (POM)

Separates page locators and page actions from test scripts, making the framework:

- Maintainable
- Reusable
- Scalable

### BDD with Cucumber

Uses Gherkin syntax to improve collaboration between technical and non-technical stakeholders.

## Logging

Framework includes logging to track:

- Browser initialization
- Navigation
- User actions
- Test execution status

## Future Enhancements

- Extent Reports
- Parallel Execution
- Jenkins Integration
- CI/CD Pipeline
- Docker Support
- Cross Browser Testing
- Screenshot Capture on Failure

## Author

Pratiksha Bhabad
