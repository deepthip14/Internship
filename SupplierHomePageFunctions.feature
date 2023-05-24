Feature: Verify all functionalities in Supplier homepage

  Background: 
    Given The browser is open
    And User is on login page "https://phptravels.net/supplier"

  Scenario Outline: Verify the booking status is changed from  pending to confirmed of Supplier homepage
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    Then page title should be "DASHBOARD"
    And click the link Dashboard
    Then It navigates to dashboard page
    And click the link Bookings
    And It navigates to a page that showing an error message
    Then click logout
    And close browser

    Examples: 
      | email                   | password     |
      | supplier@phptravels.com | demosupplier |

  Scenario Outline: Verify the dashboard view and check the text "Sales overview and summary" of Supplier
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    Then page title should be "DASHBOARD"
    And click the link Dashboard
    Then It navigates to dashboard page
    And check the text "Sales overview & summary"
    Then click logout
    And close browser

    Examples: 
      | email                   | password     |
      | supplier@phptravels.com | demosupplier |

  Scenario Outline: Verify the modules functionality in Supplier homepage
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    Then page title should be "DASHBOARD"
    And click the link Bookings
    And It navigates to a page that showing an error message
    And click the module Tours
    And It navigates to Tours page
    And click the module Flights
    And It navigates to flights page
    And click the module visa
    And It navigates to visa page
    Then click logout
    And close browser

    Examples: 
      | email                   | password     |
      | supplier@phptravels.com | demosupplier |

  Scenario Outline: Verify the dashboard page should display the Revenue Breakdown of Supplier homepage
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    Then page title should be "DASHBOARD"
    And The home page should display the Revenue Breakdown
    Then click logout
    And close browser

    Examples: 
      | email                   | password     |
      | supplier@phptravels.com | demosupplier |
