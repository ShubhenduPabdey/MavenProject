package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_To_CartPageObject {
public static WebElement element;
    public static WebElement ViewCart(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,20);
       element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='display-none-sml']//a[@id='cart-checkout-button']")));
       return element;
    }

}
