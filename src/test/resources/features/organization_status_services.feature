
@StatusService @Team
  Feature:StatusService
    @GetAllStatusService
    Scenario:User gets status service
      Given User sets  the url for all status services
      When User send Get request with status service
      Then user set expected status service
      Then user assert that status Code
      And User verifies response body and expected body
      And User verifies Response time is less than 800ms


  @GetAllStatusService
  Scenario:User gets status service
    Given set the url for country list
    When send the request and get the response for country list
    And User assert that status Code
    And User verifies response body size and expected body size
    And User verifies response bodys  and expected body

  @GetStatusService
  Scenario Outline: Get status service with id
    Given send the request and get the response for country list with id "<Status>" "<id>"
    And User assert that status Code with id
    And User verifies response body  and expected body "<name>"
    Examples:
      | Status              | id | name                 |
      | organization-status | 1  | Active               |





#  @GetStatusServiceNegative
#  Scenario: Get status service with id
#    Given send the request and get the response for country list with invalid id
#    And User assert that status Code with invalid id
#







