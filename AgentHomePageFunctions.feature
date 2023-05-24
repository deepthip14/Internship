Feature: Verify all functions in Agent homepage

  Background: 
    Given The browser is open
    And User is on login page "https://phptravels.net/login"

  Scenario Outline: Verify the link Functionality of Agent
  
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
  | email                | password  |
  | agent@phptravels.com | demoagent |
  
  Scenario Outline: Verify the links directed to the destination page of Agent
    When User enters email as "<email>" and password as "<password>"
    And User click the login button
    Then page title is "Dashboard - PHPTRAVELS"
    And User click the Home link
    And User navigates to homepage
    And User click the Hotel link
    And User navigates to hotel page
    And User click the Flights link
    And User navigates to flights page
    And User click the Tours link
    And User navigates to tours page
    And User click the Visa link
    And User navigates to visa page
    And User click the Blog link
    And User navigates to blog page
    And User click the Offers link
    And User navigates to offers page
    Then click the logout button
    And close browser

    Examples: 
      | email                | password  |
      | agent@phptravels.com | demoagent |

  Scenario Outline: Verify the search hotel function of Agent
    When User enters email as "<email>" and password as "<password>"
    And User click the login button
    Then page title is "Dashboard - PHPTRAVELS"
    And User click the Hotel link
    And User navigates to hotel page
    And enter the city name, check in date, check out date, and travellers
    And click search
    And User navigates to hotels of that city page
    Then click the logout button
    And close browser

    Examples: 
      | email                | password  |
      | agent@phptravels.com | demoagent |
      
      Scenario Outline: Verify the update currency of Agent
    When User enters email as "<email>" and password as "<password>"
    And User click the login button
    Then page title is "Dashboard - PHPTRAVELS"
    And click USD
    And select the currency as INR
    Then click the logout button
    And close browser
    
    Examples: 
      | email                | password  |
      | agent@phptravels.com | demoagent |
      
      
