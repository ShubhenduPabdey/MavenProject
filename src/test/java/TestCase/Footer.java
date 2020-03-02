package TestCase;

import Pages.FooterPageObject;
import Pages.HomePageObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.Set;


public class Footer extends BaseFile2 {

    @Test
    public void AboutUs() {
        test = extent.createTest("About us");
        HomePageObject.AcceptCookies(driver).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FooterPageObject.Aboutus(driver).click();
        String ParentWindow = driver.getWindowHandle();
        Set<String> AllWindows = driver.getWindowHandles();
        for (String Child : AllWindows) {
            if (!ParentWindow.equalsIgnoreCase(Child)) {
                String ActualTitle = driver.switchTo().window(Child).getTitle();
                String ExpectedTitle = "Who We Are | Kohler";
                Assert.assertEquals(ActualTitle, ExpectedTitle);
                System.out.println(ActualTitle);
            }
        }
    }

    @Test
    public void StoreLocator() {
        test = extent.createTest("About us");
        HomePageObject.AcceptCookies(driver).click();
        FooterPageObject.StoreLocator(driver).click();
        String ExpectedTitle = "Results | Find a Store | KOHLER";
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println(ActualTitle);

    }

    @Test
    public void Careers() {
        test = extent.createTest("Careers");
        HomePageObject.AcceptCookies(driver).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FooterPageObject.Careers(driver).click();
        String ParentWindow = driver.getWindowHandle();
        Set<String> AllWindows = driver.getWindowHandles();
        for (String Child : AllWindows) {
            if (!ParentWindow.equalsIgnoreCase(Child)) {
                String ActualTitle = driver.switchTo().window(Child).getTitle();
                String ExpectedTitle = "Search Careers | Kohler";
                Assert.assertEquals(ActualTitle, ExpectedTitle);
                System.out.println(ActualTitle);
            }
        }
    }

    @Test
    public void PressRoom() {
        test = extent.createTest("Press Room");
        HomePageObject.AcceptCookies(driver).click();
        FooterPageObject.StoreLocator(driver).click();
        String ExpectedTitle = "Results | Find a Store | KOHLER";
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println(ActualTitle);
    }

}
