import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class WindowHandle {
    private static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        driver = new ChromeDriver();
        driver.get("https://www.msn.com/");
        driver.manage().window().maximize();

        String parentTab = driver.getWindowHandle();
        System.out.println("Current tab ID = " + parentTab);
        System.out.println("Current tab title = " + driver.getTitle());

        System.out.println("============ Opening new tab ==================");

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com/");
        String childTab = driver.getWindowHandle();
        System.out.println("Current tab ID = " + childTab);
        System.out.println("Current tab title = " + driver.getTitle());

        System.out.println("============ Closing new tab ==================");
        driver.close();

        System.out.println("Switching back to parent tab");

        driver.switchTo().window(parentTab);
        System.out.println("Current tab ID = " + parentTab);
        System.out.println("Current tab title = " + driver.getTitle());


        driver.quit();
    }

}
