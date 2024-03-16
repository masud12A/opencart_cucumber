Feature: Login with Valid Credentials

  @Sanity
  Scenario: Successfull Login with Valid Credentials
    Given User launch browser
    And Opens URL "https://demo.opencart.com/"
    When User navigates to MyAccount menu
    And Click on Login
    And User enters email as "masudahmedatif@gmail.com" and Password as "test123"
    And Click on Login button
    Then User navigates to MyAccount Page
