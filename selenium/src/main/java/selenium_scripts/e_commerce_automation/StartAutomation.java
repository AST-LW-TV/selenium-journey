package selenium_scripts.e_commerce_automation;

import org.openqa.selenium.WebDriver;
import selenium_scripts.e_commerce_automation.Utilities.Config;
import selenium_scripts.e_commerce_automation.Utilities.Utility;
import selenium_scripts.e_commerce_automation.pages.CheckOutPage;
import selenium_scripts.e_commerce_automation.pages.HomePage;

import java.io.IOException;

public class StartAutomation {

    // Inputs from CLI is eliminated and used config file
    // maximizing the browser window
    // ScreenShot class that takes screenshot and stores in screenshots package

    public static void main(String args[]) throws IOException {
        String browser = Config.getValue("browser");
        String customerType = Config.getValue("typeOfCustomer");
        String url = Config.getValue("url");
        WebDriver driver = Utility.startBrowser(browser, url);
        if (customerType.equals("notRegistered"))
            new HomePage(driver, customerType);
        else if (customerType.equals("registered")) {
            new HomePage(driver, customerType);
            CheckOutPage checkOut = new CheckOutPage(driver);
            checkOut.pay();
        }
    }
}
