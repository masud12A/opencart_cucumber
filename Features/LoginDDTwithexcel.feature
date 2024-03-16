Feature: LoginData Driven with Excel

  Scenario Outline: LoginData Driven with Excel
    Given User launch browser
    And Opens URL "https://demo.opencart.com/"
    When User navigates to MyAccount menu
    And Click on Login
    Then Check User navigates to MyAccountpage by passing email and password with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
