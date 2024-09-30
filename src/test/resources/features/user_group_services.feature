@userGroupServices @Team
Feature: Get All User Groups

  @getAllUserGroups
  Scenario: Get all User Groups
    Given Can sets the URL to Get All User Groups
    When Can sends a Get request for with OrganizationId and GroupTypeId
    Then Can verifies statues code 200
    Then Can asserts the body for AllUserGroups

  #@getAllUserGroupsNegative1
  #Scenario: Get all User Groups
  #  Given Can sets the URL to Get All User Groups Negative Scenario1
  #  When Can sends a Get request for with without sessionID
  #  Then Can verifies statues code 401

  #@getAllUserGroupsNegative2
  #Scenario: Get all User Groups
  #  Given Can sets the URL to Get All User Groups Scenario2
  #  When Can sends a Get request for AllUserGroups with invalid OrganizationId and GroupTypeId
  #  Then Can verifies statues code 404

  @getUserGroupById
  Scenario: getUserGroupById
    Given Can sets the URL to Get User Group by Id
    When Can sends a Get request for UserGroupById
    Then Can verifies statues code 200
    Then Can asserts the body for UserGroupById


