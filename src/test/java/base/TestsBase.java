package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestsBase {
    protected static WebDriver driver;

    @BeforeClass
    public void SetupDrivers() {
        System.setProperty("webdriver.chrome.driver", "E:/InstallProgram/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver", "E:/InstallProgram/drivers/geckodriver/geckodriver.exe");
//        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void SetupConfig() {
        driver.get("https://ffcdev.fundraisingforacause.com/");
        driver.manage().window().maximize();
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
