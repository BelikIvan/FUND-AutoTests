import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogOut {
    /*---------------------------------------- Test Setup ----------------------------------------*/
    private WebDriver driver;

    @BeforeClass
    public void classSetup() {
        System.setProperty("webdriver.chrome.driver", "E:/InstallProgram/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ffcdev.fundraisingforacause.com/");
        driver.manage().window().maximize();
    }
    /*---------------------------------------- Test ----------------------------------------*/
    @Test
    public void testLogOut() throws InterruptedException {
        // Находим ссылку авторизации/регистрации и кликаем по ней
        WebElement AuthA = driver.findElement(By.xpath("//a[contains(text(), 'Sign In/Register')]"));
        AuthA.click();
        String UrlAuth = "https://ffcdev.fundraisingforacause.com/customer/account/login/";
        Assert.assertEquals(driver.getCurrentUrl(), UrlAuth);

        // Находим поля авторизации и заполняем их
        WebElement EmailInput = driver.findElement(By.id("email"));
        EmailInput.sendKeys("testibstest@gmail.com");
        WebElement PassInput = driver.findElement(By.id("pass"));
        PassInput.sendKeys("!test123!");
        WebElement Button = driver.findElement(By.id("send2"));
        Button.click();

        // Делаем проверку, что авторизация прошла успешно
        String AuthSuccess = "https://ffcdev.fundraisingforacause.com/customer/account/";
        Assert.assertEquals(driver.getCurrentUrl(), AuthSuccess);

        // Разавторизовываемся
        WebElement LogOutSelect = driver.findElement(By.className("header-links-account-toggle"));
        LogOutSelect.click();
        Thread.sleep(2000);
        WebElement LogOutA = driver.findElement(By.xpath("//a[contains(text(), 'Log Out')]"));
        LogOutA.click();

        // Делаем проверку, что разавторизация прошла
        String LogOutUrl = "https://ffcdev.fundraisingforacause.com/customer/account/logoutSuccess/";
        Assert.assertEquals(driver.getCurrentUrl(), LogOutUrl);
        Thread.sleep(2000);
    }
    @AfterClass
    public void teardownTest() {
        driver.quit();
    }
}
