Feature: shop on website

#  Background: open browser


  Scenario:user can register with valid data
    Given that his email isn't taken

  Scenario:user can login with valid email and password
    Given that his email and password are correct

  Scenario:user can reset password
    Given user clicked on forgot password
    And user recieved the email message

  Scenario:logged user can search for any product
    Given that he types it in the search bar and it exists
    And he is logged in

  Scenario:logged user can switch currencies (US and euro)
    Given he clicked on the currency
    And he is logged in

  Scenario:logged user can choose any category
    Given he selected category
    And he is logged in

  Scenario:logged user can filter with color
    Given he selected color
    And he is logged in

#  Scenario:logged user can select different tags
#    Given he selected category

  Scenario:logged user can add many products to shopping cart
    Given he selected category
    And he is logged in


  Scenario:logged user can add many products to wish list
    Given he selected category
    And he is logged in


  Scenario:logged user can add many products to compare list
    Given he selected category
    And he is logged in


  Scenario:logged user can create a successful order
    Given he selected category
    And he is logged in
