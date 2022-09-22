Feature: End to End Tests for Store API
  Description: the purpose of the test case is to cover all currency

  @SmokeTest
  Scenario: users are searching for store
    Given send the request to the store
    Then verify the status code from response
    And print the reponse from store

  @SmokeTest
  Scenario Outline: users are searching for store and checking store currency
    Given send the request to the store with store code <storeCode>
    Then verify the status code
    And verify each store is having currency

    Examples: 
      | storeCode |
      | AT        |
      | DE        |
      | ES        |
      | NL        |
      | US        |

  @SmokeTest
  Scenario Outline: users are searching for store and checking all details
    Given send the request to the store with id <ID> and store code <storeCode>
    Then verify the response status code
    And verify each store is having alternative Locales <alternativeLocales> default currency <defaultCurrency> and default locale <defaultLocale>

    Examples: 
      | ID | storeCode | alternativeLocales | defaultCurrency | defaultLocale |
      |  1 | DE        | en                 | EUR             | de            |
      |  3 | UK        | en                 | GBP             | en            |
      |  4 | AT        | en                 | EUR             | de            |
      |  5 | NL        | en                 | EUR             | nl            |
      | 14 | US        | en                 | USD             | en            |
