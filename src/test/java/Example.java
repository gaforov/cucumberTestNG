import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Example {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        driver = new ChromeDriver();
        driver.get("https://www.msn.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //One way to open new tab (Strangely, MSN worked, but Google didn't work)
//        String openLinkInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
//         driver.findElement(By.linkText("SPORTS")).sendKeys(openLinkInNewTab); // msn page

        //Another way to open a link in a new tab
        driver.findElement(By.linkText("SPORTS")).sendKeys(Keys.CONTROL, Keys.ENTER);

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com/");


        Set<String> tabs = driver.getWindowHandles();
        System.out.println("Number of tabs: " + tabs.size());
        tabs.forEach(System.out::println);

        for (String window : tabs) {
            System.out.println("Current window: " + window);
            driver.switchTo().window(window);
            System.out.println("Current window title: " + driver.getTitle());
        }


        //Third way using JS Executor
//        ((JavascriptExecutor) driver).executeScript("window.open('https://www.msn.com/en-us/sports','_blank');");
    }


}
