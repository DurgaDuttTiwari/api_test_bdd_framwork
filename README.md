# RestAssured BDD API Test Framework

This project is an API Test Automation framework built using **Java**, **RestAssured**, and **Cucumber/Reqnroll-style BDD**. It tests endpoints like [Beeceptor's Echo API](http://echo.free.beeceptor.com/) using human-readable Gherkin scenarios.

---

## 📦 Tech Stack

- **Java 24+**
- **RestAssured** for API testing
- **JUnit** as the test runner
- **Cucumber** / **Reqnroll (BDD)** for readable test scenarios
- **Maven** for project management

---

## 🧪 Features Covered

- ✅ GET and POST API validations
- ✅ Path, IP, and Headers validation
- ✅ Customer and order information parsing
- ✅ Payment and item-level field assertions
- ✅ Clean BDD scenario structure

---

## 📁 Project Structure
```
restassured-bdd-framework/ │ 
├── src/ 
│ └── test/ 
│       ├── java/ 
│       │    └──stepdefinitions/ # Step definitions for Gherkin steps
│       │         ├── EchoGetApiSteps # step def for Get Request
│       │         ├── EchoPostApiSteps #step def for POST Request
│       │         ├── UserSteps #step def for user 
│       │         └── TestRunners/ # Test runner classes 
│       └── resources/ 
│           ├── features/ # Gherkin feature files 
│           │     ├── echo_get_api.feature
│           │     ├── echo_post_api.feature
│           │     └── user.feature
│           └── Payloads/ # Post payload json
├── pom.xml # Maven dependencies and plugins 
├──.gitignore # Ignore it
└── README.md # Project documentation

```


---

## 🚀 How to Run the Tests

Make sure Java and Maven are installed.

```bash
# Clone the repo
git clone https://github.com/DurgaDuttTiwari/api_test_bdd_framwork.git

cd restassured-bdd-framework
```
# Run tests via Maven
```
mvn test
```
### 📝 Sample Scenario

```
Feature: Retrieve response and validate path, IP, and headers

  Scenario: Echo API GET request
    When I send a GET request to the echo API
    Then the response should include a valid path
    And the response should include an IP address
    And the response should include headers
```
### 📷 Sample Response (Mocked from Beeceptor)

```
{
  "method": "POST",
  "path": "/sample-request",
  "ip": "103.199.200.82:65496",
  "parsedBody": {
    "customer": {
      "name": "Jane Smith"
    },
    "items": [
      { "product_id": "A101" },
      { "product_id": "B202" }
    ],
    "payment": {
      "method": "credit_card"
    }
  }
}
```
### 💡 Notes
Make sure your Beeceptor endpoint is active and public

Customize the payloads and assertions per your API specs

### 📬 Contact
Feel free to reach out if you'd like to contribute or have suggestions!