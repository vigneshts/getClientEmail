Feature: Get Weather from the local service

  Scenario Outline: Get weather using zipcode from local server
    Given The user requests temperature for the ZipCode "<zipCode>" from local server
    Then The weather is returned with Status code 200
    Examples:
      | zipCode  |
      | 94040,US |


  Scenario Outline: Get weather using city name from local server
    Given The user requests temperature for the City Name "<cityName>" from local server
    Then The weather is returned with Status code 200
    Examples:
      | cityName  |
      | London,UK |


  Scenario Outline: Get weather using city ID from local server
    Given The user requests temperature for the City ID "<cityID>" from local server
    Then The weather is returned with Status code 200
    Examples:
      | cityID  |
      | 5815135 |