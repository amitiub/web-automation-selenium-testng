**Author: Amit Das**

This repository contains a **Web portal automation framework** built using **Selenium**, **Java**, **TestNG**, **Extent report**, and **Page Object Model (POM)**.

## Automation Exercise - Selenium + TestNG + Maven (POM + PageFactory)

This is a portfolio-ready web automation framework for the public demo site **Automation Exercise**:
https://automationexercise.com/

## Tech stack
- Java 17
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model + PageFactory
- Extent Reports (HTML) + screenshots on failure
- WebDriverManager for driver binaries

## Project structure
- `src/test/java/com/amit/portfolio/core` - driver, base test, waits, utilities
- `src/test/java/com/amit/portfolio/pages` - Page Objects
- `src/test/java/com/amit/portfolio/tests` - TestNG tests
- `src/test/resources/config.properties` - defaults
- `testng.xml` - suite runner

## How to run
From project root:

### Run all tests
```bash
mvn clean test
```

### Override parameters
```bash
mvn clean test -Dbrowser=chrome -Dheadless=true -DbaseUrl=https://automationexercise.com
```

## Reports
- Extent HTML report: `target/extent-reports/ExtentReport.html`
- Screenshots (failures): `target/screenshots/`

## Notes
- The demo site may occasionally show popups/banners; this framework includes safe checks to dismiss overlays when possible.
- If a locator becomes unstable (site updates), update the corresponding Page Object.


## Added test cases
- Navigation: open Test Cases page
- Products: search + open product details
- Products: add two products to cart
- Cart: remove item and verify empty
- Footer: subscribe and verify success
- Contact Us: submit form with file upload
- Auth: logout redirects to login

## Parallel execution (2 browsers)
This project includes a TestNG suite that runs the same tests in **two browsers in parallel** (Chrome + Edge):

```bash
mvn clean test -DsuiteXmlFile=testng-parallel-browsers.xml
```

Notes:
- Parallelization is at **TestNG <test> level** (`parallel="tests"`), one thread per browser.
- Driver is stored in a `ThreadLocal` to keep sessions isolated.


## Stability notes (ads / click interception)
AutomationExercise sometimes renders advertisement iframes (e.g. `aswift_*`) that can intercept clicks.
This framework includes `AdsUtil.hideAds()` + a `safeClick()` helper in `BasePage` to reduce flakiness.
