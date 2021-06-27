package selenium_scripts.e_commerce_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Access {

    private WebDriver driver;

    By emailLocator=By.id("email");
    By passwordLocator=By.id("passwd");
    By submitButtonLocator=By.id("SubmitLogin");
    By loginLocator=By.className("login");
    By logOutLocator=By.cssSelector(".logout");


    public void login(WebDriver driver){
        driver.findElement(loginLocator).click();
    }

    public void login(WebDriver driver,String email,String password){
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
    }

    public void logout(WebDriver driver){
        driver.findElement(logOutLocator).click();
    }

}
