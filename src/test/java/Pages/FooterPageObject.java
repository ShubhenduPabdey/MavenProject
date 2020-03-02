package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPageObject {

    public static WebElement element;
    public static WebElement Aboutus (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='footer__tab--1']//span[contains(text(),'About Us')]")));
        return element;
    }
    public static WebElement StoreLocator (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='footer__tab--1']//span[contains(text(),'Store Locator')]")));
        return element;
    }
    public static WebElement Careers (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='footer__tab--1']//span[contains(text(),'Careers')]")));
        return element;
    }

    public static WebElement PressRoom (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='footer__tab--1']//span[contains(text(),'Press Room')]")));
        return element;
    }





}
