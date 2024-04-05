Feature: Registration functionality

Scenario: User create account with only mandatory field
Given User navigates to Register Account page
When User enters the details into below fields
|firstName|  Avinash                  |
|lastName |  Doifode                  |

|telephone|  1234567890               |
|password |  123456                   |
And User select Private Policy
And User clicks on Continue Button
Then User account should get create sucessfully


Scenario: User create account with all field
Given User navigates to Register Account page
When User enters the details into below fields
|firstName|  Avinash                  |
|lastName |  Doifode                  |

|telephone|  1234567890               |
|password |  123456                   |
And User selects Yes for Newsletter           
And User select Private Policy
And User clicks on Continue Button
Then User account should get create sucessfully

Scenario: User create account with duplicate account
Given User navigates to Register Account page
When User enters the details into below fields with duplicate email
|firstName|  Avinash                  |
|lastName |  Doifode                  |
|email    |  avinash.doifode@gmail.com|
|telephone|  1234567890               |
|password |  123456                   |
And User selects Yes for Newsletter           
And User select Private Policy
And User clicks on Continue Button
Then User account should get proper warning about duplicate email

Scenario: User create an account without providing any details
Given User navigates to Register Account page
When User not enter any details into field
And User clicks on Continue Button
Then User should get proper warning message for every mandatory field

