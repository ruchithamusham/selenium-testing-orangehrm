# Selenium Login Tests for OrangeHRM

This is a small practice project where I automated the login page of the OrangeHRM demo website using Java and Selenium. I built it to learn how UI test automation works and to practice writing proper tests, not just scripts.

## What I used
- Java 21
- Selenium WebDriver 4
- TestNG
- Maven
- Chrome browser

## What the tests do
1. **Valid login:** logs in with the correct username and password, then checks that the dashboard page opens.
2. **Invalid login:** logs in with a wrong password, then checks that the "Invalid credentials" message appears.

## How the code is organized
I used the Page Object Model. This means the page actions (typing the username, typing the password, clicking login) are in one class, and the test logic is in another class.

- `src/main/java/orangehrmpages/LoginPage.java`: actions on the login page
- `src/test/java/orangehrmtests/LoginTest.java`: the test cases

## How to run it
1. Install Java 21, Maven and Chrome.
2. Clone this repository.
3. Run this command in the project folder:

   mvn test

The first run can take a few minutes, because Selenium downloads the Chrome driver automatically. After that, it runs much faster.

## What I learned
- How to write test cases with TestNG
- How to use assertions to check that a test passed or failed
- How to set up a project with Maven
- How to structure test code with the Page Object Model

The tests run on the public demo site: https://opensource-demo.orangehrmlive.com/
