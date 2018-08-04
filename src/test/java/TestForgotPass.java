import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForgotPass {
    /*---------------------------------------- Test Setup ----------------------------------------*/
    private WebDriver driver;

    @BeforeClass
    public static void classSetup() {
        System.setProperty("webdriver.chrome.driver", "E:/InstallProgram/drivers/chromedriver/chromedriver.exe");
    }
    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://ffcdev.fundraisingforacause.com/");
        driver.manage().window().maximize();
    }
    /*---------------------------------------- Test ----------------------------------------*/
    @Test
    public void testAuth() throws InterruptedException {
        // Находим ссылку авторизации/регистрации и кликаем по ней
        WebElement AuthA = driver.findElement(By.xpath("//a[contains(text(), 'Sign In/Register')]"));
        AuthA.click();
        String UrlAuth = "https://ffcdev.fundraisingforacause.com/customer/account/login/";
        Assert.assertEquals(driver.getCurrentUrl(), UrlAuth);

        // Находим ссылку для восстановления пароля и переходим по ней
        WebElement ForgotSpan = driver.findElement(By.xpath("//span[contains(text(), 'Forgot Your Password?')]"));
        ForgotSpan.click();

        // Восстанавливаем пароль (не забываем указать email)
        WebElement EmailInput = driver.findElement(By.id("email_address"));
        EmailInput.sendKeys("testibstest@gmail.com");
        WebElement ResetSpan = driver.findElement(By.xpath("//span[contains(text(), 'Reset My Password')]"));
        ResetSpan.click();
        Thread.sleep(3000);

        // Делаем проверку (не забываем прописать email в 43 и 45 строке)
        Thread.sleep(2000);
        WebElement ResetSuccess = driver.findElement(By.xpath("//div[text()='If there is an account associated with testibstest@gmail.com you will receive an email with a link to reset your password.']"));
        String TestResetSuccess = ResetSuccess.getText();
        Assert.assertEquals("If there is an account associated with testibstest@gmail.com you will receive an email with a link to reset your password.", TestResetSuccess);
    }
    @After
    public void teardownTest() {
        driver.quit();
    }
}
