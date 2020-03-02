package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Xref {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/shubhendu/Software/chromedriver_linux64 (3)/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://stg.xref.kohler.com/#/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@class,'css-2b097c-container')]")).click();
        driver.findElement(By.xpath("//div[@id='react-select-2-option-2']")).click();
//        Actions action = new Actions(driver);
//        action.moveByOffset(0, 10).click();
    }
}
