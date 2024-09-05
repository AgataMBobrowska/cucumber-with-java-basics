package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomePageDefinition {

    public static WebDriver driver;

    @Given("I navigate to the home page")
    public void i_navigate_to_the_home_page() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ejdrien\\Documents\\chromedriver\\chromedriver-win64\\chromedriver.exe");

        //Disable search engine choice screen
        options.addArguments("--disable-search-engine-choice-screen");

                driver = new ChromeDriver(options);
                driver.get("https://skleptest.pl/my-account/");
    }
    @When("Navigate to Forgot Password link")
    public void navigate_to_forgot_password_link() {
        driver.findElement(By.xpath("//a[contains(.,'Lost your password?')]")).click();
    }
    @Then("I should see forgot password page")
    public void i_should_see_forgot_password_page() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "My account – Generic Shop");
    }
}
