package selenium_scripts.e_commerce_automation;

import org.openqa.selenium.WebDriver;
import selenium_scripts.e_commerce_automation.Utilities.Utility;
import selenium_scripts.e_commerce_automation.pages.CheckOutPage;
import selenium_scripts.e_commerce_automation.pages.HomePage;

import java.util.Scanner;

public class StartAutomation {

    public static void main(String args[]) {

        // REFACTORED CODE
        // Main method is StartAutomation class
        // - inputing the browser in which the automation to be done
        // - inputing the type of registered or not registered
        // - pages package
        //   - HomePage -> add to cart operation, coupling to LoginPage
        //   - LoginPage -> Authentication
        //   - CheckOutPage -> payment operation
        // - utilities package
        //   - details -> json file which has the customer info
        //   - GetDetails -> fetches the required data for automation
        //   - PageReference is the page factory
        //   - Utility -> starts the desired browser

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the browser : chrome / firefox...");
        String browser = input.nextLine();
        System.out.println("registered / notRegistered");
        String temp = input.nextLine();
        WebDriver driver = Utility.startBrowser(browser, "http://automationpractice.com/index.php");
        if (temp.equals("notRegistered"))
            new HomePage(driver, temp);
        else if (temp.equals("registered")) {
            new HomePage(driver, temp);
            CheckOutPage checkOut = new CheckOutPage(driver);
            checkOut.pay();
        }
    }
}
