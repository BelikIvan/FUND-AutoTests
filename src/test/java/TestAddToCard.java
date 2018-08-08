import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAddToCard {
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
    public void testaddtocard() throws InterruptedException {
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

        //Переходим на главную страницу
        WebElement Home = driver.findElement(By.className("logo"));
        Home.click();

        // Находим ссылку авторизации/регистрации и кликаем по ней
        WebElement Menu = driver.findElement(By.xpath("//span[contains(text(), 'Shop by Ribbon Color')]"));
        Menu.click();
        WebElement Category = driver.findElement(By.xpath("//span[contains(text(), 'Animal Causes')]"));
        Category.click();
        WebElement SubCategory = driver.findElement(By.xpath("//div[contains(text(), 'Stickers & Decals')]"));
        SubCategory.click();
        Thread.sleep(3000);
        WebElement Product1 = driver.findElement(By.xpath("//form[@data-product-sku='ST-13-P']"));
        Product1.click();
        //Thread.sleep(300);
        WebElement Product2 = driver.findElement(By.xpath("//form[@data-product-sku='ST-33-P']"));
        Product2.click();
        //Thread.sleep(300);
        WebElement Product3 = driver.findElement(By.xpath("//form[@data-product-sku='DST-MC (ON BACKORDER)']"));
        Product3.click();
        //Thread.sleep(300);
        WebElement Product4 = driver.findElement(By.xpath("//form[@data-product-sku='ST-34LO-P']"));
        Product4.click();
        Thread.sleep(5000);
        WebElement Card = driver.findElement(By.className("showcart"));
        Card.click();
    }
    /*
    @AfterClass
    public void teardownTest() {
        driver.quit();
    }
    */
}
