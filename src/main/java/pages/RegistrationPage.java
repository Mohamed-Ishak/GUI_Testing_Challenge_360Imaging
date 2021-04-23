package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase{


    public RegistrationPage(WebDriver driver) {
        super(driver);
        js= (JavascriptExecutor) driver;
    }



    @FindBy(name = "firstname")
    WebElement firstnameInputTxt ;

    @FindBy(name = "lastname")
    WebElement lastnameInputTxt ;

    @FindBy(name = "phone")
    WebElement phoneInputTxt ;

    @FindBy(name = "email")
    WebElement emailInputTxt ;

    @FindBy (name = "password")
    WebElement passwordInputTxt ;

    @FindBy(name = "confirmpassword")
    public WebElement confirmPassInputTxt ;

    @FindBy(css = "button.signupbtn.btn_full.btn.btn-success.btn-block.btn-lg")
    WebElement signUpBtn ;





   public void enterValidUserFirstNameAndLastName(String firstname , String lastname){
       setElementText(firstnameInputTxt,firstname);
       setElementText(lastnameInputTxt,lastname);
   }

   public  void enterValidMobileNumber(String mobileNo){
       setElementText(phoneInputTxt,mobileNo);
   }

   public void enterValidEmailAddress(String email){
       setElementText(emailInputTxt,email);
   }

   public void enterValidPasswordAndConfirmPassword(String password){
       setElementText(passwordInputTxt,password);
       setElementText(confirmPassInputTxt,password);
   }

   public void clickOnSignUpButton(){
        clickButton(signUpBtn);
   }



}
