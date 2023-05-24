Feature: Test login functionality of Supplier

  Background: 
    Given The browser is open
    Then User is on login page "https://phptravels.net/supplier"

  Scenario Outline: Check login is successful with valid credentials of Supplier
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    Then page title should be "DASHBOARD"
    Then click logout
    And close browser

    Examples: 
      | email                   | password     |
      | supplier@phptravels.com | demosupplier |

  Scenario Outline: Check login is unsuccessful with invalid credentials of Supplier
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    Then page should display invalid login credentials
    And close browser

    Examples: 
      | email                      | password     |
      | supplier123@phptravels.com | demosupplier |
      | supplier@phptravels.com    | 123supplier  |
      | supplier123@phptravels.com | 123supplier  |

  Scenario Outline: Check login is unsuccessful with blank credentials of Supplier
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    Then page should display The Email field is required. The Password field is required.
    And close browser

    Examples: 
      | email | password |
      |       |          |

  