Feature: Verify all functions in Customer homepage

  Background: 
    Given The browser is open
    And User is on login page "https://phptravels.net/login"

  Scenario Outline: Verify the link Functionality of Customer
  When User enters email as "<email>" and password as "<password>"
  And User click the login button
  Then page title is "Dashboard - PHPTRAVELS"
  And User click the Booking link
  And User navigates to booking page
  And User click the Add Funds link
  And User navigates to Add Funds page
  And User click the My Profile link
  And User navigates to My Profile page
  Then click the logout link
  And close browser
  
  Examples:
  | email               | password |
  | user@phptravels.com | demouser |
  
  Scenario Outline: Verify the display voucher Functionality of Customer
  When User enters email as "<email>" and password as "<password>"
  And User click the login button
  And page title is "Dashboard - PHPTRAVELS"
  And User click the Booking link
  And User navigates to booking page
  And click view voucher
  And User should navigates to voucher page
  Then click the logout button
  And close browser
  
  Examples:
  | email               | password |
  | user@phptravels.com | demouser |
  
  Scenario Outline: Verify the payment with Paypal Functionality of Customer
  When User enters email as "<email>" and password as "<password>"
  And User click the login button
  And page title is "Dashboard - PHPTRAVELS"
  And User click the Add Funds link
  And User navigates to Add Funds page
  And Select payment with Paypal
  And Click Pay Now button
  And Click PayPal
  Then click the logout button
  And close browser
  
  Examples:
  | email               | password |
  | user@phptravels.com | demouser |
  Scenario Outline: Verify the update address in My Profile of Customer
    When User enters email as "user@phptravels.com" and password as "demouser"
    And User click the login button
    And page title is "Dashboard - PHPTRAVELS"
    And User click the My Profile link
    And User navigates to My Profile page
    And enter the address
    And click update profile
    And user gets a message "Profile updated successfully."
    Then click the logout button
    And close browser

    Examples: 
      | rowNum | colNum | excelPath                                                                                                                            | sheetNum |
      |     68 |      7 | C:\\Users\\Deepthi\\OneDrive\\Desktop\\CUCUMBER_SELENIUMNEW\\PHPTRAVELS\\src\\main\\resources\\CUSTOMER TEST CASE_PHPTRAVELS.xlsx |        0 |
