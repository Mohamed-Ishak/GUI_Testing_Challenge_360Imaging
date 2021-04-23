package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;


import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestBase extends AbstractTestNGCucumberTests {

   public static WebDriver driver ;


    @BeforeTest
    public void openDriver(){
      System.setProperty("webdriver.chrome.driver"
                ,System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe") ;
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      driver.navigate().to("https://www.phptravels.net/register");
    }


    @AfterTest()
    public void closeDriver(){
        driver.quit();
    }

    //take screenShot When Test case Fail and it to ScreenShot directory
   @AfterMethod
    public void screenShotOnFailure(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Take Screen Shot");
            Helper.captureScreenShot(driver, result.getName());
        }
   }

   // check that if the First name start with Upper case


    // check that password contain (Capital letter ,small letter ,special character)
      public static boolean passValidation(String complexPassword){

        if (complexPassword.length()>=6 && complexPassword.length()<=32){
            Pattern upperCase = Pattern.compile("[A-Z]");
            Pattern lowerCase = Pattern.compile("[a-z]");
            Pattern special  = Pattern.compile("[!@#$%&~]");


            Matcher hasUpperCase = upperCase.matcher(complexPassword);
            Matcher hasLowerCase = lowerCase.matcher(complexPassword);
            Matcher hasSpecialChar  = special.matcher(complexPassword);

            Assert.assertTrue(hasSpecialChar.find());
            Assert.assertTrue(hasUpperCase.find());
            Assert.assertTrue(hasLowerCase.find());
            return true;
        }
        return false ;
      }
}
