package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PDPpageObject {
    public static WebElement element;
    public static WebElement Addtocart(WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn--green full-width-sm marg-b-10-sm buttonAddToCart']")));
        return element;
    }
}
