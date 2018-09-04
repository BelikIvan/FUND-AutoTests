package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

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

    //Пагинация
    @FindBy(css = "li.pages-item-next")
    private List<WebElement> PaginationNext;

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
    }

    public void testPagination() {
        MenuSBRC.click();
        Category.click();
        SubCategory2.click();
        PaginationNext.get(1).click();
    }

    public void testBreadcrumbs() {
        MenuSBRC.click();
        Category.click();
        Breadcrumbs.click();
    }
}
