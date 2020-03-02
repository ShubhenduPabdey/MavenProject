package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsletterPopUp {
    public static  WebElement element;

    public static WebElement Email(WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,20); {
            element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailmarketingpopup")));
            return element;

        }
    }
    public static WebElement ZipCode(WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,20); {
            //element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailmarketingpopupzip")));

            return element;
        }
    }
    public static boolean SubscribeButtonisVisible (WebDriver driver){
        try {
            driver.findElement(By.xpath("//button[@class='signup-button']")).isEnabled();
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public static WebElement Subscribe (WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,20); {
            element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='signup-button']")));
            return element;
        }
    }

    public static WebElement Close (WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,20); {
            element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='signup-close']")));
            return element;
        }
    }
    public static WebElement privacyPolicy (WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,20); {
            element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='privacy-pop-up']")));
            return element;
        }
    }
    public static WebElement NoThanks (WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,20); {
            element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nothanks-close']")));
            return element;
        }
    }
}
