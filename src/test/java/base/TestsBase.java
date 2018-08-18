package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestsBase {
    protected static WebDriver driver;

    @BeforeClass
    public void SetupDrivers() {
        System.setProperty("webdriver.chrome.driver", "E:/InstallProgram/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void SetupConfig() {
        driver.get("https://ffcdev.fundraisingforacause.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void SetupClean() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void SetupClose() {
        driver.quit();
    }
}