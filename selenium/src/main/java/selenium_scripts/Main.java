package selenium_scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.InitializeDriver;

public class Main {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        Proxy p=new Proxy();
        p.setHttpProxy("localhost:8888");
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(CapabilityType.PROXY,p);


        WebDriver driver=new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector("a[class='login']")).click();
        System.out.println(driver.findElement(By.id("create_account_error")).isDisplayed());
    }

}
