@UserGroupTypeService @Team
Feature: UserGroupType

  @GetUserGroupTypeService
  Scenario: Get All User Group Type
    Given the user sets the URL and sends a Get request
    When the user asserts that Status_Code is 200
    And the user asserts that Content_Type is in application_json
    And the user verifies that data is displayed in the response body.

  @PostUserGroupType
  Scenario Outline: Create New User Group Type
    Given the user sets the URL and sends POST request with relevant end point and request body "<name>","<description>"
    When the user asserts that Status_Code is 201
    And the user verifies that response body is displayed.
    Examples:
      | name                       | description                                |
      | New Posted User Group Type | Description for New Posted User Group Type |

  @PutUserGroupType
  Scenario Outline: Update Existing User Group Type
    Given the user sets the URL, the expected data and sends PUT request "<id>", "<name>","<description>"
    When the user asserts that Status_Code is 200
    And the user verifies that response body is displayed.
    Examples:
      | id | name         | description              |
      | 40 | Updated Name123 | Updated User Description |

  @GetUSerGroupTypeById
  Scenario: Get User Group Type By Id
    Given the user sets the URL with user id endpoint and sends a GET request "3"
    When the user asserts that Status_Code is 200
    Then the user verifies that response body is displayed.
    And the user asserts that Content_Type is in application_json

  @DeleteUserGroupType
  Scenario Outline: Delete Existing User Group Type by Id
    Given the user sets the URL with  user group type "<id>" end point and sends Delete request
    When the user asserts that Status-Code is <status_code>
    Then the user verifies that response body is empty.

    Examples:
      | id | status_code |
      | 94 | 200         |
      | 94 | 404         |
