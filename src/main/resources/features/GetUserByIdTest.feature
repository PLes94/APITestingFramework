Feature: Reqres API - Get user by id

  Scenario Outline: I can get a user by a specified id
    Given I set user id to be searched to <pageNumber>
    When I send request to get a user by a specified id
    Then I should get "200" in response
    And I should get correct user id in response

    Examples:
      | pageNumber |
      | 1          |
      | 5          |

  Scenario Outline: I cannot get a non existing user by id
    Given I set user id to be searched to <pageNumber>
    When I send request to get a user by a specified id
    Then I should get "404" in response

    Examples:
      | pageNumber |
      | 100        |
      | -5         |