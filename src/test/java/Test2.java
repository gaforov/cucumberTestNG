import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test2 {
    private static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        driver = new EdgeDriver();
        driver.get("http://staging.asian-promotions.com/login");
        driver.manage().window().maximize();

        String pathToFile = "C:\\Users\\Gareni\\Pictures\\awesome.jpg";

        driver.findElement(By.name("email")).sendKeys("sgaforov@live.com");
        driver.findElement(By.name("password")).sendKeys("Test2020");
        driver.findElement(By.name("submit")).click();

        driver.findElement(By.xpath("//li[@class='sub-menu']")).click();  //Manage My Profile
        driver.findElement(By.name("image")).sendKeys(pathToFile); // passive upload
        driver.findElement(By.name("submit")).click(); //click save

    }
}
