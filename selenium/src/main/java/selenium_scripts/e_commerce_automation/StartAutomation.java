package selenium_scripts.e_commerce_automation;

import org.openqa.selenium.WebDriver;
import selenium_scripts.e_commerce_automation.Utilities.Config;
import selenium_scripts.e_commerce_automation.Utilities.Utility;
import selenium_scripts.e_commerce_automation.pages.CheckOutPage;
import selenium_scripts.e_commerce_automation.pages.HomePage;

public class StartAutomation {

    // Improvements:-
    // - implemented previous feedbacks
    // - Inputs from CLI is eliminated and used config file
    // - maximizing the browser window
    // - ScreenShot class that takes screenshot and stores in screenshots package
    // - added headless option in this task, in config.properties we have to mention type of mode of operation
    // - added the screenshot functionality before click event using web driver listener
    // - comments at important statements
    // - implemented tests for various automation cases,
    //   - browser - chrome, customer - not registered
    //   - browser - chrome, customer - registered
    //   - browser - firefox, customer - not registered
    //   - browser - firefox, customer - registered

    public static boolean start(){
        boolean flag=false;
        String browser = Config.getValue("browser"); // get the browser value
        String customerType = Config.getValue("typeOfCustomer"); // get the customer value
        String url = Config.getValue("url"); // get the url value
        WebDriver driver = Utility.startBrowser(browser, url); // starting the browser
        if (customerType.equals("notRegistered")){
            new HomePage(driver, customerType);  // call the HomePage class
            flag=true;
        }
        else if (customerType.equals("registered")) {
            new HomePage(driver, customerType);
            CheckOutPage checkOut = new CheckOutPage(driver); // initialization of check out page object
            checkOut.pay(); // calling the pay method of check out page class
            flag=true;
        }
        return flag;  // returns true if everything is proper...
    }

    public static void main(String[] args){
        start();
    }

}
