package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CategoryPage extends PageObject {

    // Добавление товара в корзину
    @FindBy(xpath = "//span[contains(text(), 'Shop by Ribbon Color')]")
    private WebElement MenuSBRC;

    @FindBy(xpath = "//span[contains(text(), 'Animal Causes')]")
    private WebElement Category;

    @FindBy(xpath = "//div[contains(text(), 'Stickers & Decals')]")
    private WebElement SubCategory;

    @FindBy(xpath = "//div[contains(text(), 'Bracelets')]")
    private WebElement SubCategory2;

    @FindBy(xpath = "//form[@data-product-sku='ST-13-P']/button/span[text()='Add to Cart']")
    private WebElement AddToCard;

    @FindBy(xpath = "//div[text()='You added 250 Small 3/4 Inch Round Paw Print Stickers (250 Stickers) to your shopping cart.']")
    private WebElement AddToCardSuccess;

    //Пагинация
    @FindBy(css = "li.pages-item-next")
    private WebElement PaginationNext;

    // Хлебные крошки
    @FindBy(xpath = "//a[text()='Home']")
    private WebElement Breadcrumbs;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void testAddToCard() {
        MenuSBRC.click();
        Category.click();
        SubCategory.click();
        AddToCard.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement AddToCardWait = wait.until(ExpectedConditions.elementToBeClickable(AddToCardSuccess));
        String AddToCardText = AddToCardWait.getText();
        Assert.assertEquals("You added 250 Small 3/4 Inch Round Paw Print Stickers (250 Stickers) to your shopping cart.", AddToCardText);
    }

    public void testPagination() {
        MenuSBRC.click();
        Category.click();
        SubCategory2.click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 1100);");
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement PaginationWait = wait.until(ExpectedConditions.elementToBeClickable(PaginationNext));
        PaginationWait.click();
    }

    public void testBreadcrumbs() {
        MenuSBRC.click();
        Category.click();
        Breadcrumbs.click();
    }
}
