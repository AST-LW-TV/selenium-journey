package selenium_scripts.e_commerce_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_scripts.e_commerce_automation.Access;
import selenium_scripts.e_commerce_automation.GetDetails;
import selenium_scripts.e_commerce_automation.InputDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoginPage {

    public class InputDetails {

        GetDetails getDetails = new GetDetails(0);

        private By pageHeadingLocator = By.xpath("//h1[@class='page-heading']");
        private By formLocator = By.id("account-creation_form");
        private By emailErrorMessageLocator = By.id("create_account_error");
        private By emailLocator = By.id("email_create");
        private By registerButtonLocator = By.id("SubmitCreate");
        private By titleLocator = By.xpath("//div[@class='clearfix']/label");
        private By genderLocator = By.name("id_gender");
        private By firstNameLocator = By.xpath("//label[@for='customer_firstname']");
        private By firstNameInputFieldLocator = By.id("customer_firstname");
        private By lastNameLocator = By.xpath("//label[@for='customer_lastname']");
        private By lastNameInputFieldLocator = By.id("customer_lastname");
        private By emailLocatorWhileRegistering = By.xpath("//label[@for='email']");
        private By emailInputField = By.id("email");
        private By passwordLocator = By.xpath("//label[@for='passwd']");
        private By passwordInputField = By.id("passwd");
        private By daySelector = By.id("days");
        private By monthSelector = By.id("months");
        private By yearSelector = By.id("years");
        private By newsletterLocator = By.id("newsletter");
        private By offersLocators = By.id("optin");
        private By addressFirstNameLocator = By.xpath("//label[@for='firstname']");
        private By addressFirstNameInputField = By.id("firstname");
        private By addressLastNameLocator = By.xpath("//label[@for='lastname']");
        private By addressLastNameInputField = By.id("lastname");
        private By addressCompanyNameLocator = By.xpath("//label[@for='company']");
        private By addressCompanyInputField = By.id("company");
        private By addressAddress1Locator = By.xpath("//label[@for='address1']");
        private By addressAddress1InputField = By.id("address1");
        private By addressAddress2Locator = By.xpath("//label[@for='address2']");
        private By addressAddress2InputField = By.id("address2");
        private By cityLocator = By.xpath("//label[@for='city']");
        private By cityInputField = By.id("city");
        private By stateSelector = By.id("id_state");
        private By postCodeLocator = By.xpath("//label[@for='postcode']");
        private By postCodeInputField = By.id("postcode");
        private By countrySelector = By.id("id_country");
        private By additionalInformationLocator = By.xpath("//label[@for='other']");
        private By additionalInformationInputField = By.id("other");
        private By homePhoneLocator = By.xpath("//label[@for='phone']");
        private By homePhoneInputField = By.id("phone");
        private By mobilePhoneLocator = By.xpath("//label[@for='phone_mobile']");
        private By mobilePhoneInputField = By.id("phone_mobile");
        private By aliasAddressLocator = By.xpath("//label[@for='alias']");
        private By aliasAddressInputField = By.id("alias");
        private By submitButtonLocator = By.id("submitAccount");

        /**
         * This method searches the partial key in json file if found returns value
         * @param stringToGetValue - (String type)
         * @return value of found key - (String)
         */
        private String search(String stringToGetValue) {
            Set<String> set = getDetails.getKeySet();
            String partial = stringToGetValue.toLowerCase().substring(0, 4);
            String value = null;
            for (String item : set) {
                if (item.contains(partial)) {
                    value = getDetails.getKey(item);
                    break;
                }
            }
            return value;
        }

        /**
         * this method inputs the characters in the input field
         * @param driver - (WebDriver)
         * @param locator_1 - (By)
         * @param locator_2 - (By)
         */
        private void inputing(WebDriver driver, By locator_1, By locator_2) {
            String key = driver.findElement(locator_1).getText();
            key = search(key);
            driver.findElement(locator_2).clear();
            driver.findElement(locator_2).sendKeys(key);
        }

        /**
         * this method selects the web elements on the web page
         * @param driver - (WebDriver)
         * @param locator - (By)
         */
        private void selecting(WebDriver driver, By locator) {
            String key = driver.findElement(locator).getAttribute("id");
            key = search(key);
            Select selecting = new Select(driver.findElement(locator));
            selecting.selectByValue(key);
        }

        public boolean checkHeader(WebDriver driver, String stringToMatch) {
            return driver.findElement(pageHeadingLocator).getText().equalsIgnoreCase(stringToMatch);
        }

        public boolean checkHeader(WebDriver driver) {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));
            return driver.findElement(pageHeadingLocator).getText().equalsIgnoreCase("create an account");
        }

        public boolean emailError(WebDriver driver) {
            return driver.findElement(emailErrorMessageLocator).isDisplayed();
        }

        public void enterEmail(WebDriver driver) {
            driver.findElement(emailLocator).clear();
            driver.findElement(emailLocator).sendKeys(getDetails.getKey("email"));
        }

        public void clickRegisterButton(WebDriver driver) {
            driver.findElement(registerButtonLocator).click();
        }

        public void enterCustomerDetails(WebDriver driver) {
            Map<String, String> lookUp = new HashMap<>();
            lookUp.put("male", "1");
            lookUp.put("female", "2");

            String title = driver.findElement(titleLocator).getText().trim().toLowerCase();

            String gender = getDetails.getKey(title);

            List<WebElement> genderElements = driver.findElements(genderLocator);
            String number = lookUp.get(gender).equals(genderElements.get(0).getAttribute("value")) ? "1" : "2";

            driver.findElement(By.id("id_gender" + number)).click();

            inputing(driver, firstNameLocator, firstNameInputFieldLocator);

            inputing(driver, lastNameLocator, lastNameInputFieldLocator);

            inputing(driver, emailLocatorWhileRegistering, emailInputField);

            inputing(driver, passwordLocator, passwordInputField);

            selecting(driver, daySelector);

            selecting(driver, monthSelector);

            selecting(driver, yearSelector);

            driver.findElement(newsletterLocator).click();

            driver.findElement(offersLocators).click();

            inputing(driver, addressFirstNameLocator, addressFirstNameInputField);

            inputing(driver, addressLastNameLocator, addressLastNameInputField);

            inputing(driver, addressCompanyNameLocator, addressCompanyInputField);

            inputing(driver, addressAddress1Locator, addressAddress1InputField);

            inputing(driver, addressAddress2Locator, addressAddress2InputField);

            inputing(driver, cityLocator, cityInputField);

            selecting(driver, stateSelector);

            inputing(driver, postCodeLocator, postCodeInputField);

            selecting(driver, countrySelector);

            inputing(driver, additionalInformationLocator, additionalInformationInputField);

            inputing(driver, homePhoneLocator, homePhoneInputField);

            inputing(driver, mobilePhoneLocator, mobilePhoneInputField);

            inputing(driver, aliasAddressLocator, aliasAddressInputField);

            driver.findElement(submitButtonLocator).click();
        }

    }


    public void register(WebDriver driver){
        GetDetails getDetails=new GetDetails(0);

        Access access = new Access();
        InputDetails inputDetails = new InputDetails();

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

//    public WebDriver login(WebDriver driver){
//        // code for login
//    }


}
