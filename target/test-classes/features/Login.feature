Feature: Login Functionality
//below tags can be add to feature because there can be multiple  Scenario
// login is Functionality and smoke and regression are test type

@smoke @login
Scenario: verify user can login with valid credentials
Given user is on login page
When user enters valid "<email>" and "<password>"
Then user should be logged in successfully
And user should be able to logout

Examples:
| email | password |
| j123@gmail.com |123456 |

@regression @login
Scenario:verify login fails with invalid credentials
Given user is on login page
When user enters invalid username and password
Then login error message should be displayed


