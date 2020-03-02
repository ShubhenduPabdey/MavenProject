package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPageObject {
    public static WebElement element;

    public static WebElement Continue (WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,20);
        element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='/atg/commerce/order/purchase/ShippingGroupFormHandler.moveToDeliveryMethod']")));
        return element;
    }
    public static WebElement ContinueToPayment (WebDriver driver){
        element=driver.findElement(By.xpath("//input[@name='/atg/commerce/order/purchase/ShippingGroupFormHandler.deliveryMethod']"));
        return element;
    }
    public static WebElement OpenPaypal  (WebDriver driver){
        element=driver.findElement(By.xpath("//span[@class='paypal-button-content']"));
        return element;
    }
    public static WebElement PlaceOrderButton (WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,20);
        element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("placeOrderBtn")));
        return element;
    }
    public static WebElement CreditCardRaidoButton (WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,20);
        element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Credit Card')]")));
        return element;
    }
    public static WebElement NameOnCard (WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,20);
        element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name-on-card']")));
        return element;
    }
    public static WebElement CardNum (WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,20);
        element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNumber")));
        return element;
    }
    public static Select MonthDropDown (WebDriver driver){
        WebElement X=driver.findElement(By.id("expMonth"));
        Select dropP= new Select(X);
        dropP.selectByIndex(3);
        return dropP;
    }
    public static Select YearDropDown (WebDriver driver){
        WebElement X=driver.findElement(By.id("expYear"));
        Select drop= new Select(X);
        drop.selectByIndex(3);
        return drop;
    }
    public static WebElement CVV(WebDriver driver){
        element=driver.findElement(By.id("cvv"));
        return element;
    }
    public static WebElement ContinueToPlaceOrder (WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,20);
        element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='btn btn--primary btn--primary-flat btn--green col-full-sm col-5-md float-left-md marg-b-20-sm']")));
        return element;

    }




}


