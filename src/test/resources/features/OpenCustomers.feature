Feature: Open Customers Page

  Scenario: Open customer page
    When user opens customers page
    Then user should see 'Customers' header

  Scenario: User see proper counted list
    Given user opened customer page
    Then user should see proper prompt with numbers of customers on the list.

  Scenario: Search form the list by ID
    Given user opened customer page
    When user selects 'Id' in search dropdown
    When user enters '3' into search bar
    When user activates Match case
    Then user should see customer List
      | 3 Bondir info@bond.ir Belfast |
    And user should see proper prompt

  Scenario: Clearing search results
    Given user opened customer page
    When user searches by value
      | column | Name   |
      | value  | Bondir |
    When user clears filters
    Then user should see full list of customers