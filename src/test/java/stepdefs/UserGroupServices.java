package stepdefs;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojoDatas.UserGroupServicesPojo;
import static base_urls.A3MBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;


public class UserGroupServices {

    Response response;

    UserGroupServicesPojo userGroupServicesPojo;

    @Given("Can sets the URL to Get All User Groups")
    public void can_sets_the_url_to_get_all_user_groups() {
        spec.queryParams("organizationId", "1716285460203281");
        spec.queryParams("groupTypeId", "1");
        spec.pathParams("usergroupsPath", "user-group");}

    @When("Can sends a Get request for with OrganizationId and GroupTypeId")
    public void can_sends_a_get_request_for_with_organization_id_and_group_type_id() {
        response = given(spec).get("/{usergroupsPath}");
        response.prettyPrint();
    }

   @Then("Can asserts the body for AllUserGroups")
   public void can_asserts_the_body_for_all_user_groups() {
       // Actual response body
       String actualBody = "[{\"id\":87,\"name\":\"Department\",\"group_type_id\":1,\"organization_id\":1716285460203281,\"users\":[{\"id\":106,\"username\":\"kutluyorum@cisco.com\",\"email\":\"kutluyorum@cisco.com\",\"is_email_verified\":false,\"status_id\":1,\"created_at\":\"2024-05-21T17:28:38.655457Z\",\"created_by\":36,\"updated_at\":\"2024-05-24T00:04:52.994953Z\",\"updated_by\":35},{\"id\":24,\"username\":\"rooney@clarusway.com\",\"email\":\"rooney@clarusway.com\",\"is_email_verified\":false,\"status_id\":1,\"created_at\":\"2024-05-19T20:38:20.305Z\",\"created_by\":2,\"updated_at\":\"2024-05-19T20:38:20.305003Z\",\"updated_by\":2}],\"roles\":[{\"id\":23,\"name\":\"Accountant\",\"app_id\":2},{\"id\":5,\"name\":\"Business Owner\",\"app_id\":2}]}]";

       // Get the response body from the actual response
       response = given().spec(spec).when().get("/{usergroupsPath}");
       String responseBody = response.getBody().asString();

       // Convert actual and expected JSON strings to JsonArray
       JsonParser parser = new JsonParser();
       JsonArray expectedArray = parser.parse(actualBody).getAsJsonArray();
       JsonArray actualArray = parser.parse(responseBody).getAsJsonArray();

       // Assert that the actual JSON array contains the expected JSON object
       assertTrue(expectedArray.contains(actualArray.get(0)));
   }

    @Given("Can sets the URL to Get All User Groups Negative Scenario1")
    public void can_sets_the_url_to_get_all_user_groups_negative_scenario1() {

    }

    @When("Can sends a Get request for with without sessionID")
    public void can_sends_a_get_request_for_with_without_session_id() {

    }

    @Then("Can verifies statues code {int}")
    public void can_verifies_statues_code(Integer statuscode) {
        //   response.then().assertThat().statusCode(statuscode).contentType("application/json");


    }

    @Given("Can sets the URL to Get All User Groups Scenario2")
    public void can_sets_the_url_to_get_all_user_groups_scenario2() {

    }

    @When("Can sends a Get request for AllUserGroups with invalid OrganizationId and GroupTypeId")
    public void can_sends_a_get_request_for_all_user_groups_with_invalid_organization_id_and_group_type_id() {

    }

    @Given("Can sets the URL to Get User Group by Id")
    public void can_sets_the_url_to_get_user_group_by_id() {
        spec.pathParams("usergroupsPath", "user-group", "id", 1);
    }

    @When("Can sends a Get request for UserGroupById")
    public void can_sends_a_get_request_for_user_group_by_id() {
        response = given(spec).get("/{usergroupsPath}/{id}");
        response.prettyPrint();
    }

    @Then("Can asserts the body for UserGroupById")
    public void can_asserts_the_body_for_user_group_by_id() {
        String expectedBody = "{\"id\":1,\"name\":\"Marketing and Sales Department\",\"short_name\":\"M&A Dept.\",\"group_type_id\":1,\"group_type\":{\"id\":1,\"name\":\"Department\",\"description\":\"User account is deactivated, and not authorized to access any the application\"},\"organization_id\":1,\"organization\":{\"id\":1,\"name\":\"Acme LLC\",\"founder_id\":2,\"short_name\":\"Acme\",\"address\":\"Ronald Avenue McMillan Drive No. 5, Tysons, Virginia\",\"phone\":\"15555555555\",\"email\":\"contact@acme.com\",\"website\":\"www.acme.com\",\"fax\":\"15555555555\",\"status_id\":1,\"organization_group_id\":2,\"created_at\":\"2023-01-17T20:35:06.419830Z\",\"updated_at\":\"2023-02-22T10:54:14.929604Z\",\"currency\":\"USD\"},\"users\":[{\"id\":7,\"name\":\"Sales\",\"lastname\":\"Man\",\"username\":\"salesman\",\"email\":\"salesman@test.com\",\"is_email_verified\":true,\"status_id\":1,\"created_at\":\"2023-02-09T21:56:18.472253Z\",\"updated_at\":\"2023-02-09T21:56:18.472254Z\"},{\"id\":8,\"name\":\"Sales\",\"lastname\":\"Per\",\"username\":\"salesper\",\"email\":\"salesper@test.com\",\"is_email_verified\":true,\"status_id\":1,\"created_at\":\"2023-02-09T21:56:37.321656Z\",\"updated_at\":\"2023-02-09T21:56:37.321657Z\"}],\"roles\":[]}";

        given()
                .spec(spec)
                .when()
                .get("/{usergroupsPath}/{id}")
                .then()
                .assertThat()
                .body(equalTo(expectedBody));
    }
}
