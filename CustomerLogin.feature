Feature: Test login functionality of Customer

  Background: 
    Given The browser is open
    And User is on login page "https://phptravels.net/login"

  Scenario Outline: Check login is successful with valid credentials of Customer
    When User enters email as "<email>" and password as "<password>"
    And User click the login button
    Then page title is "Dashboard - PHPTRAVELS"
    Then click the logout button
    And close browser

    Examples: 
      | email               | password |
      | user@phptravels.com | demouser |

  Scenario Outline: Check login is unsuccessful with invalid credentials of Customer
    When User enters email as "<email>" and password as "<password>"
    And User click the login button
    Then page should display Wrong credentials. try again!
    And close browser

    Examples: 
      | email                  | password |
      | user001@phptravels.com | demouser |
      | user@phptravels.com    | 100user  |
      | user001@phptravels.com | 100user  |

  Scenario Outline: Check login is unsuccessful with blank credentials of Customer
    When User enters email as "<email>" and password as "<password>"
    And User click the login button
    Then page should display a tooltip message "Please fill out this field."
    And close browser

    Examples: 
      | email | password |
      |       |          |

  