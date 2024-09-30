@UserStatusServices @Team
Feature: API Positive and Negative Testing
  @Recep
  Scenario: Verify status code and content type for GET request
  When the user sends a GET request for user services
   Then the user asserts that Status Codes is 200
   And the user asserts that Content Type is "application/json"

  Scenario: Verify status code, content type, and response body for GET request with ID
  When the user sends a GET request with an ID "1"
  Then the user asserts that Status Codes is 200
  And the user asserts that Content Type is "application/json"
  And the user asserts that the request body name is equal to the response body name "Active"


 # Scenario : Verify status code and empty response body for GET request
   # Given the user sets invalid ID
   # And the user sets the URLS
    #When the user sends a GET requests for user service
   # Then the users asserts thats Status Codes is "404"
    #And the user asserts that the response body is empty



