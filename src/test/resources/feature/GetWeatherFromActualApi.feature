Feature: Get Weather from the actual service

  Scenario Outline: Get weather using zipcode from actual server
    Given The user requests a GET request for the ZipCode "<zipCode>"
    Then The weather is returned with Status code 200
    Examples:
      | zipCode  |
      | 94040,US |


  Scenario Outline: Get weather using city name from actual server
    Given The user requests a GET request for the City Name "<cityName>"
    Then The weather is returned with Status code 200
    Examples:
      | cityName  |
      | London,UK |


  Scenario Outline: Get weather using city ID from actual server. This is a failing scenario
    Given The user requests a GET request for the City ID "<cityID>"
    Then The weather is returned with Status code 200
    Examples:
      | cityID   |
      | 581w5135 |
