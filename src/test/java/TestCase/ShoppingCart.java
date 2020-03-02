package TestCase;

import Pages.*;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class ShoppingCart extends BaseFile2 {

    @Test(groups = {"PromoCode"})
    public void EmptyPromoFieldErrorMessage() {
        test = extent.createTest("EmptyPromoFieldErrorMessage");
        test.log(Status.INFO, "Opening Browser");
        HomePageObject.AcceptCookies(driver).click();
        test.log(Status.INFO, "Clicked on accept cookies button");
        ShoopingCartPageObject.Cart(driver).click();
        ShoopingCartPageObject.ApplyCodeButton(driver).click();
        String ActualErrorMessage = ShoopingCartPageObject.EmptyPromoCodeErrorMessage(driver).getText();
        System.out.println(ActualErrorMessage);
        String ExpecrtedErrorMessage = "Please provide a valid Promotional Code";
        Assert.assertEquals(ActualErrorMessage, ExpecrtedErrorMessage);
    }



    @Test(groups = {"PromoCode"})
    public void PromoCodeAlreadyAppliedErrorMessage() throws NoSuchMethodException {
        test = extent.createTest("Verify Checkout using paypal");
        test.log(Status.INFO, "Opening Browser");
        HomePageObject.AcceptCookies(driver).click();
        test.log(Status.INFO, "Clicked on accept cookies button");
        ShoopingCartPageObject.Cart(driver).click();
        ShoopingCartPageObject.PromoCodeField(driver).sendKeys("ko12d40");
        ShoopingCartPageObject.ApplyCodeButton(driver).click();
        ShoopingCartPageObject.PromoAppliedConfirmation(driver);
        ShoopingCartPageObject.PromoCodeField(driver).sendKeys("ko12d40");
        ShoopingCartPageObject.ApplyCodeButton(driver).click();
        String ActualErrorMessage =ShoopingCartPageObject.AlreadyAppliedErrorMessage(driver).getText();
        System.out.println(ActualErrorMessage);
        String ExpecrtedErrorMessage="Promotion Code is already applied.";
        Assert.assertEquals(ActualErrorMessage, ExpecrtedErrorMessage);
    }

    @Test(groups = {"PromoCode"})
    public void InvalidPromoCodeErrorMessage() throws NoSuchMethodException {
        test = extent.createTest("Verify Checkout using paypal");
        test.log(Status.INFO, "Opening Browser");
        HomePageObject.AcceptCookies(driver).click();
        test.log(Status.INFO, "Clicked on accept cookies button");
        ShoopingCartPageObject.Cart(driver).click();
        ShoopingCartPageObject.PromoCodeField(driver).sendKeys("ThisisInvalidPromocode123");
        ShoopingCartPageObject.ApplyCodeButton(driver).click();
        if (ShoopingCartPageObject.PromoAppliedConfirmation(driver)==true)
            System.out.println("This TC should fail");
        System.out.println(ShoopingCartPageObject.PromoAppliedConfirmation(driver));
        String ActualErrorMessage =ShoopingCartPageObject.InvalidpromoCodeErrorMessage(driver).getText();
        System.out.println(ActualErrorMessage);
        String ExpecrtedErrorMessage="We're sorry but we don't recognize that Promotional Code. Please try using a different code.";
        Assert.assertEquals(ActualErrorMessage, ExpecrtedErrorMessage);
    }

    @Test(groups = {"PromoCode"})
    public void PromoCodeNotValidForTheItem()  {
        test = extent.createTest("Verify Checkout using paypal");
        test.log(Status.INFO, "Opening Browser");
        HomePageObject.AcceptCookies(driver).click();
        test.log(Status.INFO, "Clicked on accept cookies button");
        SearchPageObject.Search(driver).sendKeys("K-9996-0"+ Keys.ENTER);
        PDPpageObject.Addtocart(driver).click();
        Add_To_CartPageObject.ViewCart(driver).click();
        ShoopingCartPageObject.PromoCodeField(driver).sendKeys("Mirror25");
        ShoopingCartPageObject.ApplyCodeButton(driver).click();
        String ActualErrorMessage =ShoopingCartPageObject.PromoCodeNotValidForItem(driver).getText();
        System.out.println(ActualErrorMessage);
        String ExpecrtedErrorMessage="We're sorry but that Promotional Code is not valid for the items in your cart. Please try using a different code.";
        Assert.assertEquals(ActualErrorMessage, ExpecrtedErrorMessage);
    }

    @Test(groups = {"PromoCode"})
    public void ValidPromoCode() throws InterruptedException {
        test = extent.createTest("Verify Checkout using paypal");
        test.log(Status.INFO, "Opening Browser");
        HomePageObject.AcceptCookies(driver).click();
        test.log(Status.INFO, "Clicked on accept cookies button");
        SearchPageObject.Search(driver).sendKeys("K-9996-0"+ Keys.ENTER);
        PDPpageObject.Addtocart(driver).click();
        Add_To_CartPageObject.ViewCart(driver).click();
        ShoopingCartPageObject.PromoCodeField(driver).sendKeys("ko12d40");
        ShoopingCartPageObject.ApplyCodeButton(driver).click();
        Thread.sleep(2000);
        String priceAfterPromoCode=ShoopingCartPageObject.DiscountedPrice(driver).getText();
        String ExpectedpriceAfterpromoCode="$403.83";
        Assert.assertEquals(priceAfterPromoCode,ExpectedpriceAfterpromoCode);

        String ActualDiscountedOFF =ShoopingCartPageObject.PercentageOFF(driver).getText();
        String ExpectedDiscountedOFF="40% OFF";
        Assert.assertEquals(ActualDiscountedOFF,ExpectedDiscountedOFF);

        ShoopingCartPageObject.RemovePromo(driver).isDisplayed();

        if (ShoopingCartPageObject.PromoAppliedConfirmation(driver))
            System.out.println("Coupon applied");
        //a[@id='removePromo']
    }
    @Test(groups = {"PromoCode"})
    public void EmptyCartMessage() throws InterruptedException {
        test = extent.createTest("Verify Checkout using paypal");
        test.log(Status.INFO, "Opening Browser");
        HomePageObject.AcceptCookies(driver).click();
        test.log(Status.INFO, "Clicked on accept cookies button");
        SearchPageObject.Search(driver).sendKeys("K-9996-0" + Keys.ENTER);
        PDPpageObject.Addtocart(driver).click();
        Add_To_CartPageObject.ViewCart(driver).click();
        ShoopingCartPageObject.PromoCodeField(driver).sendKeys("ko12d40");
        ShoopingCartPageObject.ApplyCodeButton(driver).click();
        Thread.sleep(2000);
        ShoopingCartPageObject.RemoveLink(driver).click();
        String ActualMessage =ShoopingCartPageObject.CatEmptyMessage(driver).getText();
        String ExpectedMessage =" Your cart is empty. Add items to checkout.";
        Assert.assertEquals(ActualMessage,ExpectedMessage);
    }
    @Test(groups = {"PromoCode"})
    public void RemovePromo() throws InterruptedException {
        test = extent.createTest("Verify Checkout using paypal");
        test.log(Status.INFO, "Opening Browser");
        HomePageObject.AcceptCookies(driver).click();
        test.log(Status.INFO, "Clicked on accept cookies button");
        SearchPageObject.Search(driver).sendKeys("K-9996-0" + Keys.ENTER);
        PDPpageObject.Addtocart(driver).click();
        Add_To_CartPageObject.ViewCart(driver).click();
        ShoopingCartPageObject.PromoCodeField(driver).sendKeys("ko12d40");
        ShoopingCartPageObject.ApplyCodeButton(driver).click();
        ShoopingCartPageObject.RemovePromo(driver).click();
        Thread.sleep(1000);
        String ActualPrice=ShoopingCartPageObject.DiscountedPrice(driver).getText();
        String ExpectedAfterRemovingPormoPrice="$673.05";
        Assert.assertEquals(ActualPrice,ExpectedAfterRemovingPormoPrice);

        String SubtotalPrince=ShoopingCartPageObject.Subtotal(driver).getText();
        Assert.assertEquals(SubtotalPrince,ExpectedAfterRemovingPormoPrice);

    }
    @Test
    public void UpdateQTY() throws InterruptedException {
        test = extent.createTest("Verify Checkout using paypal");
        test.log(Status.INFO, "Opening Browser");
        HomePageObject.AcceptCookies(driver).click();
        test.log(Status.INFO, "Clicked on accept cookies button");
        SearchPageObject.Search(driver).sendKeys("K-9996-0" + Keys.ENTER);
        PDPpageObject.Addtocart(driver).click();
        Add_To_CartPageObject.ViewCart(driver).click();
        ShoopingCartPageObject.UpdateQTY(driver).sendKeys(Keys.BACK_SPACE);
        ShoopingCartPageObject.UpdateQTY(driver).sendKeys("2");
        ShoopingCartPageObject.UpdateLink(driver).click();
    }
}
