package selenium_scripts.e_commerce_automation.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Utility {

    public static WebDriver startBrowser(String browser, String url) {
        boolean temp = browser.equals("chrome");
        String mode = Config.getValue("mode");
        WebDriver driver;
        (temp ? WebDriverManager.chromedriver() :
                WebDriverManager.firefoxdriver()).setup();
        if (temp) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--" + mode);
            driver = new ChromeDriver(options);
        } else {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--" + mode);
            driver = new FirefoxDriver(options);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }
}
