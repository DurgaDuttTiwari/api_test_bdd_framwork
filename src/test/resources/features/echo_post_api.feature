Feature: Validate POST order request to echo API

  Scenario: Place an order and validate the response
    Given I prepare the JSON order payload from "order_payload.json"
    When I send a POST request to the order endpoint
    Then the response should contain customer name as "Jane Smith"
    And the response should contain product with ID "A101"
    And the response should contain payment method as "credit_card"
