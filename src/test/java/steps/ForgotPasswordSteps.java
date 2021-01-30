package steps;

import base.BaseTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordSteps extends BaseTest {
//    private WebDriver driver;

//    public ForgotPasswordSteps() {
//    }
    /**
     * Uncomment this and above private field, if you use just testNG without Cucumber, then make WebDriver field
     * as private, non-static inside BaseTest.
     */
//    public ForgotPasswordSteps(WebDriver driver) {
//        this.driver = driver;
//    }

    @Given("user is on website homepage")
    public void user_is_on_website_homepage() {
        System.out.println("User is on http://the-internet.herokuapp.com/ homepage");
    }

    @When("user clicks on forgot password link")
    public void user_clicks_on_forgot_password_link() {
        driver.findElement(By.linkText("Forgot Password")).click();
    }

    @And("user enters email address")
    public void user_enters_email_address() {
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
    }

    @When("user clicks on retrieve password button")
    public void user_clicks_on_retrieve_password_button() {
        driver.findElement(By.cssSelector("#form_submit i")).click();
    }

    @Then("user taken to confirmation page")
    public void user_taken_to_confirmation_page() {
        String actualText = driver.findElement(By.id("content")).getText();
        assertEquals(actualText, "Your e-mail's been sent!","Confirmation text is incorrect");
    }
}
