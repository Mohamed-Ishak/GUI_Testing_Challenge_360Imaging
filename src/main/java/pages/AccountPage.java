package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class AccountPage extends PageBase{





    public AccountPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);

    }

    @FindBy(css = "h3.text-align-left")
    public WebElement RegisteredUserName ;


    @FindBy(css = "div.col-md-8.col-9.o1")
    public WebElement container ;

    @FindBy(css = "div.dropdown.dropdown-login.dropdown-tab")
    WebElement container2 ;

    @FindBy(css = "div.dropdown-menu.dropdown-menu-right.show")
    WebElement container3 ;

    @FindBy(css = "div[class='']")
    WebElement container4 ;

    @FindBy(linkText= "Logout")
    public WebElement logoutTxt ;





    public void selectLogOutFromDropDownList() throws InterruptedException {

         actions.moveToElement(container).moveToElement(container2).click().build().perform();
         actions.moveToElement(container3).moveToElement(container4).click(logoutTxt).build().perform();
         Thread.sleep(1000);


    }



}
