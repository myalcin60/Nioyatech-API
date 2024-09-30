
package stepdefs;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojoDatas.UserCreatePostPojo;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.Map;

import static base_urls.A3MBaseUrl.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserServices {

    Response response;
    UserCreatePostPojo expectedData;
    int id;
    @Given("user sets the url for user service with appId")
    public void user_sets_the_url_for_user_service_with_app_id() {
        spec.pathParams("first", "v1","second","application","third","2","fourth","user");
    }
    @When("user sends the request and get the response for user service with appId")
    public void user_sends_the_request_and_get_the_response_for_user_service_with_app_id() {
        response = given().spec(spec).when().get("/{first}/{second}/{third}/{fourth}");
    }

    @Then("user verifies that the user unauthorized")
    public void user_verifies_that_the_user_unauthorized() {
        assertEquals(403, response.statusCode());
    }
    @Given("user sets the url for user service with organizationId")
    public void user_sets_the_url_for_user_service_with_organization_id() {
        spec.pathParams("first", "v1","second","organization","third","1716285460203281","fourth","user");
    }
    @When("user sends the request and get the response for user service with organizationId")
    public void user_sends_the_request_and_get_the_response_for_user_service_with_organization_id() {
        response = given().spec(spec).when().get("/{first}/{second}/{third}/{fourth}");
    }
    @Then("user verifies that the users list is listed")
    public void user_verifies_that_the_users_list_is_listed() {
        response.then().assertThat().statusCode(200).contentType("application/json");
        response.jsonPath().getList("").size();
        assertFalse( response.jsonPath().getList("").isEmpty());

    }
    @Given("user sets the url for post user")
    public void sets_the_url_for_post_user() {
        spec.pathParams("first","v1","second","organization","third","user","fourth","register-manual");
    }

    @When("user sends the request and get the response for user service")
    public void user_sends_the_request_and_get_the_response_for_user_service() {
       expectedData=new UserCreatePostPojo("2", "1716285460203281",
                "julian@gmail.com","4b0fb636-733f-4fcf-864e-c681ad84a139","19");
        response=given(spec).body(expectedData).contentType(ContentType.JSON).header("Accept","application/json").post("/{first}/{second}/{third}/{fourth}");
        response.prettyPrint();

    }
    @Then("user verifies that user is created")
    public void user_verifies_that_user_is_created() {
        response.then().assertThat().statusCode(201).contentType("application/json");
        JsonPath jsonPath=response.jsonPath();
        id=jsonPath.getInt("id");
        System.out.println(id);
        assertEquals(expectedData.getOrganization_id(),jsonPath.getString("organization_id"));
        assertEquals(expectedData.getEmail(),jsonPath.getString("email"));
        assertEquals(expectedData.getSubscription_id(),jsonPath.getString("subscription_id"));



    }
    @Given("user sets the url for delete user")
    public void user_sets_the_url_for_delete_user() {

        spec.pathParams("first", "v1","second","organization","third","1716285460203281","fourth","user","fifth","193");
    }
    @When("user sends the request and get the response for user service delete")
    public void user_sends_the_request_and_get_the_response_for_user_service_delete() {
        response = given(spec).delete("/{first}/{second}/{third}/{fourth}/{fifth}");
    }
    @Then("user verifies that user is deleted")
    public void user_verifies_that_user_is_deleted() {
        response.then().assertThat().statusCode(200);
    }
    @Then("user verifies that user is not found")
    public void user_verifies_that_user_is_not_found() {
        response.then().assertThat().statusCode(404);
    }




}

