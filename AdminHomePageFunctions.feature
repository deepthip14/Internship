Feature: Verify the functionalities in Admin homepage

  Background: 
    Given The browser is open
    And User is on login page "https://phptravels.net/admin"

  Scenario Outline: Verify the link functionality in Admin homepage
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    And page title should be "DASHBOARD"
    And click the Booking link
    And navigates to booking page
    And click paid Bookings
    And click the invoice where payment is successful
    And navigates to invoice page
    Then click logout
    And close browser

    Examples: 
      | email                | password  |
      | admin@phptravels.com | demoadmin |

  Scenario Outline: Verify the Change status from pending to confirmed in Admin page
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    And page title should be "DASHBOARD"
    And click the Booking link
    And navigates to booking page
    And click pending booking
    Then check the count of pending bookings before change status
    And change the booking status to confirmed
    And check the count of pending bookings after change status
    Then click logout
    And close browser

    Examples: 
      | email                | password  |
      | admin@phptravels.com | demoadmin |

  Scenario Outline: Verify the delete record functionality in Admin page
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    And page title should be "DASHBOARD"
    And click the Booking link
    And navigates to booking page
    And click cancelled bookings
    And check the count of cancelled booking before deleted
    And click delete button
    And check the count of cancelled booking after deleted
    Then click logout
    And close browser

    Examples: 
      | email                | password  |
      | admin@phptravels.com | demoadmin |

  Scenario Outline: Verify the link Website in homepage of Admin
    When User enters email as "<email>" and password as "<password>"
    And User click login button
    And page title should be "DASHBOARD"
    And click the Website link
    And navigates to website page
    Then click logout
    And close browser

    Examples: 
      | email                | password  |
      | admin@phptravels.com | demoadmin |
