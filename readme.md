# Automation Web Testing Framework (Selenium + TestNG)
---

## 👤 Author

**Amit Kumar Das**  
Automation Solution Architect/Consultant  

---

## 📌 Project Overview
This project is a **web automation testing framework** built using **Selenium WebDriver**, **TestNG**, and **Maven**, following the **Page Object Model (POM)** design pattern.

The framework is designed to automate functional test scenarios for the website:
**https://automationexercise.com/**

It focuses on:
- Maintainability
- Reusability
- Scalability
- Clear separation of test logic and page interactions

---

## 🧰 Tech Stack

| Component | Technology |
|--------|-----------|
| Language | Java |
| Automation Tool | Selenium WebDriver |
| Test Framework | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model (POM) |
| Browser Management | WebDriverManager |
| Reporting | Extent Reports |
| IDE | IntelliJ IDEA / Eclipse |

---

## 📁 Project Structure

```
automation-web-selenium-testng
│
├── pom.xml
├── testng.xml
└── src
    └── test
        └── java
            ├── pages
            │   ├── HomePage.java
            │   ├── ProductsPage.java
            │   ├── CartPage.java
            │   ├── SignupLoginPage.java
            │   ├── AccountInformationPage.java
            │   ├── AccountCreatedPage.java
            │   └── LoggedInHomePage.java
            │
            ├── tests
            │   ├── BaseTest.java
            │   ├── RegistrationTests.java
            |   ├── LoginTests
            │   ├── ProductsTests.java
            │   ├── CartTests.java
            │   └── SubscriptionTests.java
            │
            └── utils
                ├── DriverManager.java
                ├── ExtentManager.java
                └── AdHandler.java
```

---

## 🧩 Key Components Explained

### 📄 Pages Package
Contains all **Page Object classes**, each representing a web page and its elements & actions.

### 🧪 Tests Package
Contains TestNG test classes with test scenarios.
- `BaseTest` handles common setup and teardown
- Other classes focus on specific features (registration, cart, products, etc.)

### 🛠 Utils Package
Reusable utilities:
- **DriverManager** – WebDriver initialization & cleanup
- **ExtentManager** – Extent report configuration
- **AdHandler** – Handles pop-ups/ads if present

---

## ⚙️ Prerequisites

Ensure the following are installed:
- Java JDK 8 or higher
- Maven 3.6+
- Google Chrome (latest)
- IntelliJ IDEA / Eclipse (optional but recommended)

---

## 🔧 Setup Instructions

1. **Clone or extract the project**
2. Open terminal in project root
3. Verify Maven installation:
   ```bash
   mvn -version
   ```
4. Download dependencies:
   ```bash
   mvn clean install
   ```

---

## ▶️ How to Run Tests

### ✅ Run All Tests
```bash
mvn clean test
```

### ✅ Run Using TestNG XML
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### ✅ Run from IDE
- Open `testng.xml`
- Right-click → **Run**

---

## 🌐 Browser Configuration

- Default browser: **Chrome**
- Driver handled automatically using **WebDriverManager**
- Browser setup logic is located in `DriverManager.java`

---

## 📊 Reports

- Extent Reports are generated after test execution
- Report location:
  ```
  /test-output/ExtentReport.html
  ```
- Open the report in a browser to view execution details, screenshots, and logs

---

## ❗ Common Issues & Fixes

### Chrome version mismatch
- Ensure Chrome is up to date
- WebDriverManager resolves most issues automatically

### TestNG parallel warning
- Update `parallel="false"` to `parallel="none"` in `testng.xml`

### Ads / popups
- Handled via `AdHandler` utility

---

## 🚀 Future Enhancements

- Add data-driven testing (Excel / JSON)
- Cross-browser support (Firefox, Edge)
- CI/CD integration (GitHub Actions / Jenkins)
- Docker execution
- Allure reporting
- Environment-based execution (QA / UAT / PROD)

---

## 📜 License

This project is intended for learning, POC, and demonstration purposes.

## 📄 Test Report (ExtentReport)
<img width="1164" height="710" alt="image" src="https://github.com/user-attachments/assets/f9934a7c-3f07-4895-bc8a-046b7ea8551c" />


