Feature: Reqres API - Get user list

  Scenario: I can get list of users from given page
    When I check if page number in response is correct using methods class
    Then I should get 200 in response