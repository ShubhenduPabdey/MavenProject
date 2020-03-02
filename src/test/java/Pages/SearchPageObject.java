package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageObject {
    public static WebElement element;
    public static WebElement Search (WebDriver driver){
            WebDriverWait wait=new WebDriverWait(driver,20);
            element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nav-searchbox']")));
            return element;
        }
}
