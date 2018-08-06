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
    public void testSearch() {
        // Находим поле поиска, вводим поисковую фразу и нажимаем на кнопку поиска
        WebElement SearchInput = driver.findElement(By.id("search"));
        SearchInput.sendKeys("bracelets");
        SearchInput.submit();

        // Делаем проверку
        String title = "Search results for: 'bracelets'";
        Assert.assertEquals(driver.getTitle(), title);

    }
    @AfterClass
    public void teardownTest() {
        driver.quit();
    }
}
