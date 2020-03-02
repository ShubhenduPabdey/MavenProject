package TestCase;
import Pages.HomePageObject;
import Pages.LoginModalObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.internal.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseFile2 {
    public static Utils FileUtils;
    public WebDriver driver;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeTest (alwaysRun = true)
    public void ConfigExtent() {
        htmlReporter = new ExtentHtmlReporter("extent2.html");
        htmlReporter.config().setDocumentTitle("Login Report2");
        htmlReporter.config().setReportName("Funtional Report2");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment", "QA2");
        extent.setSystemInfo("Name of The Tester", "Shubehndu Pandey");
    }
    @Parameters("BrowserName")
    @BeforeMethod (alwaysRun = true)
    public void Setup(@Optional("chrome") String Browsername) {
       // public void Setup() {
       if (Browsername.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/home/shubhendu/Software/chromedriver_linux64 (3)/chromedriver");
           driver = new ChromeDriver();
        }
       if (Browsername.equalsIgnoreCase("firefox")){
           System.setProperty("webdriver.gecko.driver", "/home/shubhendu/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
           driver = new FirefoxDriver();
       }
        driver.manage().window().maximize();
        driver.get("https://ecom.qa2.us.kohler.com/us/");
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void result(ITestResult result) throws IOException {
       // int X=0;
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, " Testcase " +" "+ result.getName()+" "+"is Failed");// to add name of test case that is failed
            test.log(Status.FAIL, "Failed " + result.getThrowable()); // to add log into report
            //test.addScreenCaptureFromPath("test-output/Screenshots/");
            //test.fail("Failed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath("/home/shubhendu/IdeaProjects/MavenProject/test-output/Screenshots"+"X.png").build());
            //X=X+1;
           // test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("/home/shubhendu/IdeaProjects/MavenProject/test-output/Screenshots/").build());
            TakesScreenshot ts =(TakesScreenshot)driver;
            FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("/home/shubhendu/IdeaProjects/MavenProject/test-output/Screenshots"+"1.png"));

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case" +" " + result.getName()+" "+"is Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case " +" " + result.getName() +" " +"is Skipped");
        }
    }
    @AfterTest
    public void EndSetup() {
        extent.flush();
    }
}


