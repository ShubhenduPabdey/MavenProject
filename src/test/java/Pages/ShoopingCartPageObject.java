package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoopingCartPageObject {
    private static WebElement element;

    public static WebElement Checkout(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='cart-checkout-button']")));
        return element;
    }

    public static WebElement ContinueShopping(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='cart-continue-shopping-button']")));
        return element;
    }

    public static WebElement PromoCodeField(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cart-promo-code-field']")));
        return element;
    }

    public static WebElement ApplyCodeButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cart-promo-code__apply-button']")));
        return element;
    }

    public static WebElement RemoveLink(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='order-detail-table__product-actions']//a[@id='removeItem']")));
        return element;
    }

    public static WebElement UpdateQTY(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='order-detail-table__qty-field newstyle']")));
        return element;
    }

    public static WebElement EmptyPromoCodeErrorMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='cart-promo-code-field']")));
        return element;
    }

    public static WebElement Cart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='main-nav__item--cart']")));
        return element;
    }

    public static WebElement AlreadyAppliedErrorMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='input__error']")));
        return element;
    }

    public static boolean PromoAppliedConfirmation(WebDriver driver){
       // WebDriverWait wait = new WebDriverWait(driver, 10);
        //element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='order-detail-table-summary__promo-label']")));
       // return element;
        try {
            driver.findElement(By.xpath("//span[@class='order-detail-table-summary__promo-label']"));
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }


    }
    public static WebElement InvalidpromoCodeErrorMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='input__error']")));
        return element;
    }

    public static WebElement PromoCodeNotValidForItem(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='input__error']")));
        return element;
    }
    public static WebElement DiscountedPrice (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //span[@class='order-detail-table__line-total-value--normal']")));
        return element;
    }

    public static WebElement Subtotal (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='order-detail-table-summary__subtotal-value']")));
        return element;
    }


    public static WebElement PercentageOFF (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-2-md pad-t-15-sm']//span[@class='shopping-cart-promo-off']")));
        return element;
    }

    public static WebElement RemovePromo (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='removePromo']")));
        return element;
    }
    public static WebElement CatEmptyMessage (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Your cart is empty. Add items to checkout.')]")));
        return element;
    }
    public static WebElement UpdateLink (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='order-detail-table__product-actions']//a[@id='updateItem']")));
        return element;
    }





}


