package tests;

import base.TestsBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CategoryPage;

public class TestCategoryPage extends TestsBase {
    @Test
    public void AddToCard() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.testAddToCard();
    }
    @Test
    public void Pagination() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.testPagination();
        String PaginationUrl = "https://ffcdev.fundraisingforacause.com/wholesale-merchandise-shop/animal-causes/jewelry/bracelets.html?p=2";
        Assert.assertEquals(driver.getCurrentUrl(), PaginationUrl);
    }
    @Test
    public void Breadcrumbs() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.testBreadcrumbs();
        String Link = "https://ffcdev.fundraisingforacause.com/";
        Assert.assertEquals(driver.getCurrentUrl(), Link);
    }
}
