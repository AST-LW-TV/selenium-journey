package selenium_scripts.e_commerce_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium_scripts.e_commerce_automation.Utilities.PageReference;

/*
    payment functionality
 */
public class CheckOutPage extends PageReference {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(partialLinkText = "Cart")
    WebElement cart;

    @FindBy(css = ".cart_navigation>a")
    WebElement proceedToCheckOut;

    @FindBy(id = "cgv")
    WebElement termsOfService;

    @FindBy(css = "a[title='Pay by bank wire']")
    WebElement paymentMethod;

    @FindBy(css = "p#cart_navigation  span")
    WebElement confirmPayment;

    @FindBy(name = "processAddress")
    WebElement processAddress;

    @FindBy(name = "processCarrier")
    WebElement processCarrier;

    private void cart() {
        this.cart.click();
    }

    private void proceedToCheckOut() {
        this.proceedToCheckOut.click();
    }

    private void proceedWithAddress() {
        this.processAddress.click();
    }

    private void termsOfService() {
        this.termsOfService.click();
    }

    private void proceedWithCarrier() {
        this.processCarrier.click();
    }

    private void paymentMethod() {
        this.paymentMethod.click();
    }

    private void confirmPayment() {
        this.confirmPayment.click();
    }

    // step by step payment functionality
    public void pay() {
        this.cart();
        this.proceedToCheckOut();
        this.proceedWithAddress();
        this.termsOfService();
        this.proceedWithCarrier();
        this.paymentMethod();
        this.confirmPayment();
    }
}
