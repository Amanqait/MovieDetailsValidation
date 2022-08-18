--> Selenium project template
This project is written in java and will serve an example of implementing a Selenium test project with Selenium 3 and Maven. 

--> Pre-requisites
In order to use this framework, you need JDK 8 and Selenium install in your system.

No need to download chromedriver specifically, it will automatically use latest chromedriver from server.

--> Usage
To execute tests run = 'mvn clean test'
To execute single class = 'mvn test -Dtest="VerificationOfReleaseDateAndCountry_Test"'

--> Page Objects Pattern
Page object pattern is used to have reusable WebElements/small helper methods separated from actual test classes and give the opportunity to have nice structured and easily readable tests.