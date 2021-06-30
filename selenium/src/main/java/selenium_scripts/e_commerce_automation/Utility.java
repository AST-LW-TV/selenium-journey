package selenium_scripts.e_commerce_automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Utility {

    public static WebDriver startBrowser(String browser,String url){
        boolean temp=browser.equals("chrome");
        (temp? WebDriverManager.chromedriver():
                WebDriverManager.firefoxdriver()).setup();
        WebDriver driver=temp?new ChromeDriver():new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }

}
