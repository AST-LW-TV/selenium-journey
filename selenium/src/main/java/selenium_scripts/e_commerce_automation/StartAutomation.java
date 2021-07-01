package selenium_scripts.e_commerce_automation;

import org.openqa.selenium.WebDriver;
import selenium_scripts.e_commerce_automation.Utilities.Utility;
import selenium_scripts.e_commerce_automation.pages.CheckOutPage;
import selenium_scripts.e_commerce_automation.pages.HomePage;

import java.util.Scanner;

public class StartAutomation {

    public static void main(String args[]) {
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
