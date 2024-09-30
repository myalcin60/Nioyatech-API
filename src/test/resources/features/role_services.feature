@RoleService @Team
Feature:The user must be able to perform role service get requests operations.

  @GetAppIdOrgId
  Scenario Outline:Get request with appID and organizationID
    Given User sends Get request with appId and orgId "<application>" "<appID>" "<organization>" "<orgID>" "<role>"
    Then User asserts that Status Code <StatusCode>
    And User verifies that all rolles is visible
    Examples:
      | application | appID | organization | orgID            | role | StatusCode |
      | application | 2     | organization | 1716285460203281 | role | 200        |
     #| application | 2     | organization | 1111111111111111 | role | 403        |





  @GetAppId
  Scenario Outline: Get request with appId
    Given User sends Get request with appId "<application>" "<appID>"  "<role>"
    Then User asserts that Status Code <StatusCode>
    And User verifies that all rolles is visible
    Examples:
      | application | appID | role | StatusCode |
      | application | 2     | role | 200        |
   # | application | 3     | role | 403        |



  @GetroleID
  Scenario Outline: Get request with role Id
    Given User sends Get request with roleId "<role>" "<roleID>"
    Then User asserts that Status Code <StatusCode>
    And User verifies <roleID> and "<roleName>"
    Examples:
      | roleID | role | StatusCode | roleName       |
      | 5      | role | 200        | Business Owner |
    # | 23     | role | 404        | Accountant     |
    # | 111    | role | 404        |                |





  @GetRole
  Scenario: Get request with role
    Given User sends Get request with role
    Then User asserts that Status Code 200
    Then User verifies that all rolles is visible






