package stepdefs;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static base_urls.A3MBaseUrl.spec;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserStatusServices {
    static Response response;

    @When("the user sends a GET request for user services")
    public void the_user_sends_a_get_request_for_user_services() {
        spec.pathParam("status", "user-status");
        response = given().spec(spec).when().get("/{status}/");
    }

    @Then("the user asserts that Status Codes is {int}")
    public void the_user_asserts_that_status_codes_is(int statuscode) {
        response.then().assertThat().statusCode(statuscode);
    }

    @Then("the user asserts that Content Type is {string}")
    public void the_user_asserts_that_content_type_is(String contenttype) {
        response.then().assertThat().contentType(contenttype);
    }

    @When("the user sends a GET request with an ID {string}")
    public void the_user_sends_a_get_request_with_an_ID(String ID) {
        spec.pathParams("status", "user-status", "id", ID);
        response = given().spec(spec).when().get("/{status}/{id}/");
    }

    @Then("the user asserts that the request body name is equal to the response body name {string}")
    public void the_user_asserts_that_the_request_body_name_is_equal_to_the_response_body_name(String bodyName) {
        response.then().assertThat().body("name", equalTo(bodyName));
    }

    // @Given("the user sets invalid ID")
    public void the_user_sets_invalid_ıd() {
        // spec.pathParams("status","user-status", "id11",10);
        // response = given(spec).get("/{status}/{id10}");
    }

    //@Given("the user sets the URLS")
    public void the_user_sets_the_urls() {

    }

    // @When("the user sends a GET requests for user service")
    public void the_user_sends_a_get_requests_for_user_service() {
        //  spec.pathParam("status", "user-status");
        // response = given().spec(spec).when().get("/{status}");

    }

    //@Then("the users asserts thats Status Codes is {string}")
    public void the_users_asserts_thats_status_codes_is(String string) {

        //int statusCode = response.getStatusCode();
        //  assertEquals(404, statusCode);
    }

    //@Then("the user asserts that the response body is empty")
    public void the_user_asserts_that_the_response_body_is_empty() {
        // String responseBody = response.getBody().asString();
        // assertTrue(responseBody.isEmpty());
    }


}
