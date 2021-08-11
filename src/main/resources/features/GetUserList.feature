Feature: Reqres API - Get user list

  Scenario Outline: I can get list of users from given page
    When I send request to get list of users on page number = <pageNumber>
    Then I should get 200 in response
    And I check if page number in response is equal to <pageNumber>

    Examples:
      | pageNumber |
      | 1          |
      | 5          |
      | 100        |
      | -5         |