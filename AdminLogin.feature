Feature: Test login functionality in Admin page

  Background: 
    Given The browser is open
    And User is on login page "https://phptravels.net/admin"

  Scenario Outline: Check login is successful with valid credentials of Admin
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    Then page title should be "DASHBOARD"
    And click logout
    And close browser

    Examples:  
      | email                | password  |
      | admin@phptravels.com | demoadmin |

  Scenario Outline: Check login is unsuccessful with invalid credentials of Admin
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    Then page should display invalid login credentials
    And close browser

    Examples: 
      | email                    | password  |
      | adminacd1@phptravels.com | demoadmin |
      | admin@phptravels.com     | admin234  |
      | admin12c@phptravels.com  | 234admin  |

  Scenario Outline: Check login is unsuccessful with blank credentials of Admin
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    Then page should display The Email field is required. The Password field is required.
    And close browser

    Examples: 
      | email | password |
      |       |          |

  