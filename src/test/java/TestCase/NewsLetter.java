package TestCase;

import Pages.HomePageObject;
import Pages.LoginModalObject;
import Pages.NewsletterPopUp;
import Pages.SearchPageObject;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NewsLetter extends BaseFile2 {

    @Test
    public void Newsletter() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test = extent.createTest("Verify Checkout using Credit card");
        test.log(Status.INFO, "Opening Browser");
        HomePageObject.AcceptCookies(driver).click();
        test.log(Status.INFO, "Clicked on accept cookies button");
        LoginModalObject.SignIn(driver).click();
        test.log(Status.INFO, "Clicked on Sign in linked present on the header");
        LoginModalObject.EmailId(driver).sendKeys("shubhendu.pandey@iteego.com");
        test.log(Status.INFO, "Entered email");
        LoginModalObject.Password(driver).sendKeys("India123");
        test.log(Status.INFO, "Entered Password");
        LoginModalObject.SignInButton(driver).click();
        test.log(Status.INFO, "Clicked on SIGN IN button");
        if (!driver.getCurrentUrl().equalsIgnoreCase("https://ecom.qa2.us.kohler.com/us/?loginSuccessful=true")) {
            driver.navigate().refresh();
        }
        SearchPageObject.Search(driver).sendKeys("K-9996-0" + Keys.ENTER);
        if (NewsletterPopUp.Subscribe(driver).isDisplayed()) {
            NewsletterPopUp.Email(driver).sendKeys("shubhendu.pandey@iteego.com");
            NewsletterPopUp.ZipCode(driver).clear();
            NewsletterPopUp.ZipCode(driver).sendKeys("53044");
            NewsletterPopUp.Subscribe(driver).click();
            NewsletterPopUp.privacyPolicy(driver).click();
            String parent = driver.getWindowHandle();
            Set<String> AllWindow = driver.getWindowHandles();
            for (String child_window : AllWindow) {
                //  String child_window=I1.next();
                // Here we will compare if parent window is not equal to child window
                if (!parent.equalsIgnoreCase(child_window)) {
                    driver.switchTo().window(child_window);
                    Thread.sleep(2000);
                    driver.getCurrentUrl().equalsIgnoreCase("https://www.kohlercompany.com/privacy/");
                    driver.switchTo().window(parent);
                    //driver.switchTo().frame(0);
                    //driver.findElement(By.id("recaptcha-anchor"));

                }

            }
           NewsletterPopUp.NoThanks(driver).click();

        }
    }
}