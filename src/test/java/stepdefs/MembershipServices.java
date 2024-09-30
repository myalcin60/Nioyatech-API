

package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoDatas.MembershipServicesPojo;
import utilities.ConfigReader;

import java.util.HashMap;

import static base_urls.A3MBaseUrl.gsessionid;
import static base_urls.A3MBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

public class MembershipServices {
    Response response;
@Given("set the url for memberships list")
    public void settheurlformembershipslist(){
    spec.pathParams("allMemberships","v1","app","application","appId","2","inf","membership");

}

    @Given("the user sets the URL for membership services")
    public void theUserSetsTheURLForMembershipServices() {
        spec.pathParams("membership","v1","secndmembership","membership");
    }

    @Given("user sets the URL for membership services with user id")
    public void userSetsTheURLForMembershipServicesWithUserId() {
        spec.pathParams("membershipwithuser","v1","thirdmembership","user","userId","35","mem","membership");

    }

    @When("send the request and get the response for membership services")
    public void sendTheRequestAndGetTheResponseForMembershipServices() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("allMemberships","v1","app","application","appId","2","inf","membership");
        response = given(spec).get("/{allMemberships}/{app}/{appId}/{inf}");
        //response.prettyPrint();
    }

    @When("the user sends a GET request and gets response")
    public void theUserSendsAGETRequestAndGetsResponse() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("membership","v1","secndmembership","membership");
        response = given(spec).get("/{membership}/{secndmembership}");
    }

    @When("user sends request and get response for membership services with userID")
    public void userSendsRequestAndGetResponseForMembershipServicesWithUserID() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("membershipwithuser","v1","thirdmembership","user","userId","35","mem","membership");
        response = given(spec).get("/{membershipwithuser}/{thirdmembership}/{userId}/{mem}");
    }



    @Then("user asserts that Status Code is {int} for membershipServices")
    public void userAssertsThatStatusCodeIsForMembershipServices(int arg0) {
        response.then().assertThat().statusCode(403);
    }




    @Then("the user asserts that response body is empty")
    public void theUserAssertsThatResponseBodyIsEmpty() {

        MembershipServicesPojo membershipServicesPojo=new MembershipServicesPojo("Principal(testevolve@testevolve.com) not authorized to fetch memberships", "Forbidden", "Principal not authorized", 403, "2024-05-23T11:56:10.172802Z");

        HashMap<String, Object> actualData= response.as(HashMap.class);
        System.out.println("membershipServicesPojo = " + membershipServicesPojo);

        assertEquals(membershipServicesPojo.getError(),actualData.get("error"));


        assertEquals(membershipServicesPojo.getDetail(),actualData.get("detail"));
        assertEquals(membershipServicesPojo.getMessage(),actualData.get("message"));

        response.then().assertThat().statusCode(403);
    }





    @Then("the user verifies that all memberships information can be get.")
    public void theUserVerifiesThatAllMembershipsInformationCanBeGet() {
        int numOfElements = response.jsonPath().getList("").size();
        assertFalse(numOfElements==0);

    }

    @Then("for membership services user asserts that Status Code is {int}" )
    public void forMembershipServicesUserAssertsThatStatusCodeIs(int intKod1) {
        response.then().statusCode(200)
                .contentType(ContentType.JSON);
    }


    @Then("user gets all memberships information with user id")
    public void userGetsAllMembershipsInformationWithUserId() {
        int numOfElements = response.jsonPath().getList("").size();
        assertFalse(numOfElements==0);
    }



}


