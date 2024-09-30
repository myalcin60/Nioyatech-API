@OrganizationService @Team
Feature: Organization Service

Scenario Outline: Organization services GET requests
Given the user sets url to "<url>" and sends a get request
Then the user asserts that Status Code is <expected_status_code>
Then the user asserts that response body "<response_body>"
And the user asserts that "<status_code_message>"

Examples:
|url                  |status_code_message                |response_body |expected_status_code|
|get by app           |HTTP/1.1 404 Not Found             |              |404|
|invalid              |HTTP/1.1 500 Internal Server Error |errorBody     |500|
|get all              |HTTP/1.1 404 Not Found             |              |404|
|invalid              |HTTP/1.1 500 Internal Server Error |errorBody     |500|
|get by id            |HTTP/1.1 200 OK                    |forGetById    |200|
|invalid              |HTTP/1.1 500 Internal Server Error |errorBody     |500|



