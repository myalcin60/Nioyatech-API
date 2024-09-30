@UserServicesF @Team
  Feature:User Services

@GetUserServiceswithAppId
Scenario: User gets user services
Given user sets the url for user service with appId
When user sends the request and get the response for user service with appId
Then user verifies that the user unauthorized

@GetUserServiceswithOrganizationId @Smoke
Scenario: User gets user services
Given user sets the url for user service with organizationId
When user sends the request and get the response for user service with organizationId
Then user verifies that the users list is listed

@PostUser
Scenario: user posts user
Given user sets the url for post user
When user sends the request and get the response for user service
Then user verifies that user is created

@DeleteUser
Scenario: user deletes user
Given user sets the url for delete user
When user sends the request and get the response for user service delete
Then user verifies that user is deleted

@DeleteUserNegative
Scenario: user dosent delete user
Given user sets the url for delete user
When user sends the request and get the response for user service delete
Then user verifies that user is not found