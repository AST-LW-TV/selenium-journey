package selenium_scripts.e_commerce_automation;

import org.openqa.selenium.WebDriver;
import selenium_scripts.e_commerce_automation.Utilities.Config;
import selenium_scripts.e_commerce_automation.Utilities.Utility;
import selenium_scripts.e_commerce_automation.pages.CheckOutPage;
import selenium_scripts.e_commerce_automation.pages.HomePage;

public class StartAutomation {
    public static boolean start(String browserValue, String statusValue) {
        boolean flag = false;
        String browser = browserValue; // get the browser value
        String customerType = statusValue; // get the customer value
        String url = Config.getValue("url"); // get the url value
        WebDriver driver = Utility.startBrowser(browser, url); // starting the browser
        if (customerType.equals("notRegistered")) {
            try {
                new HomePage(driver, customerType);  // call the HomePage class
                flag = true;
            } catch (Exception e) {
                flag = false;
            }

        } else if (customerType.equals("registered")) {
            try {
                new HomePage(driver, customerType);
                CheckOutPage checkOut = new CheckOutPage(driver); // initialization of check out page object
                checkOut.pay(); // calling the pay method of check out page class
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
        }
        driver.quit();
        return flag;  // returns true if everything is proper...
    }
}
