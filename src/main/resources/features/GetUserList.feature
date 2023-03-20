Feature: Reqres API - Get user list

  Scenario Outline: I can get list of users from given page
    Given I set page number to be searched to <pageNumber>
    When I send request to get list of users on a specified page number
    Then I should get "200" in response
    And I should get correct page number in response

    Examples:
      | pageNumber |
      | 1          |
      | 5          |
      | 100        |
      | -5         |