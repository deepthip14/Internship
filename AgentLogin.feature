Feature: Test login functionality of Agent

  Background: 
    Given The browser is open
    And User is on login page "https://phptravels.net/login"

  Scenario Outline: Check login is successful with valid credentials of Agent
    When User enters email as "<email>" and password as "<password>"
    And User click the login button
    Then page title is "Dashboard - PHPTRAVELS"
    Then click the logout button
    And close browser

    Examples: 
      | email               | password |
      | agent@phptravels.com | demoagent |

  Scenario Outline: Check login is unsuccessful with invalid credentials of Agent
    When User enters email as "<email>" and password as "<password>"
    And User click the login button
    Then page should display Wrong credentials. try again!
    And close browser

    Examples: 
      | email                  | password |
      | agent23@phptravels.com | demoagent |
      | agent@phptravels.com   | 100agent  |
      | agent23@phptravels.com | 33agent  |

  Scenario Outline: Check login is unsuccessful with blank credentials of Agent
    When User enters email as "<email>" and password as "<password>"
    And User click the login button
    Then page should display a tooltip message "Please fill out this field."
    And close browser

    Examples: 
      | email | password |
      |       |          |

  