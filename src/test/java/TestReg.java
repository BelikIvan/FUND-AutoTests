import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestReg {
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
    public void testReg() throws InterruptedException {
        // Находим ссылку авторизации/регистрации и кликаем по ней
        WebElement AuthA = driver.findElement(By.xpath("//a[contains(text(), 'Sign In/Register')]"));
        AuthA.click();
        String UrlAuth = "https://ffcdev.fundraisingforacause.com/customer/account/login/";
        Assert.assertEquals(driver.getCurrentUrl(), UrlAuth);

        // Находим кнопку Регистрации и кликаем по ней
        WebElement RegSpan = driver.findElement(By.xpath("//span[contains(text(), 'Create an Account')]"));
        RegSpan.click();
        String UrlReg = "https://ffcdev.fundraisingforacause.com/customer/account/create/";
        Assert.assertEquals(driver.getCurrentUrl(), UrlReg);

        // Заполняем поля для регистрации и кликаем на кнопку зарегистрироваться
        WebElement NameInput = driver.findElement(By.id("firstname"));
        NameInput.sendKeys("Test Name");
        WebElement SurnameInput = driver.findElement(By.id("lastname"));
        SurnameInput.sendKeys("Test Surname");
        WebElement SubInput = driver.findElement(By.id("is_subscribed"));
        SubInput.click();
        WebElement EmailInput = driver.findElement(By.id("email_address"));
        EmailInput.sendKeys("testibstest@gmail.com"); // Не забыть заменить email
        WebElement PassInput = driver.findElement(By.id("password"));
        PassInput.sendKeys("!test123!");
        WebElement CpassInput = driver.findElement(By.id("password-confirmation"));
        CpassInput.sendKeys("!test123!");
        WebElement RegButton = driver.findElement(By.xpath("//span[contains(text(), 'Create an Account')]"));
        RegButton.click();

        // Делаем проверку, что регистрация прошла успешно
        Thread.sleep(2000);
        WebElement RegSuccess = driver.findElement(By.xpath("//div[text()='Thank you for registering with Main Website Store.']"));
        String TestRegSuccess = RegSuccess.getText();
        Assert.assertEquals("Thank you for registering with Main Website Store.", TestRegSuccess);
    }
    @After
    public void teardownTest() {
        driver.quit();
    }
}
