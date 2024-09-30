package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;

import static base_urls.A3MBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MembershipTypeServices {

    static Response response;

    @Given("Set the url and Send Get request for MemberShip Type Services \\({string})")
    public void set_the_url_and_Send_Get_request_for_member_ship_type_services(String endpoint) {
        response = given().spec(spec).when().get(endpoint);
        response.prettyPrint();
    }

    @When("Verify, that response size is {int}")
    public void verify_that_response_size_is(int expectedSize) {
        List<String> responseList = response.jsonPath().getList("$");
        System.out.println("ResponseList : " + responseList);
        assertEquals(expectedSize, responseList.size());

    }

    @Then("Verify, that the status code {int}")
    public void verify_that_the_status_code(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.statusCode());

    }

    @When("Verify, that response id's are '{int}','{int}'")
    public void verify_that_response_id_s_are(Integer id1, Integer id2) {
        List<Integer> ids = response.jsonPath().getList("id", Integer.class);
        System.out.println("Id's : " + ids);
        assertTrue(ids.contains(id1));
        assertTrue(ids.contains(id2));

    }

    @When("Verify, that response name's are 'Company Membership','Guest Membership'")
    public void verify_that_response_name_s_are_company_membership_guest_membership() {
        List<String> names = response.jsonPath().getList("name", String.class);
        System.out.println("Names : " + names);
        assertTrue(names.contains("Company Membership"));
        assertTrue(names.contains("Guest Membership"));

    }

    @When("Verify, that Company Membership has {int} and Guest Membership has {int} users")
    public void verify_that_Company_Membership_has_and_Guest_Membership_has_users(int companyroles, int guestroles) {

        response.then()
                .body("find { it.name == 'Company Membership' }.roles.size()", equalTo(companyroles));
        response.then()
                .body("find { it.name == 'Guest Membership' }.roles.size()", equalTo(guestroles));

    }

    @And("Verify, that Company Membership with Guest Membership has {int} users")
    public void verify_that_Company_Membership_with_Guest_Membership_has_users(int expectedUserCount) {

        int companyMembershipRoles = response.path("find { it.name == 'Company Membership' }.roles.size()");
        System.out.println("CompanyMembershipRole Size : " + companyMembershipRoles);

        int guestMembershipRoles = response.path("find { it.name == 'Guest Membership' }.roles.size()");
        System.out.println("GuestMembershipRole Size : " + guestMembershipRoles);

        int totalRoles = companyMembershipRoles + guestMembershipRoles;
        System.out.println("TotalRole Size : " + totalRoles);

        assertEquals(totalRoles, expectedUserCount);

    }

}
