package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoDatas.UserGroupTypeServicesPojo;
import utilities.ConfigReader;

import static base_urls.A3MBaseUrl.gsessionid;
import static base_urls.A3MBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class UserGroupTypeServices {
    UserGroupTypeServicesPojo pojo = new UserGroupTypeServicesPojo();

    public static Response response;


    @Given("the user sets the URL and sends a Get request")
    public void theUserSetsTheURLAndSendsAGetRequest() {
        spec.pathParams("userGroupType", "user-group-type");
        response = given(spec).get("/{userGroupType}");
    }

    @And("the user verifies that data is displayed in the response body.")
    public void theUserVerifiesThatDataIsDisplayedInTheResponseBody() {
        response.prettyPrint();
        response.then().assertThat().body("name[0]", equalTo("Department"));
        response.then().assertThat().body("name", hasItems("Department", "Remote Unit", "Team"));

    }

    @And("the user asserts that Content_Type is in application_json")
    public void theUserAssertsThatContent_TypeIsInApplication_Json() {
        response.then().assertThat().contentType(ContentType.JSON);
    }

    @Then("the user asserts that Status_Code is 200")
    public void theUserAssertsThatStatus_CodeIs200() {
        response.then().assertThat().statusCode(200);
    }

    @Then("the user asserts that Status_Code is 201")
    public void theUserAssertsThatStatus_CodeIs201() {
        response.then().assertThat().statusCode(201);
    }


    @When("the user sets the URL and sends POST request with relevant end point and request body {string},{string}")
    public void theUserSetsTheURLAndSendsPOSTRequestWithRelevantEndPointAndRequestBody(String name, String description) {
        spec.pathParams("userGroupType", "user-group-type");
       pojo = new UserGroupTypeServicesPojo(name, description);
        response = given(spec).contentType(ContentType.JSON).body(pojo).when().post("/{userGroupType}");
    }


    @Given("the user sets the URL with user id endpoint and sends a GET request {string}")
    public void theUserSetsTheURLWithUserIdEndpointAndSendsAGETRequest(String id) {
        spec.pathParams("userGroupType", "user-group-type", "endId", id);
        response = given(spec).get("/{userGroupType}/{endId}");
    }

    @Then("the user verifies that response body is displayed.")
    public void theUserVerifiesThatResponseBodyIsDisplayed() {
        response.getBody().prettyPrint();

    }


    @Given("the user sets the URL, the expected data and sends PUT request {string}, {string},{string}")
    public void theUserSetsTheURLTheExpectedDataAndSendsPUTRequest(String id, String name, String description) {
        spec.pathParams("userGroupType", "user-group-type");
        pojo = new UserGroupTypeServicesPojo(id,name,description);
        response = given(spec).body(pojo).contentType(ContentType.JSON).put("/{userGroupType}");
    }


    @Given("the user sets the URL with  user group type {string} end point and sends Delete request")
    public void theUserSetsTheURLWithUserGroupTypeEndPointAndSendsDeleteRequest(String id) {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie", "GSESSIONID=" + gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("userGroupType", "user-group-type", "userID", id);
        response = given(spec).delete("/{userGroupType}/{userID}");
    }

    @When("the user asserts that Status-Code is {int}") //Delete
    public void theUserAssertsThatStatus_CodeIs(int status_Code) {
        response.then().assertThat().statusCode(status_Code);
    }

    @Then("the user verifies that response body is empty.")
    public void theUserVerifiesThatResponseBodyIsEmpty() {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.isEmpty());
    }
}


