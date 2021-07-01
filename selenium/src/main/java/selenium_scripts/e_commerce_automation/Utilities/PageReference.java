package selenium_scripts.e_commerce_automation.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageReference {
    public PageReference(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
