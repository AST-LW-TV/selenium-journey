package selenium_scripts.e_commerce_automation;

import org.openqa.selenium.WebDriver;
import selenium_scripts.e_commerce_automation.pages.HomePage;

public class StartAutomation {

    public static void main(String args[]){
        WebDriver driver=Utility.startBrowser("chrome","http://automationpractice.com/index.php");
        new HomePage(driver,"notRegistered");

    }

}
