import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.Set;

public class WindowHandles {
    private static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        driver = new ChromeDriver();
        driver.get("https://www.msn.com/");
        driver.manage().window().maximize();



        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com/");
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.yahoo.com/"); // change to WINDOW = same result
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com/");

        Set<String> windowTabs = driver.getWindowHandles();
        System.out.println("Number of tabs: " + windowTabs.size());
        windowTabs.forEach(System.out::println);

        for (String windowTab : windowTabs) {
            System.out.println("Current tab ID = " + windowTab);
            System.out.println("Current tab title = " + driver.getTitle());
            driver.switchTo().window(windowTab);

            if (driver.getTitle().equals("Google")) {  //for Yahoo BY.name is 'p' instead of 'q'
                driver.findElement(By.name("q")).sendKeys("News" + Keys.ENTER); // add this later for verification
                break;
            }
        }

//        driver.quit();

    }
}
