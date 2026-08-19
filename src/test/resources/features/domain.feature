Feature: Payment order component
  Scenario: list payment orders
    When I GET "/api/payment-orders"
    Then the response status is 200
