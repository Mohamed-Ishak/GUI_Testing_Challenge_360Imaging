package stepsForPassedTestCases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LogInPage;
import pages.AccountPage;
import pages.RegistrationPage;
import tests.TestBase;

public class PassedSteps extends TestBase {

    RegistrationPage registrationObject ;
    protected AccountPage accountObject ;
    protected LogInPage logInObject ;



    @Given("User is already open sign up page")
    public void user_is_already_open_sign_up_page() {
        registrationObject = new RegistrationPage(driver);

    }

    @When("User enter valid {string} and {string} for Names Fields")
    public void user_enter_valid_and_for_names_fields(String firstname, String lastname) {
        registrationObject.enterValidUserFirstNameAndLastName(firstname, lastname);
        boolean firstCharOfFirstName = Character.isUpperCase(firstname.charAt(0));
        boolean firstCharOfLastName = Character.isUpperCase(lastname.charAt(0));

        // Validation of first name must start with Capital letter
        try {
            Assert.assertTrue(firstCharOfFirstName,firstname);

        }catch (Exception e){
            System.out.println("First Name Should start with Capital letter" );
        }
        // Validation of last name must start with Capital letter
        try {
            Assert.assertTrue(firstCharOfLastName,lastname);

        }catch (Exception e){
            System.out.println("Last Name Should start with Capital letter" );
        }
        // Validation of last name must be differ from first name
        try {
            Assert.assertFalse(firstname.contentEquals(lastname));
        }catch (Exception e){
            System.out.println("Last Name Must be different from last name" );
        }



    }
    // Validation of mobile number  must be numbers only
    @When("User enter valid {string}")
    public void user_enter_valid(String mobileNumber) {
        registrationObject.enterValidMobileNumber(mobileNumber);
        registrationObject.enterValidMobileNumber(mobileNumber);
        try {
            char[] chars = mobileNumber.toCharArray();
            for (char c : chars) {
                Assert.assertTrue(Character.isDigit(c));
            }
        }catch (Exception e){
            System.out.println("Should be numbers only" + e.getMessage());
        }

    }

    @When("User enter valid {string} address")
    public void user_enter_valid_address(String email) {
        registrationObject.enterValidEmailAddress(email);
        System.out.println("Please verify your email check your Verification link ");
    }

    @When("user enter valid {string} and Confirm Password matched Password fields")
    public void user_enter_valid_and_for_password_fields(String pass) {
        registrationObject.enterValidPasswordAndConfirmPassword(pass);

        try {
            Assert.assertTrue(passValidation(pass));
        }catch (Exception e){
            System.out.println("Password must contains the following validation" +
                    "1- At least one capital letter" +
                    "2- At least one small letter" +
                    "3- At least one special character " +
                    "4- Not less than 6 digits " +
                    "5- Not exceeds 32 digits ");
        }

    }



    @When("User click on Sign Up button")
    public void user_click_on_sign_up_button() {
        registrationObject.scrollToBottom();
        registrationObject.clickOnSignUpButton();

    }

    @Then("user Registered Successfully Redirected to his account page")

    public void user_registered_successfully()  {
        accountObject = new AccountPage(driver);

        try {
            WebDriverWait wait = new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.titleContains("account"));
            Assert.assertTrue(accountObject.RegisteredUserName.isDisplayed());
            accountObject.selectLogOutFromDropDownList();
            logInObject = new LogInPage(driver);
            logInObject.signUpBtnInLoginPage.click();
        } catch (Exception e) {
            System.out.println("Exception error ");
        }
    }




    @Given("User already registered with valid email and password")
    public void user_already_registered_with_valid_email_and_password() throws InterruptedException {
        accountObject = new AccountPage(driver);
        accountObject.selectLogOutFromDropDownList();
        logInObject = new LogInPage(driver);
        logInObject.clickOnMyAccountDropDownListAndSelectLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        System.out.println("User already in Log in Page");
    }
    @When("User enter valid {string} and {string}")
    public void user_enter_valid_and(String email, String pass) {
      logInObject.verifyLoginWithValidEmailAndValidPassword(email,pass);

    }
    @When("User click on login button")
    public void user_click_on_login_button() {
     logInObject.loginBtn.click();
    }
    @Then("User Login Successfully and Redirected to his account page")
    public void user_login_successfully_and_redirected_to_his_account_page() {
        accountObject = new AccountPage(driver);
        Assert.assertTrue(accountObject.RegisteredUserName.isDisplayed());
    }

}
