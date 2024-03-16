Feature: Login Data Driven

  Scenario Outline: Login Data Driven
    Given User launch browser
    And Opens URL "https://demo.opencart.com/"
    When User navigates to MyAccount menu
    And Click on Login
    And User enters email as "<email>" and Password as "<password>"
    And Click on Login button
    Then User navigates to MyAccount Page

    Examples: 
      | email             | password |
      | abc@gmail.com     | test@123 |
      | xyz@gmail.com     | test@123 |
      | mahamed@gmail.com | test123  |
