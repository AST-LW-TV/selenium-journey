package selenium_scripts.e_commerce_automation;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverSnippet {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome"); // browser to run
        desiredCapabilities.setPlatform(Platform.MAC); // platform of the node mac, windows or android
        /*
            If normal case, we define driver,
            -> WebDriver driver=new ChromeDriver();
            but to run tests on the remote machine we use,
            -> WebDriver driver=new RemoteWebDriver(<IP of the node>,desired capabilities);
         */
        WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),desiredCapabilities);
        driver.get(" https://www.google.com");
    }
}
