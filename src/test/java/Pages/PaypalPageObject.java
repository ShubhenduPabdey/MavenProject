package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaypalPageObject {
    public static WebElement element;
    public static WebElement PaypalAcceptCookies(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,20);
        element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='acceptAllButton']")));
        return element;
    }

    public static WebElement PaypalEmail(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,20);
        element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        return element;
    }
    public static WebElement EmailNextbutton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@id='btnNext']"));
        return element;
    }
    public static WebElement PaypalPassword(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,20);
        element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        return element;
    }
    public static WebElement PaypalLoginButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@id='btnLogin']"));
        return element;
    }
    public static WebElement PaypalConitinueButton(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,20);
        element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='payment-submit-btn']")));
        return element;
    }





}
