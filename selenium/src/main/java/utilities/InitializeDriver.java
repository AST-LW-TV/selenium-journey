package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitializeDriver {

    /**
     * This method is used to initialize the driver with the given url
     * @param url unified resource locator
     * @return driver instance
     */

    public static WebDriver initializeDriver(String url){
        WebDriverManager.chromedriver().setup(); // chrome driver setup using webdriver manager
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        return driver;
    }

}
