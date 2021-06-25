package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitializeDriver {

    public static WebDriver initializeDriver(String url){
        WebDriverManager.chromedriver().setup(); // chrome driver setup using webdriver manager
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        return driver;
    }

}
