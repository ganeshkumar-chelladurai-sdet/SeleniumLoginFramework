# Selenium Login Framework

A Page Object Model automation framework testing the login flow at
[rahulshettyacademy.com/loginpagePractise](https://rahulshettyacademy.com/loginpagePractise/).

> Status: work in progress, being built part-by-part as a portfolio project.

## Tech Stack
- Java 17 (running on JDK 21)
- Selenium WebDriver 4.47.0
- TestNG 7.12.0
- WebDriverManager 6.3.4 (automatic driver binary management)
- Maven

## Design Pattern
Page Object Model (POM) with PageFactory.

## Architecture
`tests` calls methods on `pages` → `pages` calls the WebDriver instance
managed by `base` → `base` drives the actual browser (Chrome/Firefox/Edge).
`utils` and `config` support all layers but aren't part of the call chain.

## Folder Structure
```
src/test/java/
├── base/     # DriverFactory - creates and manages WebDriver
├── pages/    # Page Object classes (LoginPage, ConfirmationDialogPage)
├── utils/    # WaitUtils, ScreenshotUtils
├── config/   # ConfigReader, constants
└── tests/    # TestNG test classes (LoginTest)
```

## Naming Convention
- Page Object classes: `<PageName>Page.java`
- Test classes: `<Feature>Test.java`
- Utility classes: `<Purpose>Utils.java`
- Test methods: `test<WhatItVerifies>()`

## How to Run
```
mvn test
```