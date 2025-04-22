Feature: User API Testing

  Scenario: Get a single user by ID
    Given the user ID is 2
    When I send a GET request to the user API
    Then the response status code should be 200
    And the response should contain the user's first name as "Janet"
