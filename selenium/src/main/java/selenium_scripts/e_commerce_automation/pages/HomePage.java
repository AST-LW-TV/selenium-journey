package selenium_scripts.e_commerce_automation.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

    LoginPage loginPage=new LoginPage();

    public HomePage(WebDriver driver,String typeOfCustomer){

        if(typeOfCustomer.equals("notRegistered"))
            this.register(driver);
        else
            this.login(driver);
    }

    private void register(WebDriver driver){
        loginPage.register(driver);
    }

    private void login(WebDriver driver){

    }

}
