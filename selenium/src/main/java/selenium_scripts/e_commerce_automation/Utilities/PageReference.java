package selenium_scripts.e_commerce_automation.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// page reference functionality
public class PageReference {
    /**
     * this method considers the reference to the page object
     * @param driver
     */
    public PageReference(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
