package stepdefs;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import utilities.ConfigReader;

import java.util.HashMap;
//import static base_urls.A3MBaseUrl.spec;
import static base_urls.A3MBaseUrl.gsessionid;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class RoleServices {
    Response response;
    RequestSpecification spec;

    @Given("User sends Get request with appId and orgId {string} {string} {string} {string} {string}")
    public void Get_request_orgID(String application, String appID, String organization, String orgID, String role) {

        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("app", application, "appID", appID, "org", organization, "organizationID", orgID, "Role", role);
        response = given(spec).get("/{app}/{appID}/{org}/{organizationID}/{Role}");
        response.prettyPrint();

    }

    @Given("User sends Get request with appId {string} {string}  {string}")
    public void Get_request_appID(String application, String appID, String role) {

        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("app", application, "appID", appID, "Role", role);
        response = given(spec).get("/{app}/{appID}/{Role}");
        response.prettyPrint();
    }
    @Given("User sends Get request with roleId {string} {string}")
    public void user_sends_get_request_with_role_ıd(String role, String roleID) {

        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("role", role,"roleId", roleID);
        response = given(spec).when().get("/{role}/{roleId}");
        response.prettyPrint();
    }

    @Given("User sends Get request with role")
    public void get_request_role() {

        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("Role", "role");
        response = given(spec).when().get("/{Role}");
        response.prettyPrint();

    }



    @Then("User asserts that Status Code {int}")
    public void status_Code(Integer StatusCode) {


        response.then().assertThat().statusCode(StatusCode);

        // 200 OK olduğunda JSON tipinde yanıt bekleyin
        if (StatusCode == 200) {
            response.then().contentType(ContentType.JSON);
        }
    }

    @Then("User verifies that all rolles is visible")
    public void rolles_is_visible() {

        if(response.getStatusCode() == 200) {
        int numOfElements = response.jsonPath().getList("").size();
        assertFalse(numOfElements == 0);
        }
        else{int numOfElements = response.jsonPath().getList("").size();
            assertTrue(numOfElements == 0);
        }

        }


    @Then("User verifies {int} and {string}")
    public void user_verifies_and(Integer roleID, String roleName) {
        if(response.getStatusCode() == 200) {
            HashMap<String, Object> actuelResponse = response.as(HashMap.class);
            assertEquals(roleID, actuelResponse.get("id"));
            assertEquals(roleName, actuelResponse.get("name"));

        }
        else {response.then().body(null);}
    }


}
