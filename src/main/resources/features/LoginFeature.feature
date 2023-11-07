Feature: Login functionality
  I want to verify login functionality

  @login
  Scenario Outline: Login with valid creds into KSRTC website
    Given Goto to Homepage "url"
    Then HomePage is displayed
    When Click on Signin
    Then Login page is displayed
    When User enters "<email>" and "<password>"
    When Click login
    Then HomePage is displayed
    And Username is "<username>"

    Examples:
      | email                    | password | username     |
      | deepakvarma543@gmail.com | Rebel@11 | deepak varma |

  @login
  Scenario: Login with invalid creds into KSRTC website
    Given Goto to Homepage "url"
    Then HomePage is displayed
    When Click on Signin
    Then Login page is displayed
    When User enters "deepakvarma543@gmail.com" and "Deepak@1"
    And Click login
    Then Login incorrect displayed
