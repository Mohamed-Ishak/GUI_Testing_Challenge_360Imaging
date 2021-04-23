Feature: Verify User Registration Functionality (Happy Scenario)


  Scenario Outline:
    Given User is already open sign up page
    When  User enter valid "<First Name>" and "<Last Name>" for Names Fields
    And   User enter valid "<Mobile Number>"
    And   User enter valid "<Email>" address
    And   user enter valid "<Password>" and Confirm Password matched Password fields
    And   User click on Sign Up button
    Then  user Registered Successfully Redirected to his account page

   # example 1 happy Scenario for registration
   # example 2 user can't register with already registered mail
    Examples:

      | First Name | Last Name| Mobile Number|            Email        | Password |
      | Mohamed    | Ishak    | 0132546486   | P360Imaging@gmail.com| As$1233  |
#      | Mohamed    | Ishak    | 0132546486   | test360Imaging@gmail.com| As$1233  |



  # Test login Functionality with already registered user
  Scenario Outline:

    Given User already registered with valid email and password
    When  User enter valid "<email>" and "<password>"
    And   User click on login button
    Then  User Login Successfully and Redirected to his account page

    Examples:

    |      email               |  password |
    | P360Imaging@gmail.com |  As$1233   |

