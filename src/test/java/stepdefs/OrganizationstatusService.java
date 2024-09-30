package stepdefs;

import io.cucumber.java.en.*;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import pojoDatas.OrganizationStatusServiceData;
import pojoDatas.OrganizationstatusPojo;

import java.util.List;
import java.util.Map;

import static base_urls.A3MBaseUrl.spec;
import static io.restassured.path.json.JsonPath.given;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class OrganizationstatusService {
    Response response;
    static OrganizationStatusServiceData orgStatusServiceData = new OrganizationStatusServiceData();
    static List<Map<String, Object>> expectedData = orgStatusServiceData.setUpTestData();

    @Given("set the url for country list")
    public void set_the_url_for_country_list() {
        spec.pathParam("status", "organization-status");

    }
    @When("send the request and get the response for country list")
    public void send_the_request_and_get_the_response_for_country_list() {
        response = given().spec(spec).when().get("/{status}");
    }
    @Then("User assert that status Code")
    public void user_assert_that_status_code() {
        response.then().assertThat().statusCode(200);
    }

    @Then("User verifies response body size and expected body size")
    public void user_verifies_response_body_size_and_expected_body_size() {
        int datalength = response.jsonPath().getList("").size();
        assertEquals(3, datalength);
    }
    @Then("User verifies response bodys  and expected body")
    public void user_verifies_response_bodys_and_expected_body() {
        response.then().body("name", hasItems("Active", "Passive", "Pending Confirmation"));

        List<OrganizationstatusPojo> statusList = response.as(new TypeRef<>() {});

        assertEquals("Active", statusList.get(0).getName());
        assertEquals("Passive", statusList.get(1).getName());
        assertEquals("Pending Confirmation", statusList.get(2).getName());
    }

    @Given("send the request and get the response for country list with id {string} {string}")
    public void send_the_request_and_get_the_response_for_country_list_with_id(String status, String id) {
        spec.pathParams("status", status, "id",id);
        response = given(spec).get("/{status}/{id}");
    }

    @When("User assert that status Code with id")
    public void user_assert_that_status_code_with_id() {
        response.then().assertThat().statusCode(200);

    }
    @Given("User verifies response body  and expected body {string}")
    public void user_verifies_response_body_and_expected_body(String name) {

        String responseBody = response.getBody().asString();


        assertTrue(responseBody.contains(name));
    }


    @Given("User assert that status Code with invalid id")
    public void user_assert_that_status_code_with_invalid_id() {

        int statusCode = response.getStatusCode();
        assertEquals(404, statusCode);
    }

    @Given("send the request and get the response for country list with invalid id")
    public void sendTheRequestAndGetTheResponseForCountryListWithInvalidId() {

        spec.pathParams("sta","organization-status", "id12",4);
        response = given(spec).get("/{sta}/{id12}");

    }
}
