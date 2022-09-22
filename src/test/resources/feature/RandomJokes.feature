Feature: End to End Tests for Random Jokes API
  Description:the purpose of the test case is to cover all data

  @RandomJokes
  Scenario: users are enjoying from Random jokes
    Given send request to random joke url
    Then validate status code
    And print all random jokes data

  @RandomJokes
  Scenario Outline: users are enjoying particular joke
    Given send request to particular joke with id <id>
    Then verify response status code
    And verify response id <id>
    And verify response Joke <value>
    And verify response url <url>
    And verify response created at <created_at>
    Then verify response updated at <updated_at>

    Examples: 
      | id                     | value                                          | url                                                     | created_at                 | updated_at                 |
      | bKZQd1QVTOqhXjbnqoTGeQ | Chuck Norris plays Jenga with brick buildings. | https://api.chucknorris.io/jokes/bKZQd1QVTOqhXjbnqoTGeQ | 2020-01-05 13:42:28.143137 | 2020-01-05 13:42:28.143137 |
