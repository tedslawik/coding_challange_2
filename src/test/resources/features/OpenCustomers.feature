Feature: Open Customers Page

  Background:
    Given user opened customer page
    Then user should see 'Customers' header
    Then user should see proper prompt with numbers of customers on the list

  Scenario Outline: Search form the list by '<column>'
    When user selects '<column>' in search dropdown
    When user enters '<searchValue>' into search bar
    Then user should see customer List
      |<customer>|
    And user should see proper prompt

    Examples:
      | searchValue          | column | customer|
      | 1                    | Id     |1 Alabaster office@alabaster.com Melbourne |
      | Bondir               | Name   |3 Bondir info@bond.ir Belfast |
      | conatact@postimex.pl | Email  |2 Postimex conatact@postimex.pl Carthage|
      | Belfast              | City   |3 Bondir info@bond.ir Belfast |

  Scenario: Clearing search results
    When user searches by value
      | column | Name   |
      | value  | Bondir |
    When user clears filters
    Then user should see full list of customers

  Scenario: Match Case
    When user searches by value
      | column | Name      |
      | value  | alabaster |
    When user activates Match case
    Then user should see proper prompt