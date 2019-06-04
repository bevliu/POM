# POM
Using Selenium WebDriver and TestNG framework and Maven dependency

Page Object Model (Page Chaining Model)

Design pattern approach
Data Driven Framework
TestNG
pages

Page Layer (Page Lib)
LoginPage -- WebObjects/WebElements -- Actions/Methods(features)

HomePage

RegistrationPage -- clickOnSignInLink(); fillReqForm(); checkLogo(); footerLink() SearchPage AddToCartPage PaymentPage

test

Test Layer - TestNG -- annotations LogInPageTest.java HomePageTeat.java RegPageTest.java
base

There is a java parent class TestBase.java (WebDriver dr = new ChromeDriver()) connecting 1 and 2. maximizeWindow() - pageloadTimePut() - impiciWait() - deleteAllCookies() - get(url)
config

Envornment Vars Config.properties - URL - UserName - Password - Browser
testdata

TestData.xlsx
util

TestUtil.java Screenshot - sendMail() - commonUtil() - Generic Functions
test-output/reports

Test Reports: Pass/Fail HTML - TestNG - XML reports - Extent reports
Java

Selenium WenDriver

TestNG

Maven

Apache POI API

Extent Report/TestNG report

Log4j API

Jenkins - CI

GIT - Repo

GRID - Parallel Testing

Browsers - FF/Chrome/IE

Mac/Windows/Linux

VMs/SourceLabs/BrowseStack/Local
