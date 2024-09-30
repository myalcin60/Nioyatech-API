@MembershipServices @Team
Feature: Membership Services

  @AllMemberships
  Scenario: User gets Memberships of the Application
    Given set the url for memberships list
    When send the request and get the response for membership services
      Then  user asserts that Status Code is 403 for membershipServices
    Then the user asserts that response body is empty

  @Membership
  Scenario:User gets All Memberships
    Given the user sets the URL for membership services
    When the user sends a GET request and gets response
    Then for membership services user asserts that Status Code is 200
    Then the user verifies that all memberships information can be get.

    @MembershipsWithUser
    Scenario: User gets All memberships with user id
      Given user sets the URL for membership services with user id
      When user sends request and get response for membership services with userID
      Then for membership services user asserts that Status Code is 200
      Then user gets all memberships information with user id