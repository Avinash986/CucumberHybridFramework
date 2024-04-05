Feature: Search functionality

Scenario: User searches for a valid product
Given User open the application
When User enters valid product "HP" into search box field
And User clicks on search button
Then User should get display valid product in search result

Scenario: User searches for a invalid product
Given User open the application
When User enters invalid product "Honda" into search box field
And User clicks on search button
Then User should get message about no product matching

Scenario: User searches without any product
Given User open the application
When User not enter any product into search box field
And User clicks on search button
Then User should get message about no product matching
