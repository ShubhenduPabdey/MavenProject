package TestCase;
import Pages.LoginModalObject;
import TestCase.BaseFile2;
import Pages.HomePageObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.image.ShortLookupTable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestLogin extends BaseFile2 {
    //public static WebDriver driver;
    //public static ExtentReports extent;
    //public static ExtentHtmlReporter htmlReporter;
   // public static ExtentTest test;

    @Test(groups = "regression")
    public void VerifyValidLogin() throws InterruptedException {
        test = extent.createTest("Verify Valid Login");
        test.log(Status.INFO,"Opening Browser");
        HomePageObject.AcceptCookies(driver).click();
        test.log(Status.INFO,"Clicked on accept cookies button");
        LoginModalObject.SignIn(driver).click();
        test.log(Status.INFO,"Clicked on Sign in linked present on the header");
        LoginModalObject.EmailId(driver).sendKeys("shubhendu.pandey@iteego.com");
        test.log(Status.INFO,"Entered email");
        LoginModalObject.Password(driver).sendKeys("India123");
        test.log(Status.INFO,"Entered Password");
        LoginModalObject.SignInButton(driver).click();
        test.log(Status.INFO,"Clicked on SIGN IN button");
        Thread.sleep(2000);
        String ActualURL=driver.getCurrentUrl();
        String ExpectedURL="https://ecom.qa2.us.kohler.com/us/?loginSuccessful=true";
        boolean B=ActualURL.equalsIgnoreCase(ExpectedURL);
        System.out.println(B);
        if (B==false)
            System.out.println(B);
            driver.navigate().refresh();

        String ActualURL2=driver.getCurrentUrl();
        String ExpectedURL2="https://ecom.qa2.us.kohler.com/us/?loginSuccessful=true";
        boolean B2=ActualURL2.equalsIgnoreCase(ExpectedURL2);
        System.out.println(B);
        if (B2==true)
            System.out.println("Passed"+B2);
    }
    @Test
    public void InvalidPasswordLogin() throws InterruptedException, IOException {
        test = extent.createTest("Verify InValid Password Login");
        test.log(Status.INFO,"Opening Browser");
        HomePageObject.AcceptCookies(driver).click();
        test.log(Status.INFO,"Clicked on accept cookies button");
        LoginModalObject.SignIn(driver).click();
        test.log(Status.INFO,"Clicked on Sign in linked present on the header");
        LoginModalObject.EmailId(driver).sendKeys("shubhendu.pandey@iteego.com");
        test.log(Status.INFO,"Entered email");
        LoginModalObject.Password(driver).sendKeys("Invalid@123");
        test.log(Status.INFO,"Entered Invalid Password");
        LoginModalObject.SignInButton(driver).click();
        test.log(Status.INFO,"Clicked on SIGN IN button");
        String ActualErrorMessage=LoginModalObject.ErrorMessage(driver).getText();
        System.out.println(ActualErrorMessage);
        String ExpectedErrorMessage= "Authentication Failed. The username/password combination was incorrect.";
        Assert.assertEquals(ActualErrorMessage,ExpectedErrorMessage);
        test.log(Status.INFO," Correct Error Message displays");
    }
    @Test
    public void InvalidEmaildLogin() throws InterruptedException, IOException {
        test = extent.createTest("Verify InValid Email Login");
        test.log(Status.INFO,"Opening Browser");
        HomePageObject.AcceptCookies(driver).click();
        test.log(Status.INFO,"Clicked on accept cookies button");
        LoginModalObject.SignIn(driver).click();
        test.log(Status.INFO,"Clicked on Sign in linked present on the header");
        LoginModalObject.EmailId(driver).sendKeys("incorrectemail.pandey@iteego.com");
        test.log(Status.INFO,"Entered email");
        LoginModalObject.Password(driver).sendKeys("India123");
        test.log(Status.INFO,"Entered Invalid Password");
        LoginModalObject.SignInButton(driver).click();
        test.log(Status.INFO,"Clicked on SIGN IN button");
        String ActualErrorMessage=LoginModalObject.ErrorMessage(driver).getText();
        System.out.println(ActualErrorMessage);
        String ExpectedErrorMessage= "Authentication failed. The username/password combination was incorrect.";
        Assert.assertEquals(ActualErrorMessage,ExpectedErrorMessage);
        test.log(Status.INFO," Correct Error Message displays");
    }

}

