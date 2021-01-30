package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private WebDriver driver;
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.xpath("//button[@class='radius']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
}
