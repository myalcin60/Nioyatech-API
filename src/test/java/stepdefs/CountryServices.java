package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import static base_urls.A3MBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;


public class CountryServices {

    Response response;

    @Given("user sets the url for all country service")
    public void set_the_url_for_all_country_service() {
        spec.pathParams("countryPath", "country");

    }

    @Given("user sets the url for country service with {string}")
    public void user_sets_the_url_for_country_service_with(String id) {
        spec.pathParams("countryPath", "country","id",id);

    }

    @When("user sends the request and get the response for country services")
    public void send_the_request_and_get_the_response_for_country_services() {
        response = given().spec(spec).when().get("/{countryPath}");

    }

    @When("user sends the request and get the response for country services with country id")
    public void send_the_request_and_get_the_response_for_country_services_with_country_id() {
        response = given().spec(spec).when().get("/{countryPath}/{id}");

    }

    @Then("user verifies the body for country list")
    public void verifies_the_body_for_country_list() {
        response.then().assertThat().statusCode(200).contentType("application/json");
        int numOfElements = response.jsonPath().getList("").size();
        assertEquals(250, numOfElements);
        List<CountryServicesPojo> countryList = response.as(new TypeRef<>() {});
        assertEquals("Afghanistan", countryList.get(0).getName());
        assertEquals("Zimbabwe", countryList.getLast().getName());

    }

    @Then("user verifies the body for country")
    public void user_verifies_the_body_for_country() {
        response.then().assertThat().statusCode(200).contentType("application/json");
        CountryServicesPojo countryServicesPojo=new CountryServicesPojo();
        HashMap<String, Object> actualData= response.as(HashMap.class);
        assertEquals(countryServicesPojo.getIso2(), actualData.get("Iso2"));
        assertEquals(countryServicesPojo.getCurrency(), actualData.get("Currency"));
        assertEquals(countryServicesPojo.getCurrency_symbol(), actualData.get("Currency_Symbol"));
        assertEquals(countryServicesPojo.getName(), actualData.get("Name"));

    }

    @Given("user sets the url for country service with invalid id")
    public void user_sets_the_url_for_country_service_with_invalid_id() {
        spec.pathParams("countryPath", "country","id","TS");

    }

    @Then("User asserts that Status Code")
    public void user_asserts_that_status_code() {

        assertEquals(404, response.statusCode());

    }

}