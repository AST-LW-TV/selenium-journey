package selenium_scripts.e_commerce_automation;

import org.openqa.selenium.WebDriver;
import utilities.InitializeDriver;

import java.util.concurrent.TimeUnit;

public class Registered {

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

        access.login(driver);
        // Sign In Existing customer
        access.login(driver, getDetails.getKey("email"), getDetails.getKey("password"));
        // adding to cart
        selectingItems.addWomenDressesToCart(driver);
        selectingItems.addToCart(driver);
        driver.navigate().back();
        selectingItems.addDressToCart(driver);
        selectingItems.addToCart(driver);
        driver.navigate().back();
        // checkout
        checkout.cart(driver);
        checkout.proceedToCheckOut(driver);
        checkout.proceedWithAddress(driver);
        checkout.termsOfService(driver);
        checkout.proceedWithCarrier(driver);
        checkout.paymentMethod(driver);
        checkout.confirmPayment(driver);
        driver.quit();

    }

}
