package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ForgotPasswordPage clickForgotPassword() {
        clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }

    public LoginPage clickFormAuthenticationLoginPage() {
        clickLink("Forgot Password");
        return new LoginPage(driver);
    }

    public SecureAreaPage clickSecureAreaPage() {
        clickLink("Form Authentication");
        return new SecureAreaPage(driver);
    }

    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
