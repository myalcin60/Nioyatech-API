package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojoDatas.ErrorPojo;
import pojoDatas.OrganizationServicePojo;
import utilities.ConfigReader;
import java.net.URISyntaxException;
import java.time.Duration;
import static base_urls.A3MBaseUrl.gsessionid;
import static base_urls.A3MBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class OrganizationServices {
    Response response;
    String orgId;
    @Given("the user sets url to {string} and sends a get request")
    public void theUserSetsUrlTo(String url) throws URISyntaxException, InterruptedException {
        buildUrl();
        switch (url) {
            case "get by app":
                int appId = Integer.parseInt(ConfigReader.getProperty("appId"));
                spec.pathParams("appPath", "application", "appId", appId, "orgPath", "organization");
                response = given().spec(spec).when().get("/{appPath}/{appId}/{orgPath}");
                break;
            case "get all":
                spec.pathParam("orgPath", "organization");
                response = given().spec(spec).when().get("/{orgPath}");
                break;
            case "get by id":
                orgId=getId();
                spec.pathParams("v1","v1","orgPath", "organization", "orgId", orgId,"summary","summary");
                response = given().spec(spec).when().get("/{v1}/{orgPath}/{orgId}/{summary}");
                break;
            case "invalid":
                spec.pathParams("v1", "v1", "orgPath", "invalidPath"); // Invalid URL
                response = given().spec(spec).when().get("/{v1}/{orgPath}");
        }

    }

    @Then("the user asserts that Status Code is {int}")
    public void theUserAssertsThatStatusCodeIs(int expectedStatusCode) {
        response.then().assertThat().statusCode(expectedStatusCode);
    }

    @Then("the user asserts that response body {string}")
    public void theUserAssertsThatResponseBody(String responseBody) {
        switch (responseBody){
        case "forGetById":
            OrganizationServicePojo organizationServicePojo = response.as(OrganizationServicePojo.class);
            assertTrue("Expected error body format", organizationServicePojo.getFounder_id() != 0 && organizationServicePojo.getNumber_of_applications() != 0);
            assertEquals(orgId, organizationServicePojo.getId());
            break;
        case "errorBody":
            ErrorPojo errorPojo = response.as(ErrorPojo.class);
            assertTrue("Expected error body format", errorPojo.getError() != null && errorPojo.getStatus() != null);
            break;
        default:
            assertTrue("Expected empty response body", response.getBody().asString().isEmpty());
    }}


    @And("the user asserts that {string}")
    public void theUserAssertsThatStatusCodeMessage(String codeMessage) {
        response.then().assertThat().statusLine(codeMessage);
    }




    private String getId() throws  InterruptedException {
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--headless"));
        driver.get(ConfigReader.getProperty("Url"));
        driver.findElement(By.xpath("//a[@class='login-button']")).click();
        driver.findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        driver.findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password")+ Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='link4']/a")));
        driver.findElement(By.xpath("//*[@id='link4']/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        String url = driver.getCurrentUrl();
        String[] parts = url.split("/");
        String lastPart = parts[parts.length - 1];
        driver.quit();
        return lastPart;
    }

    private void buildUrl(){
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();
    }


}