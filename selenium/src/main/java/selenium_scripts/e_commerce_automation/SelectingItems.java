package selenium_scripts.e_commerce_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectingItems {

    Actions action;

    private By womenDressesLinkLocator = By.xpath("//a[@title='Women']");
    private By womenDressLocator = By.linkText("Faded Short Sleeve T-shirts");
    private By addToCartLocator = By.name("Submit");
    private By continueShoppingLocator = By.cssSelector(".icon-chevron-left");
    private By dressesLocator = By.xpath("//div[@id='block_top_menu']/ul/li[2]/a[@title='Dresses']");
    private By dressLocator = By.linkText("Printed Chiffon Dress");

    public void addWomenDressesToCart(WebDriver driver) {
        driver.findElement(womenDressesLinkLocator).click();
        action = new Actions(driver);
        action.moveToElement(driver.findElement(womenDressLocator)).click().build().perform();
    }

    public void addDressToCart(WebDriver driver) {
        driver.findElement(dressesLocator).click();
        driver.findElement(dressLocator).click();
    }

    public void addToCart(WebDriver driver) {
        driver.findElement(addToCartLocator).click();
        driver.findElement(continueShoppingLocator).click();
    }

}
