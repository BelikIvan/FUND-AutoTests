import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSearch {
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
    public void testSearch() {
        // Находим поле поиска, вводим поисковую фразу и нажимаем на кнопку поиска
        WebElement SearchInput = driver.findElement(By.id("search"));
        SearchInput.sendKeys("bracelets");
        SearchInput.submit();

        // Делаем проверку
        String title = "Search results for: 'bracelets'";
        Assert.assertEquals(driver.getTitle(), title);

    }
    @After
    public void teardownTest() {
        driver.quit();
    }
}
