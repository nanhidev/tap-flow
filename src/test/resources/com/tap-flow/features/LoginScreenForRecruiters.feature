
@feature_user_login
Feature: LoginScreenForRecruiters

Background: 
  Given the user has opened the application
  And the 'Get Started' button is visible

@valid-login
Scenario Outline: Login Screen for Recruiters
  When the user clicks on the 'Get Started' button
  Then the user should be navigated to the Organization signup screen
  When the user clicks on the 'Continue as Organization' button
  Then the user should be navigated to the Login page

Examples:
  | action                       |
  | Get Started                 |
  | Continue as Organization     |

@valid-login
Scenario Outline: Login Screen for Recruiters
  Given the user enters "<email>" in the Email field
  And the user enters "<password>" in the Password field
  And the Login button is enabled
  When the user clicks on the Login button
  Then the user should be redirected to the dashboard
  And the dashboard is displayed

  Examples:
    | email                   | password            |
    | recruiter@example.com   | SecurePassword123   |

@toggle_password_visibility
Scenario Outline: Login Screen for Recruiters
  When I enter "<password>" in the Password field
  And I click on the 'Show/Hide Password' option
  Then the password should be visible
  And I click on the 'Show/Hide Password' option again
  Then the password should be hidden

Examples:
  | password      |
  | P@ssw0rd123   |

  @valid_login_button_enabled
  Scenario Outline: Login Screen for Recruiters
    Given the user enters a valid email ID <email> in the Email field
    And the user enters a valid password <password> in the Password field
    Then the Login button should be enabled

    Examples:
      | email              | password           |
      | krishna@gmail.com  | SecurePassword123   |

@valid_email_formats_login
Scenario Outline: Login Screen for Recruiters
  When I enter "<email>" in the Email field
  And I enter "<password>" in the Password field
  And I click on the Login button
  Then the user should be directed to the dashboard

  Examples:
    | email                           | password          |
    | user.name@subdomain.example.com | ValidPassword123  |
    | user+name@example.com          | ValidPassword123  |

@valid-chrome-login
Scenario Outline: Login Screen for Recruiters in Chrome
  When I enter <username> and <password>
  And I log in
  Then the user should be logged in successfully in Chrome
  And I log out
  Given the user opens the application in Firefox
  When I enter <username> and <password>
  And I log in
  Then the user should be logged in successfully in Firefox
  And I log out
  Given the user opens the application in Safari
  When I enter <username> and <password>
  And I log in
  Then the user should be logged in successfully in Safari

Examples:
  | username   | password   |
  | validUser1 | validPass1 |

  @feature_user_login
  @valid-login
  Scenario Outline: Login Screen for Recruiters
    When the user opens the application on a "<device>"
    And the user enters "<username>"
    And the user enters "<password>"
    And the user clicks the Login button
    Then the user should be logged in successfully
    And the user logs out

  Examples:
    | device  | username      | password            |
    | desktop | recruiter123  | SecurePassword!123  |
    | tablet  | recruiter123  | SecurePassword!123  |
    | mobile  | recruiter123  | SecurePassword!123  |

  @feature_user_login
  @reset_password_and_login
  Scenario Outline: Login Screen for Recruiters
    When the user clicks on the password reset link in the email
    And the user enters <new_password> in the Password field
    And the user confirms <new_password> in the Confirm Password field
    And the user clicks on the 'Reset Password' button
    Then the user should be redirected to the Login page
    When the user enters <email> in the Email field
    And the user enters <new_password> in the Password field
    And the user clicks on the Login button
    Then the user logs in successfully with the new password

    Examples:
      | email                     | new_password       |
      | valid_email@example.com   | new_password_value  |
