package selenium_scripts.e_commerce_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_scripts.e_commerce_automation.Utilities.GetDetails;
import selenium_scripts.e_commerce_automation.Utilities.PageReference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoginPage {

    private class Access extends PageReference {

        public Access(WebDriver driver) {
            super(driver);
        }

        @FindBy(id = "email")
        WebElement email;

        @FindBy(id = "passwd")
        WebElement password;

        @FindBy(id = "SubmitLogin")
        WebElement submitButton;

        @FindBy(className = "login")
        WebElement login;

        @FindBy(css = ".logout")
        WebElement logOut;

        private void login() {
            this.login.click();
        }

        private void login(String email, String password) {
            this.email.sendKeys(email);
            this.password.sendKeys(password);
            this.submitButton.click();
        }

        private void logOut() {
            this.logOut.click();
        }
    }

    private class InputDetails extends PageReference {

        public InputDetails(WebDriver driver) {
            super(driver);
        }

        GetDetails getDetails = new GetDetails(0);

        @FindBy(xpath = "//h1[@class='page-heading']")
        WebElement pageHeading;

        @FindBy(id = "create_account_error")
        WebElement emailErrorMessage;

        @FindBy(id = "email_create")
        WebElement email;

        @FindBy(id = "SubmitCreate")
        WebElement registerButton;

        @FindBy(xpath = "//div[@class='clearfix']/label")
        WebElement title;

        @FindBy(name = "id_gender")
        List<WebElement> gender;

        @FindBy(xpath = "//label[@for='customer_firstname']")
        WebElement firstName;

        @FindBy(id = "customer_firstname")
        WebElement firstNameInputField;

        @FindBy(xpath = "//label[@for='customer_lastname']")
        WebElement lastName;

        @FindBy(id = "customer_lastname")
        WebElement lastNameInputField;

        @FindBy(xpath = "//label[@for='email']")
        WebElement emailWhileRegistering;

        @FindBy(id = "email")
        WebElement emailInputField;

        @FindBy(xpath = "//label[@for='passwd']")
        WebElement password;

        @FindBy(id = "passwd")
        WebElement passwordInputField;

        @FindBy(id = "days")
        WebElement daySelector;

        @FindBy(id = "months")
        WebElement monthSelector;

        @FindBy(id = "years")
        WebElement yearSelector;

        @FindBy(id = "newsletter")
        WebElement newsLetter;

        @FindBy(id = "optin")
        WebElement offers;

        @FindBy(xpath = "//label[@for='firstname']")
        WebElement addressFirstName;

        @FindBy(id = "firstname")
        WebElement addressFirstNameInputField;

        @FindBy(xpath = "//label[@for='lastname']")
        WebElement addressLastName;

        @FindBy(id = "lastname")
        WebElement addressLastNameInputField;

        @FindBy(xpath = "//label[@for='company']")
        WebElement addressCompanyName;

        @FindBy(id = "company")
        WebElement addressCompanyInputField;

        @FindBy(xpath = "//label[@for='address1']")
        WebElement addressAddress1;

        @FindBy(id = "address1")
        WebElement addressAddress1InputField;

        @FindBy(xpath = "//label[@for='address2']")
        WebElement addressAddress2;

        @FindBy(id = "address2")
        WebElement addressAddress2InputField;

        @FindBy(xpath = "//label[@for='city']")
        WebElement city;

        @FindBy(id = "city")
        WebElement cityInputField;

        @FindBy(id = "id_state")
        WebElement stateSelector;

        @FindBy(xpath = "//label[@for='postcode']")
        WebElement postCode;

        @FindBy(id = "postcode")
        WebElement postCodeInputField;

        @FindBy(id = "id_country")
        WebElement countrySelector;

        @FindBy(xpath = "//label[@for='other']")
        WebElement additionalInformation;

        @FindBy(id = "other")
        WebElement additionalInformationInputField;

        @FindBy(xpath = "//label[@for='phone']")
        WebElement homePhone;

        @FindBy(id = "phone")
        WebElement homePhoneInputField;

        @FindBy(xpath = "//label[@for='phone_mobile']")
        WebElement mobilePhone;

        @FindBy(id = "phone_mobile")
        WebElement mobilePhoneInputField;

        @FindBy(xpath = "//label[@for='alias']")
        WebElement aliasAddress;

        @FindBy(id = "alias")
        WebElement aliasAddressInputField;

        @FindBy(id = "submitAccount")
        WebElement submitButton;

        /**
         * This method searches the partial key in json file if found returns value
         *
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

        private void inputing(WebElement element_1, WebElement element_2) {
            String key = element_1.getText();
            key = search(key);
            element_2.clear();
            element_2.sendKeys(key);
        }

        private void selecting(WebElement element) {
            String key = element.getAttribute("id");
            key = search(key);
            Select selecting = new Select(element);
            selecting.selectByValue(key);
        }

        public boolean checkHeader(String stringToMatch) {
            return this.pageHeading.getText().equalsIgnoreCase(stringToMatch);
        }

        public boolean checkHeader(WebDriver driver) {
            By formLocator = By.id("account-creation_form");
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));
            return this.pageHeading.getText().equalsIgnoreCase("create an account");
        }

        public boolean emailError() {
            return this.emailErrorMessage.isDisplayed();
        }

        public void enterEmailAndSubmit() {
            this.email.clear();
            this.email.sendKeys(getDetails.getKey("email"));
            this.registerButton.click();

        }

        public void enterCustomerDetails(WebDriver driver) {
            Map<String, String> lookUp = new HashMap<>();
            lookUp.put("male", "1");
            lookUp.put("female", "2");
            String title = this.title.getText().trim().toLowerCase();
            String gender = getDetails.getKey(title);
            List<WebElement> genderElements = this.gender;
            String number = lookUp.get(gender).equals(genderElements.get(0).getAttribute("value")) ? "1" : "2";
            driver.findElement(By.id("id_gender" + number)).click();
            inputing(this.firstName, this.firstNameInputField);
            inputing(this.lastName, this.lastNameInputField);
            inputing(this.emailWhileRegistering, this.emailInputField);
            inputing(this.password, this.passwordInputField);
            selecting(this.daySelector);
            selecting(this.monthSelector);
            selecting(this.yearSelector);
            this.newsLetter.click();
            offers.click();
            inputing(this.addressFirstName, addressFirstNameInputField);
            inputing(this.addressLastName, addressLastNameInputField);
            inputing(this.addressCompanyName, addressCompanyInputField);
            inputing(this.addressAddress1, addressAddress1InputField);
            inputing(this.addressAddress2, addressAddress2InputField);
            inputing(this.city, cityInputField);
            selecting(this.stateSelector);
            inputing(this.postCode, postCodeInputField);
            selecting(countrySelector);
            inputing(this.additionalInformation, additionalInformationInputField);
            inputing(this.homePhone, homePhoneInputField);
            inputing(this.mobilePhone, mobilePhoneInputField);
            inputing(this.aliasAddress, aliasAddressInputField);
            this.submitButton.click();
        }
    }

    public void registerCustomer(WebDriver driver) {
        Access access = new Access(driver);
        InputDetails inputDetails = new InputDetails(driver);
        access.login();
        if (inputDetails.checkHeader("authentication")) {
            if (!(inputDetails.emailError())) {
                inputDetails.enterEmailAndSubmit();
                if (inputDetails.checkHeader(driver)) {
                    inputDetails.enterCustomerDetails(driver);
                    access.logOut();
                }
            }
        }
        driver.quit();
    }

    public void registeredCustomer(WebDriver driver) {
        GetDetails getDetails = new GetDetails(0);
        Access access = new Access(driver);
        access.login();
        access.login(getDetails.getKey("email"), getDetails.getKey("password"));
    }
}
