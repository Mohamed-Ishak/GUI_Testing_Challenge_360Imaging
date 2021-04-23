
Feature: Verify user Registration Functionality (Happy Scenario)

  Scenario Outline:
      Given User is already open sign up page
      When  User enter valid "<First Name>" and "<Last Name>" for Names Fields
      And   User enter valid "<Mobile Number>"
      And   User enter valid "<Email>" address
      And   user enter valid "<Password>" and Confirm Password matched Password fields
      And   User click on Sign Up button
      Then  user Registered Successfully Redirected to his account page


      # example 1 invalid Scenario invalid first name must start with capital letter
      # example 2 invalid Scenario invalid last name must start with capital letter
      # example 3 invalid Scenario invalid mobile number must contains Numbers only
      # example 4 invalid Scenario invalid password must have capital letter
      # example 5 invalid Scenario invalid password must have small letter
      # example 7 invalid Scenario invalid password must have special letter

    Examples:

     | First Name | Last Name| Mobile Number| Email              | Password |
     | mohamed    | Ahmad    | 01000000689  | moea94@gmail.com   | Ab@13456 |
#     | Mohamed    | salah    | 01001530689  | Ahdt9@gmail.com    | Ab@13456 |
#     | Mohamed    | Hady     | @@##11ee//$  | Ahthpj@gmail.com  | Ab@13456 |
#     | Mohamed    | Hady     | 01001530680  | Ahmggj@gmail.com  | f@13456  |
#     | Mohamed    | Hady     | 01001530680  | Ahmffj@gmail.com  | A@13456  |
#     | Mohamed    | Hady     | 01001530680  | Ajjhhj@gmail.com  | Ac13456  |



#  Scenario Outline:
#
#    Given User already registered with valid email and password
#    When  User enter valid "<email>" and "<password>"
#    And   User click on login button
#    Then  User Login Successfully and Redirected to his account page
#
#    Examples:
#
#      |      email        |  password |
#      | Utesta@gmail.com |  Ab@13456 |



