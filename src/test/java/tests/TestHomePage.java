package tests;

import base.TestsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.MainPage;

import java.util.UUID;

public class TestHomePage extends TestsBase {
    @DataProvider
    public Object [][] testLoginFailData() {
        return new Object[][] {
                new Object[] {"testibstest@gmail.com", "123456789"},
                new Object[] {"1test1@mail.com", "123456"},
        };
    }

    // Генерация email
    UUID id = UUID.randomUUID();
    String mail = id+"@gmail.com";

    @Test
    public void Authorization() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickLoginUrl();
        loginPage.inputLogin("testibstest@gmail.com");
        loginPage.inputPassword("!test123!");
        loginPage.clickSignInButton();
        String AuthSuccess = "https://ffcdev.fundraisingforacause.com/customer/account/";
        Assert.assertEquals(driver.getCurrentUrl(), AuthSuccess);
    }

    @Test
    public void LogOut() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickLoginUrl();
        loginPage.inputLogin("testibstest@gmail.com");
        loginPage.inputPassword("!test123!");
        loginPage.clickSignInButton();
        loginPage.clickLogOutSelect();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement WaitLogOutA = wait.until(ExpectedConditions.visibilityOf(loginPage.Logout));
        WaitLogOutA.click();
        String LogOutUrl = "https://ffcdev.fundraisingforacause.com/customer/account/logoutSuccess/";
        Assert.assertEquals(driver.getCurrentUrl(), LogOutUrl);
    }

    @Test(dataProvider = "testLoginFailData")
    public void LoginFail(String email, String pass) {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickLoginUrl();
        loginPage.inputLogin(email);
        loginPage.inputPassword(pass);
        loginPage.clickSignInButton();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement FailWait = wait.until(ExpectedConditions.visibilityOf(loginPage.ErrorNotification));
        String FailText = FailWait.getText();
        Assert.assertEquals("You did not sign in correctly or your account is temporarily disabled.", FailText);
    }

//    @Test
//    public void Registration() {
//        MainPage mainPage = new MainPage(driver);
//        mainPage.testReg();
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        WebElement TestRegWait = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'Thank you for registering with Main Website Store.')]")));
//        String TestRegText = TestRegWait.getText();
//        Assert.assertEquals("Thank you for registering with Main Website Store.", TestRegText);
//    }

//    @Test
//    public void ForgotPassword() {
//        MainPage mainPage = new MainPage(driver);
//        mainPage.testForgotPass();
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        WebElement ForgotSuccessWait = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='If there is an account associated with testibstest@gmail.com you will receive an email with a link to reset your password.']")));
//        String TestResetSuccess = ForgotSuccessWait.getText();
//        Assert.assertEquals("If there is an account associated with testibstest@gmail.com you will receive an email with a link to reset your password.", TestResetSuccess);
//    }

//    @Test
//    public void Search() {
//        MainPage mainPage = new MainPage(driver);
//        mainPage.testSearch();
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        WebElement WaitSearch = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='kuName']/a[contains(text(), '50 Pink Ribbon Shaped Silicone Bracelets (50 Bracelets)')]")));
//        String Search = WaitSearch.getText();
//        Assert.assertEquals("50 Pink Ribbon Shaped Silicone Bracelets (50 Bracelets)", Search);
//    }
//    @Test
//    public void Menu() {
//        MainPage mainPage = new MainPage(driver);
//        mainPage.testMenuVisibilityMenuSBRC();
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        WebElement MenuLink = driver.findElement(By.xpath("//span[contains(text(), 'No Texting')]"));
//        WebElement MenuVisibility = wait.until(ExpectedConditions.visibilityOf(MenuLink));
//        String UlMenu = MenuVisibility.getText();
//        Assert.assertEquals("No Texting", UlMenu);
//
//        mainPage.testMenuVisibilityMenuSBC();
//        WebElement MenuLink2 = driver.findElement(By.xpath("//span[contains(text(), 'Diseases & Health')]"));
//        WebElement MenuVisibility2 = wait.until(ExpectedConditions.visibilityOf(MenuLink2));
//        String UlMenu2 = MenuVisibility2.getText();
//        Assert.assertEquals("Diseases & Health", UlMenu2);
//    }
//    @Test
//    public void Newsletter() {
//        MainPage mainPage = new MainPage(driver);
//        mainPage.testNewsletter();
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        WebElement NewsletterWait = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'Thank you for your subscription.')]")));
//        String NewsletterText = NewsletterWait.getText();
//        Assert.assertEquals("Thank you for your subscription.", NewsletterText);
//    }

}
