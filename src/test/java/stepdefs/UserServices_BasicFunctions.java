package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoDatas.UserCreatePostPojo;
import pojoDatas.UserServicesPojo_Update_A_User_Main;
import pojoDatas.UserServicesPojo_Update_A_User_Status;
import utilities.ConfigReader;

import static base_urls.A3MBaseUrl.*;
import static base_urls.A3MBaseUrl_WithDifferentUser.spec2;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UserServices_BasicFunctions {

    Response response;
    Response response2;


    String responseBodyStr;
    String responseBodyStr2;
    String responsetxt;

    String  commonuserid;
    UserServicesPojo_Update_A_User_Status pojoUpdateAUserStatus = new UserServicesPojo_Update_A_User_Status("1",
            "Active",
            "User account is activated and authorized to use the application by putcisco");

    UserServicesPojo_Update_A_User_Main pojoUpdateAUserMain = new UserServicesPojo_Update_A_User_Main("106",
            "kutluyorum@cisco.com",
            "kutluyorum@cisco.com",
            "false",
            "1",
            pojoUpdateAUserStatus,
            "1715290785259464", "2", "5", "30",
            "3d2fbde1-d022-4107-9321-413380705457",
            "false","0XTCtTL9jS0CNqb",
            "false","true", "true", "2024-05-20T05:03:31.360571Z",
            "2024-05-20T19:09:02.471368Z"
    );

//    UserCreatePostPojo postPojo=new UserCreatePostPojo(ConfigReader.getProperty("app_id"), ConfigReader.getProperty("organization_id"),
//            "silelim@gmail.com",ConfigReader.getProperty("subscription_id"),"30");

    UserCreatePostPojo postPojo=new UserCreatePostPojo("2", "1716285460203281",
            "sunumicin77@gmail.com","4b0fb636-733f-4fcf-864e-c681ad84a139","30");


    /*"id": 1849,
    "username": "putdeneme@cisco.com",
    "email": "putdeneme@cisco.com",
    "is_email_verified": false,
    "status_id": 1,
    "status": {
        "id": 1,
        "name": "Active",
        "description": "User account is activated and authorized to use the application"
    },
    "organization_id": 1715290785259464,
    "app_id": 2,
    "membership_type_id": 5,
    "default_role_id": 30,
    "subscription_id": "3d2fbde1-d022-4107-9321-413380705457",
    "is_individual_membership": false,
    "password": "0XTCtTL9jS0CNqb",
    "is_owner": false,
    "is_active": true,
    "is_default": true,
    "membership_created_at": "2024-05-13T06:18:23.869044Z",
    "membership_updated_at": "2024-05-13T06:18:23.869045Z"
}

*/


    @Given("user set the url for users list")
    public void user_set_the_url_for_users_list() {
        spec.pathParams("firstPath", "v1", "secondPath", "user");

    }

    @When("user send the request and get the response for users list")
    public void user_send_the_request_and_get_the_response_for_users_list() {
        response = given(spec).get("/{firstPath}/{secondPath}");
        response.prettyPrint();
        responseBodyStr = response.body().asString();


    }

    @Then("user assert the users list is succesfull")
    public void user_assert_the_users_list_is_succesfull() {
        System.out.println("response.statusCode() = " + response.statusCode());
        assertEquals(200, response.statusCode());
        System.out.println("responseBodyStr = " + responseBodyStr);
        response.
                then().
                assertThat().statusCode(200).   contentType(ContentType.JSON).
                body("records.id",hasSize(7), "total_records",equalTo(7));



    }


    @Given("user set the url for users list with different user")
    public void userSetTheUrlForUsersListWithDifferentUser() {
        spec2.pathParams("first", "v1", "second", "user");


    }

    @When("user send the request and get the response for users list with different user")
    public void userSendTheRequestAndGetTheResponseForUsersListWithDifferentUser() {
        response2 = given(spec2).get("/{first}/{second}");
        response2.prettyPrint();
        responseBodyStr = response2.body().asString();

    }


    @Then("user assert the users list is succesfull and different with different user")
    public void userAssertTheUsersListIsSuccesfullAndDifferentWithDifferentUser() {
        System.out.println("response.statusCode() = " + response2.statusCode());
        assertEquals(403, response2.statusCode());
        System.out.println("responseBodyStr = " + responseBodyStr2);



    }


    @When("send the request and get the response to update a user")
    public void sendTheRequestAndGetTheResponseToUpdateAUser() {
        response= given(spec).
                body(pojoUpdateAUserMain).
                contentType(ContentType.JSON).
                when().
                put("/{firstPath}/{secondPath}");

        response.prettyPrint();

        System.out.println("response3.statusCode() = " + response.statusCode());


    }

    @Then("user assert the user is updated as expected")
    public void userAssertTheUserIsUpdatedAsExpected() {

        assertEquals(200,response.statusCode());

//UserServicesPojo_Update_A_User_Main actualdata= response3.as(UserServicesPojo_Update_A_User_Main.class);
        assertEquals(pojoUpdateAUserMain.getUsername(),"kutluyorum@cisco.com");
        assertEquals(pojoUpdateAUserMain.getId(),"106");
        assertEquals(pojoUpdateAUserMain.getEmail(),"kutluyorum@cisco.com");

    }


    @When("send the request and get the response with nonexistingID")
    public void sendTheRequestAndGetTheResponseWithNonexistingID() {

        UserServicesPojo_Update_A_User_Status pojoUpdateAUserStatus = new UserServicesPojo_Update_A_User_Status("1",
                "Active",
                "User account is activated and authorized to use the application by putcisco");

        UserServicesPojo_Update_A_User_Main pojoUpdateAUserMain = new UserServicesPojo_Update_A_User_Main("451234567899632785",
                "kutluyorum@cisco.com",
                "kutluyorum@cisco.com",
                "false",
                "1",
                pojoUpdateAUserStatus,
                "1715290785259464", "2", "5", "30",
                "3d2fbde1-d022-4107-9321-413380705457",
                "false","0XTCtTL9jS0CNqb",
                "false","true", "true", "2024-05-20T05:03:31.360571Z",
                "2024-05-20T19:09:02.471368Z"
        );

        response= given(spec).
                body(pojoUpdateAUserMain).
                contentType(ContentType.JSON).
                when().
                put("/{firstPath}/{secondPath}");

        response.prettyPrint();

        System.out.println("response3.statusCode() = " + response.statusCode());




    }

    @Then("user assert the user is updated as expected with nonexistingID")
    public void userAssertTheUserIsUpdatedAsExpectedWithNonexistingID() {

        assertEquals(404,response.statusCode());

//UserServicesPojo_Update_A_User_Main actualdata= response3.as(UserServicesPojo_Update_A_User_Main.class);






    }

    @Given("user set the url for users list with {string} and with no readall permission")
    public void userSetTheUrlForUsersListWithAndWithNoReadallPermission(String groupid) {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("first", "v1", "second", "user-group","third",groupid,"fourth","user");



    }

    @When("user send the request and get the response for users list  without readall permission")
    public void userSendTheRequestAndGetTheResponseForUsersListWithoutReadallPermission() {
        response = given(spec).get("/{first}/{second}/{third}/{fourth}");
        System.out.println("response.statusCode() = " + response.statusCode());




    }

    @Then("user assert the status code is {int}")
    public void userAssertTheStatusCodeIs(int arg0) {
        assertEquals(403,response.statusCode());



    }

    @Given("user set the url for one user {string}")
    public void userSetTheUrlForOneUser(String userid) {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("first", "v1", "second", "user","third",userid);
        commonuserid=userid;


    }

    @When("user send the request and get the response for one user")
    public void userSendTheRequestAndGetTheResponseForOneUser() {
        response = given(spec).get("/{first}/{second}/{third}");
        responsetxt= response.body().asString();
        System.out.println("responsetxt = " + responsetxt);


    }

    @Then("user assert the user is shown up succesfull")
    public void userAssertTheUserIsShownUpSuccesfull() {
        assertEquals(200,response.statusCode());
        assertTrue(responsetxt.contains(commonuserid));
        //response.then().assertThat().body("id", equalTo(commonuserid));



    }

    @Given("user set the url for delete one user {string}")
    public void userSetTheUrlForDeleteOneUser(String userid) {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("first","user", "second",userid);


    }

    @When("user send the request and get the response for delete one user")
    public void userSendTheRequestAndGetTheResponseForDeleteOneUser() {

        response=given(spec).contentType(ContentType.JSON).delete("/{first}/{second}");


    }

    @Then("user assert the user is deleted succesfully")
    public void userAssertTheUserIsDeletedSuccesfully() {
        assertEquals(200,response.statusCode());


    }

    @Then("user assert the status code is user not found")
    public void userAssertTheStatusCodeIsUserNotFound() {
        assertEquals(404,response.statusCode());

    }

    @Given("user set the url to update a user")
    public void userSetTheUrlToUpdateAUser() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("firstPath", "v1", "secondPath", "user");



    }

    @Given("user sets the url to create a user")
    public void userSetsTheUrlToCreateAUser() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
        spec.pathParams("first","v1","second","organization","third","user","fourth","register-manual");

    }


    @When("send the request and get the response to create a user")
    public void sendTheRequestAndGetTheResponseToCreateAUser() {
        response=given(spec).body(postPojo).contentType(ContentType.JSON).post("/{first}/{second}/{third}/{fourth}");
        response.prettyPrint();



    }

    @Then("user verifies that user is created succesfully")
    public void userVerifiesThatUserIsCreatedSuccesfully() {

        response.
                then().
                assertThat().statusCode(201). //
                body("email", equalTo(postPojo.getEmail())); //gonderdigim ve aldigim emailler ayni !





    }

    @Then("user verifies that user is not created and get not acceptable message")
    public void userVerifiesThatUserIsNotCreatedAndGetNotAcceptableMessage() {
        response.
                then().
                assertThat().statusCode(406).onFailMessage("Not Acceptable");



    }





}

