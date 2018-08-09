import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSearch {
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
    public void testSearch() throws InterruptedException {
        // Находим поле поиска, вводим поисковую фразу и нажимаем на кнопку поиска
        WebElement SearchInput = driver.findElement(By.id("search"));
        SearchInput.sendKeys("50 Pink Ribbon Shaped Silicone Bracelets (50 Bracelets)");
        SearchInput.submit();
        Thread.sleep(2000);

        // Делаем проверку
        WebElement NameProduct = driver.findElement(By.xpath("//a[contains(text(), '50 Pink Ribbon Shaped Silicone Bracelets (50 Bracelets)')]"));
        String Name = NameProduct.getText();
        Assert.assertEquals("50 Pink Ribbon Shaped Silicone Bracelets (50 Bracelets)", Name);

    }
    @AfterClass
    public void teardownTest() {
        driver.quit();
    }
}
