package base_urls;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ConfigReader;



public class A3MBaseUrl {

 public static RequestSpecification spec;
 public static String gsessionid;

    static{


        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--headless"));
        driver.get(ConfigReader.getProperty("Url"));
        driver.findElement(By.xpath("//a[@class='login-button']")).click();
        //driver.findElement(By.linkText("login")).click();
        driver.findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        driver.findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password")+ Keys.ENTER);
       gsessionid=driver.manage().getCookieNamed("GSESSIONID").getValue();


        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ApiUrl"))
                .addHeader("Cookie","GSESSIONID="+gsessionid)
                .setContentType("application/json")
                .build();


    }

}
