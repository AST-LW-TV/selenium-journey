package selenium_scripts.e_commerce_automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_scripts.e_commerce_automation.Utilities.PageReference;


/*
    control transfer to LoginPage
    AddToCart functionality
 */
public class HomePage {
    public HomePage(WebDriver driver, String typeOfCustomer) {
        if (typeOfCustomer.equals("notRegistered")) {
            this.register(driver);
//            driver.quit();
        } else {
            this.login(driver);
            this.addItemsToCart(driver);
//            driver.quit();
        }
    }

    private class AddToCart extends PageReference {
        private WebDriver driver;

        public AddToCart(WebDriver driver) {
            super(driver);
            this.driver = driver;
        }

        @FindBy(xpath = "//a[@title='Women']")
        WebElement womenDressesLink;

        @FindBy(linkText = "Faded Short Sleeve T-shirts")
        WebElement womenDress;

        @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]/a[@title='Dresses']")
        WebElement dressesLink;

        @FindBy(linkText = "Printed Chiffon Dress")
        WebElement dress;

        @FindBy(name = "Submit")
        WebElement addToCart;

        @FindBy(css = ".icon-chevron-left")
        WebElement continueShopping;

        public void addToCart(WebDriver driver, WebElement elementLink, WebElement element) {
            elementLink.click();
            element.click();
            this.addToCart();
            driver.navigate().back();
        }

        public void addToCart() {
            this.addToCart.click();
            try {
                this.continueShopping.click(); // statement works in chrome but throws error when executed in firefox
            } catch (ElementNotInteractableException e) {
                By continueShoppingLocator = By.cssSelector(".icon-chevron-left");
                WebDriverWait wait = new WebDriverWait(driver, 5);
                WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingLocator));
                continueButton.click();
            }
        }
    }

    // transfer the control to login page - not registered column
    private void register(WebDriver driver) {
        LoginPage loginPage = new LoginPage();
        loginPage.registerCustomer(driver);
    }

    // transfer the control to login page  - registered column
    private void login(WebDriver driver) {
        LoginPage loginPage = new LoginPage();
        loginPage.registeredCustomer(driver);
    }

    // add items to cart functionality
    private void addItemsToCart(WebDriver driver) {
        AddToCart add = new AddToCart(driver);
        add.addToCart(driver, add.womenDressesLink, add.womenDress);
        add.addToCart(driver, add.dressesLink, add.dress);
    }
}
