package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By emailInputField = By.id("email");
    private By retrievePasswordButton = By.cssSelector("#form_submit i");
    private By emailSentConfirmationText = By.id("content");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }

    public void clickRetrievePasswordButton() {
        driver.findElement(retrievePasswordButton).click();
    }

    public String emailSentGetText() {
        return driver.findElement(emailSentConfirmationText).getText();
    }


}
