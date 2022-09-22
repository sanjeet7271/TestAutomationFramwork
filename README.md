# BDD Test Automation Framework( Backend Test Challenges )

## Features supported
1. Dependency management and project management by using MAVEN 
2. API Testing using Rest Assured Library
3. Junit for testing workflow
4. Granular commits with git
5. Logging via Log4j
6. Property Reader to read Test data from properties files.
7. Clear, maintainable code
8. Leverage Singleton design pattern


## Pre-requisite
1. JDK version above 1.8.
2. Maven version above 3.0


## How to install & Run using command prompt
1. Please extract the project from jar file at your desired path.
2. Go to `/src/test/resources/feature`, we can run individual file on right click -> maven-> Junit <br>
3. Go to `/src/test/java/com/stepdefinition`, we can run all test case from TestRunner.java file=>  right click -> maven-> Junit. <br>
4. Open `/TestAutomationFramework/` and open cmd in this locaion and type in command "mvn test"<br>

## To view Report 
1. Open project and got to: `/target/cucumber-report/cucumber.html`
2. Check logs also :`/TestAutomationFramework/`
3. Added word file to run project with screenshot