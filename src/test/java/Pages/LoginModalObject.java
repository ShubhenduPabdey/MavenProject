package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginModalObject {
    public static WebElement element;

    public static WebElement SignIn(WebDriver driver){
        element = driver.findElement(By.id("user-name-tray"));
        return element;
    }

    public static WebElement EmailId(WebDriver driver){
        element=driver.findElement(By.id("email"));
        return element;
    }

    public static WebElement Password(WebDriver driver) throws InterruptedException {
        element=driver.findElement(By.id("password"));
        return element;
    }

    public static WebElement SignInButton(WebDriver driver){
        element=driver.findElement(By.id("trayProfileSignIn"));
        return element;
    }

    public static WebElement ErrorMessage (WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='error']")));
        return element;
    }
}
