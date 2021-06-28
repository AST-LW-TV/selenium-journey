package selenium_scripts.e_commerce_automation;

import org.openqa.selenium.WebDriver;
import utilities.InitializeDriver;

import java.util.concurrent.TimeUnit;

public class Registering {

    /**
     * initializer block
     */

    {
        GetDetails getDetails = new GetDetails(0);

        WebDriver driver = InitializeDriver.initializeDriver("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Access access = new Access();
        InputDetails inputDetails = new InputDetails();
        SelectingItems selectingItems = new SelectingItems();
        CheckOut checkout = new CheckOut();

        // Sign In New customer
        access.login(driver);
        if (inputDetails.checkHeader(driver, "authentication")) {
            if (!(inputDetails.emailError(driver))) {
                inputDetails.enterEmail(driver);
                inputDetails.clickRegisterButton(driver);
                if (inputDetails.checkHeader(driver)) {
                    inputDetails.enterCustomerDetails(driver);
                    access.logout(driver);
                }
            }
        }
        driver.quit();

    }

}
