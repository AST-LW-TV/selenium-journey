package selenium_scripts.e_commerce_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut {

    private By cartLocator = By.partialLinkText("Cart");
    private By proceedToCheckOut = By.cssSelector(".cart_navigation>a");
    private By termsOfService = By.id("cgv");
    private By paymentMethod = By.cssSelector("a[title='Pay by bank wire']");
    private By confirmPayment = By.cssSelector("p#cart_navigation  span");
    private By processAddress = By.name("processAddress");
    private By processCarrier = By.name("processCarrier");

    public void cart(WebDriver driver) {
        driver.findElement(cartLocator).click();
    }

    public void proceedToCheckOut(WebDriver driver) {
        driver.findElement(proceedToCheckOut).click();
    }

    public void proceedWithAddress(WebDriver driver) {
        driver.findElement(processAddress).click();
    }

    public void termsOfService(WebDriver driver) {
        driver.findElement(termsOfService).click();
    }

    public void proceedWithCarrier(WebDriver driver) {
        driver.findElement(processCarrier).click();
    }

    public void paymentMethod(WebDriver driver) {
        driver.findElement(paymentMethod).click();
    }

    public void confirmPayment(WebDriver driver) {
        driver.findElement(confirmPayment).click();
    }

}
