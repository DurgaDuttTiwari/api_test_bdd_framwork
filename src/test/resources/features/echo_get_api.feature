Feature: Validate GET request to echo API

  Scenario: Retrieve response and validate path, IP, and headers
    When I send a GET request to the echo API
    Then the response should include a valid path
    And the response should include an IP address
    And the response should include headers
