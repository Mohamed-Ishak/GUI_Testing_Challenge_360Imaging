package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {


   public Select select ;
   public Actions actions ;
   public JavascriptExecutor js ;

    //parametrized Constructor
   public PageBase(WebDriver driver){

       PageFactory.initElements(driver,this);
   }

   protected static void clickButton(WebElement button){
       button.click();
   }

    protected static void setElementText(WebElement text ,String value){
        text.sendKeys(value);
    }




    public void scrollToBottom(){
        js.executeScript("scrollBy(0,1500)");
    }

}
