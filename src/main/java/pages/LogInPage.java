package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends PageBase{


    public LogInPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @FindBy(name = "username")
    WebElement emailTxt ;

    @FindBy(name = "password")
    WebElement passwordTxt ;



    @FindBy(css = "button.btn.btn-primary.btn-lg.btn-block.loginbtn")
    public WebElement loginBtn ;


    @FindBy(css = "a.btn.btn-success.br25.btn-block.form-group")
     public WebElement signUpBtnInLoginPage ;

    @FindBy(css = "a.btn.btn-warning.br25.btn-block")
     WebElement forgetPasswordBtn ;

    @FindBy(css = "div.col-md-8.col-9.o1")
    public WebElement container ;

    @FindBy(css = "div.dropdown.dropdown-login.dropdown-tab")
    WebElement container2 ;

    @FindBy(css = "div.dropdown-menu.dropdown-menu-right.show")
    WebElement container3 ;

    @FindBy(css = "div[class='']")
    WebElement container4 ;

    @FindBy(linkText= "Login")
    public WebElement loginTxt ;

    @FindBy(id = "resetemail")
    public WebElement restEmailTxt ;




    public void clickOnMyAccountDropDownListAndSelectLogin(){

        actions.moveToElement(container).moveToElement(container2).click().build().perform();
        actions.moveToElement(container3).moveToElement(container4).click(loginTxt).click().build().perform();

    }


    public void verifyLoginWithValidEmailAndValidPassword(String email , String password){

        setElementText(emailTxt,email);
        setElementText(passwordTxt,password);
        clickButton(loginBtn);
    }

    public void clickOnForgetPassword(){

        clickButton(forgetPasswordBtn);

    }

    public void enterEmailAddress(String email){
        setElementText(restEmailTxt,email);
    }

 //

}
