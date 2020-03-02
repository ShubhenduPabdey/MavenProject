package TestCase;
import Pages.*;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public  class CheckoutUsingCreditCard extends BaseFile2{
    @Test
    public void CheckoutUsingCreditCard() throws InterruptedException {
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
        if (!driver.getCurrentUrl().equalsIgnoreCase("https://ecom.qa2.us.kohler.com/us/?loginSuccessful=true")){
            driver.navigate().refresh();}
        SearchPageObject.Search(driver).sendKeys("K-9996-0"+ Keys.ENTER);
        test.log(Status.INFO, "Search K-9996-0");
        if (NewsletterPopUp.Subscribe(driver).isDisplayed())
            driver.findElement(By.xpath("//span[@class='signup-close']")).click();
        test.log(Status.INFO, "Closed Popup Modal");
        PDPpageObject.Addtocart(driver).click();
        test.log(Status.INFO, "Click Add To Cart Button");
        Add_To_CartPageObject.ViewCart(driver).click();
        test.log(Status.INFO, "Click View Cart");
        ShoopingCartPageObject.Checkout(driver).click();
        test.log(Status.INFO, "Click CheckoutButton");
        CheckoutPageObject.Continue(driver).click();
        test.log(Status.INFO, "Click Continue button");
        CheckoutPageObject.ContinueToPayment(driver).click();
        test.log(Status.INFO, "Click Continue button");
        CheckoutPageObject.CreditCardRaidoButton(driver).click();
        test.log(Status.INFO, "Selected Credit Cart Radio button");
        CheckoutPageObject.NameOnCard(driver).sendKeys("Shubhendu Pandey");
        test.log(Status.INFO, "Entered Name on Cart = Shubhendu Pandey");
        driver.switchTo().frame("eProtect-iframe");
        CheckoutPageObject.CardNum(driver).sendKeys("4111111111111111");
        test.log(Status.INFO, "Entered Cart No ");
        CheckoutPageObject.MonthDropDown(driver);
        test.log(Status.INFO, "Entered Month");
        CheckoutPageObject.YearDropDown(driver);
        test.log(Status.INFO, "Entered Year");
        CheckoutPageObject.CVV(driver).sendKeys("123");
        test.log(Status.INFO, "Entered CVV");
        driver.switchTo().defaultContent();
        CheckoutPageObject.ContinueToPlaceOrder(driver).click();
        test.log(Status.INFO, "Clicked Continue button");
        CheckoutPageObject.PlaceOrderButton(driver).click();
        test.log(Status.INFO, "Click Place Order Button");
    }
}

