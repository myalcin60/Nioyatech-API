@CountryServices @Team
Feature: Country

  @GetAllCountryServices
  Scenario: User gets country services
    Given user sets the url for all country service
    When user sends the request and get the response for country services
    Then user verifies the body for country list

  @GetCountryServices
  Scenario Outline: User gets country services
    Given user sets the url for country service with "<id>"
    When user sends the request and get the response for country services with country id
    Then user verifies the body for country
    Examples:
      | id |
      | DZ |
      | ZW |
      | TR |

    @GetCountryServicesNegative
    Scenario: user doesnt get country services
      Given user sets the url for country service with invalid id
      When user sends the request and get the response for country services with country id
      Then User asserts that Status Code

