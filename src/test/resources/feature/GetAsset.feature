Feature: Get Client portfolio

  Scenario: To get client's email
    Given The user requests the clients from "TX"
    Then The email should be sent to the clients with assets more than a million


