package selenium_scripts.e_commerce_automation.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class Utility {

    /**
     * this method starts the browser
     * @param browser - browser name
     * @param url - unified resource locator
     * @return driver
     */
    public static WebDriver startBrowser(String browser, String url) {
        boolean temp = browser.equals("chrome");
        String mode = Config.getValue("mode");
        WebDriver initialDriver;
        (temp ? WebDriverManager.chromedriver() :
                WebDriverManager.firefoxdriver()).setup(); // running the browser driver
        if (temp) {
            ChromeOptions options = new ChromeOptions(); // declaring the chrome browser, option object
            options.addArguments("--" + mode);
            initialDriver = new ChromeDriver(options); // chrome driver initialization
        } else {
            FirefoxOptions options = new FirefoxOptions(); // declaring the firefox browser, option object
            options.addArguments("--" + mode);
            initialDriver = new FirefoxDriver(options); // firefox driver initialization
        }

        Listeners listener = new Listeners();  // listener object
        EventFiringWebDriver driver = new EventFiringWebDriver(initialDriver); // catches the event
        driver.register(listener); // register the event

        driver.manage().window().maximize(); // maximizing the browser
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit wait for 10 seconds...
        driver.get(url); // fetch the url
        return driver;
    }
}
