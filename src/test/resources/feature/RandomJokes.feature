Feature: End to End Tests for Random Jokes API
  Description:the purpose of the test case is to cover all data

  @RandomJokes
  Scenario: user is getting response from Random jokes api
    Given send request to randon joke url
    Then validate status code
    And validate random jokes data
