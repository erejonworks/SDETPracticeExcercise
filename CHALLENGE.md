🧪 SDET Jr Practice Exercise (Java + Selenium)

This is a realistic technical assessment-style exercise designed to force you to use:

Collections

Streams

Lambdas

Threads / Concurrency

Page Object Model (POM)

HashMaps

Explicit Waits

🌐 Suggested Test Website
Primary option

The Internet
https://the-internet.herokuapp.com/

Use it for:

Login

Dynamic Loading

Dynamic Controls

Tables

Dropdowns

Alerts

Checkboxes

👉 Demo credentials:

username: tomsmith

password: SuperSecretPassword!

Secondary option

Automation Exercise
https://automationexercise.com/

Use it for:

E-commerce flows

More realistic UI

End-to-end scenarios

🎯 Objective

Build a mini automation framework in Java that:

follows Page Object Model (POM)

uses Selenium WebDriver

implements explicit waits

processes data using Collections + Streams + Lambdas

uses HashMap

runs tests in parallel safely

demonstrates clean architecture and design thinking

🏗️ 1) Framework Structure

Create a Maven project with a structure like:

src
├── main
│   └── java
│       ├── base
│       │   ├── BasePage.java
│       │   ├── DriverFactory.java
│       │   └── WaitHelper.java
│       ├── pages
│       │   ├── LoginPage.java
│       │   ├── SecureAreaPage.java
│       │   ├── DynamicLoadingPage.java
│       │   ├── DropdownPage.java
│       │   └── TablesPage.java
│       ├── model
│       │   └── UserData.java
│       └── utils
│           ├── TestDataFactory.java
│           ├── TableUtils.java
│           └── ConfigReader.java
└── test
└── java
├── tests
│   ├── LoginTest.java
│   ├── DynamicLoadingTest.java
│   ├── DropdownTest.java
│   ├── TablesTest.java
│   └── ParallelSmokeTest.java
└── data
└── TestUsers.java
What interviewers expect

separation of concerns

reusability

clean structure

scalability

📄 2) Implement POM for These Flows
A. Successful Login

Navigate to login page

Enter credentials

Click login

Validate success

B. Failed Login

Validate error message

Ensure user is NOT logged in

C. Dynamic Loading / Dynamic Controls

Wait for elements to appear or change state

Validate final content

D. Dropdown

Select by:

visible text

value

index

E. Tables

Extract:

last name

first name

email

due amount

📦 3) Collections Requirement

Use at least:

List
List<UserData> users;
Set
Set<String> uniqueEmails;
Map / HashMap
Map<String, String> envConfig;
Map<String, UserData> usersByRole;
Map<String, Double> debtByEmail;
Interview questions you should expect

Why List vs Set?

Why HashMap?

Time complexity of HashMap?

What if key is mutable?

⚡ 4) Streams & Lambdas Requirement

Using table data:

A. Convert emails to lowercase
List<String> emailsLowercase;
B. Filter users with debt > 50
List<TableUser> highDebtUsers;
C. Sort by last name
List<TableUser> sortedByLastName;
D. Map email → debt
Map<String, Double> debtByEmail;
E. Check if any Hotmail user exists
boolean hasHotmail;
F. Total debt
double totalDebt;
Concepts covered

map

filter

sorted

collect

anyMatch

reduce

⏳ 5) Waits Requirement

Create a WaitHelper class:

waitForVisibility(By locator);
waitForClickable(By locator);
waitForText(By locator, String text);
waitForInvisibility(By locator);
waitForPresence(By locator);
Rules

Prefer explicit waits

Avoid Thread.sleep()

Do NOT mix waits randomly

🧵 6) Threads / Concurrency Requirement

Run tests in parallel.

Must use:
ThreadLocal<WebDriver>
Each thread must:

create its own driver

use its own driver

close its own driver

Concepts being tested

race conditions

test interference

thread safety

🗺️ 7) HashMap Requirement

Organize test users by role:

Map<String, UserData> usersByRole;
Tasks

retrieve user by role

validate role existence

iterate roles

convert map to list using streams

Bonus interview discussion

HashMap vs LinkedHashMap

collisions

equals/hashCode contract

🧱 8) Framework Design Requirements
BasePage

Reusable methods:

click

type

getText

isDisplayed

select

navigate

DriverFactory

initialize driver

manage browsers

handle ThreadLocal

teardown

ConfigReader

baseUrl

browser

timeout

TestDataFactory

valid users

invalid users

edge cases

Page Objects

one class per page

no heavy assertions inside

✅ 9) Test Cases
Test 1 – Successful Login

Validate:

navigation

success message

redirect

Test 2 – Failed Login

Validate:

error message

user not authenticated

Test 3 – Dropdown

Validate:

selection methods

selected value

Test 4 – Tables

Validate:

rows exist

no duplicate emails

total debt

users with debt > 50

Test 5 – Dynamic Content

Validate:

proper waiting

correct text

Test 6 – Parallel Execution

Validate:

tests run in parallel

no shared driver

no interference

🚀 10) Bonus (High-Value in Interviews)
A. DataProvider (TestNG)

Multiple login cases

B. Retry logic

Handle flaky tests

C. Screenshots on failure
D. Logging with thread name
Thread.currentThread().getName();
E. Reports (Allure / Extent)
🧠 11) Theory Questions You Should Practice
Java / Collections

List vs Set vs Map

HashMap complexity

equals vs hashCode

Streams

map vs filter

collect vs reduce

when NOT to use streams

Selenium

implicit vs explicit waits

flakiness

dynamic elements

Concurrency

why WebDriver is not thread-safe

what ThreadLocal solves

Framework Design

why POM

what NOT to put in page objects

📌 12) Final Interview-Style Statement
Technical Challenge – QA Automation / SDET Jr

Build a Java Selenium framework using POM to automate tests on a public practice site.

Requirements

Login (valid & invalid)

Dropdown

Tables

Dynamic content

Parallel execution

Must use

Collections

Streams

Lambdas

HashMap

Threads

Explicit waits

Deliverables

GitHub repo

README

architecture explanation

improvement ideas

📊 13) Evaluation Criteria
Strong candidates

clean structure

proper waits

thread-safe execution

readable code

Weak signals

Thread.sleep everywhere

shared driver

poor separation of concerns

🧭 14) Recommended Implementation Order

DriverFactory

BasePage + WaitHelper

Login tests

Dropdown

Tables + Streams

Parallel execution

README

🔥 15) Final Challenge

From table data, compute using Streams:

total users

total debt

average debt

max debt user

sorted unique emails