package TestCase;

import Pages.*;
import com.aventstack.extentreports.Status;
import com.mongodb.operation.DropIndexOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CheckoutUsingPaypal extends BaseFile2 {
    @Test(groups = {"Regression"})
    public void CheckoutPaypal() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test = extent.createTest("Verify Checkout using paypal");
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
        Thread.sleep(2000);
        if (!driver.getCurrentUrl().equalsIgnoreCase("https://ecom.qa2.us.kohler.com/us/?loginSuccessful=true"))
        driver.navigate().refresh();
        HomePageObject.BathroomMenu(driver).click();
        test.log(Status.INFO, "Open Bathroom menu");
        HomePageObject.ToiletSeat(driver).click();
        test.log(Status.INFO, "Click Toilet Seats link");
        HomePageObject.ShopAllToiletSeatsLink(driver).click();
        test.log(Status.INFO, "Clicked Shop All Button");
        HomePageObject.C3125ElongatedBidetToiletSeat(driver).click();
        test.log(Status.INFO, "Clicked on C3125ElongatedBidetToiletSeat item ");
        HomePageObject.AddToCartButton(driver).click();
        test.log(Status.INFO, "Clicked ADD TO CART button");
        Add_To_CartPageObject.ViewCart(driver).click();
        test.log(Status.INFO, "Clicked VIEW CART button");
        ShoopingCartPageObject.Checkout(driver).click();
        test.log(Status.INFO, "Clicked CHECKOUT button ");
        CheckoutPageObject.Continue(driver).click();
        test.log(Status.INFO, "Clicked on CONTINUE button");
        CheckoutPageObject.ContinueToPayment(driver).click();
        test.log(Status.INFO, "Clicked on CONTINUE button ");
        CheckoutPageObject.OpenPaypal(driver).click();
        test.log(Status.INFO, "Clicked on PAYPAL link");
        // Store your parent window
        String parent=driver.getWindowHandle();
        System.out.println("parent window id is"+parent);
        // This will return the number of windows opened by Webdriver and will return Set of Strings
        Set<String>AllWindow=driver.getWindowHandles();
        System.out.println(AllWindow.size());
        System.out.println("parent and child window id is"+AllWindow);
         // Now we will iterate using Iterator
            //Iterator<String> I1= AllWindow.iterator();
            for(String child_window:AllWindow)
            //while(I1.hasNext())
            {
              //  String child_window=I1.next();
               // Here we will compare if parent window is not equal to child window
                if(!parent.equalsIgnoreCase(child_window))
                {
                    driver.switchTo().window(child_window);
                    test.log(Status.INFO, "Switched to paypal");
                    System.out.println(driver.switchTo().window(child_window).getTitle());
                    PaypalPageObject.PaypalAcceptCookies(driver).click();
                    test.log(Status.INFO, "Accept cookies");
                    PaypalPageObject.PaypalEmail(driver).sendKeys("ravi.mandli@iteego.com");
                    test.log(Status.INFO, "Enter Email");
                    PaypalPageObject.EmailNextbutton(driver).click();
                    test.log(Status.INFO, "Clicked on next button");
                    PaypalPageObject.PaypalPassword(driver).sendKeys("S9xex)n5");
                    test.log(Status.INFO, "Enter Password");
                    PaypalPageObject.PaypalLoginButton(driver).click();
                    test.log(Status.INFO, "Clicked on Login button");
                    WebDriverWait wait=new WebDriverWait(driver,20);
                    Thread.sleep(20000);
                    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add a debit or credit card')]")));

                    //div[@class='css-k008qs euuuzg88']//span[text()='1002']

                    PaypalPageObject.PaypalConitinueButton(driver).click();
                    test.log(Status.INFO, "Clicked on Continue button");
                }
                driver.switchTo().window(parent);
            }
        CheckoutPageObject.PlaceOrderButton(driver).click();
        test.log(Status.INFO, "Clicked on PLACE ORDER button");
        }
    }

