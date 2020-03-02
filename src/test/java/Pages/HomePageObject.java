package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject extends TestCase.BaseFile2 {

    private static WebElement element;


    public static WebElement AcceptCookies(WebDriver driver) {
        element = driver.findElement(By.id("truste-consent-button"));
        return element;
    }

   /* public static void Usernametray (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='user-name-tray']")));
        if (b ==) {
            driver.navigate().refresh();
        }
    }*/

    public static WebElement BathroomMenu(WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,20);
        element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='main-nav__button--bathroom']")));
        //element=driver.findElement(By.xpath("//button[@id='main-nav__button--bathroom']"));
        return element;
    }
    public static WebElement ToiletSeat(WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,20);
        element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Toilet Seats')]")));
        return element;
    }

    public static WebElement ShopAllToiletSeatsLink  (WebDriver driver){
        element=driver.findElement(By.xpath("//button[@class='primary hero-carousel-btn text--black']"));
        return element;
    }
    public static WebElement C3125ElongatedBidetToiletSeat (WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='product-panel__summary product-panel__summary-new'][contains(text(),'C3®-125 elongated bidet toilet seat')]")));
       // element=driver.findElement(By.xpath("//p[@class='product-panel__summary product-panel__summary-new'][contains(text(),'C3®-125 elongated bidet toilet seat')]"));
        return element;
    }
    public static WebElement AddToCartButton (WebDriver driver){
        element=driver.findElement(By.xpath("//button[@class='btn btn--green full-width-sm marg-b-10-sm buttonAddToCart'] "));
        return element;
    }

}