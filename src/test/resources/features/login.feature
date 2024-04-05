Feature: login functionality

Scenario Outline: Login with valid credentials
Given User navigate to login page
When User has enter valid email address <username> into email field
And User has enter valid password into <password> password field
And User clicks on login button
Then User should get logged in
Examples:
|username|password|
|avinash.doifode@gmai.com|123456|
|avinash.123@gmail.com   |121212|
|avinash.1234@gmail.com  |111111|

Scenario: Login with invalid credentials

Given User navigate to login page
When User enter invalid email address into email field
And User enter invalid password "abcd123" into password field
And User clicks on login button
Then User should get proper warning message

Scenario: Login with valid email and invalid password
Given User navigate to login page
When User has enter valid email address "avinash.doifode@gmail.com" into email field
And User enter invalid password "abcd123" into password field
And User clicks on login button
Then User should get proper warning message

Scenario: Login with invalid email and valid password
Given User navigate to login page
When User enter invalid password "abcd123" into password field
And User has enter valid password "123456" into password field
And User clicks on login button
Then User should get proper warning message

Scenario: Login without providing credential
Given User navigate to login page
When User not enter email address into email field
And User not enter password into password field
And User clicks on login button
Then User should get proper warning message

