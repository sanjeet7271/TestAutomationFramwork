Feature: End to End Tests for Store API
  Description: the purpose of the test case is to cover all currency

  @SmokeTest
  Scenario: user is getting response from API schema
    Given send the request to the store
    Then validate the status code from response
    And validate the currency to corresponding store code