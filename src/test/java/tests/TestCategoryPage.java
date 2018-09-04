package tests;

import base.TestsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CategoryPage;

public class TestCategoryPage extends TestsBase {
    @Test
    public void AddToCard() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.testAddToCard();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement AddToCardWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='You added 250 Small 3/4 Inch Round Paw Print Stickers (250 Stickers) to your shopping cart.']")));
        String AddToCardText = AddToCardWait.getText();
        Assert.assertEquals("You added 250 Small 3/4 Inch Round Paw Print Stickers (250 Stickers) to your shopping cart.", AddToCardText);
    }
    @Test
    public void Pagination() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.testPagination();
        WebDriverWait wait = new WebDriverWait(driver,10);
        Boolean PaginationUrl = wait.until(ExpectedConditions.urlToBe("https://ffcstage.fundraisingforacause.com/wholesale-merchandise-shop/animal-causes/jewelry/bracelets.html?p=2"));
        String PaginationUrlSuccess = "https://ffcstage.fundraisingforacause.com/wholesale-merchandise-shop/animal-causes/jewelry/bracelets.html?p=2";
        Assert.assertEquals(driver.getCurrentUrl(), PaginationUrlSuccess);
    }
    @Test
    public void Breadcrumbs() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.testBreadcrumbs();
        String Link = "https://ffcstage.fundraisingforacause.com/";
        Assert.assertEquals(driver.getCurrentUrl(), Link);
    }
}
