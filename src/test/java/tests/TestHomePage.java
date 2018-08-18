package tests;

import base.TestsBase;
import org.testng.annotations.Test;
import pageobjects.MainPage;

public class TestHomePage extends TestsBase {
    @Test
    public void Registration() {
        MainPage mainPage = new MainPage(driver);
        mainPage.testReg();
    }
    @Test
    public void Authorization() {
        MainPage mainPage = new MainPage(driver);
        mainPage.testAuth();
    }
    @Test
    public void ForgotPassword() {
        MainPage mainPage = new MainPage(driver);
        mainPage.testForgotPass();
    }
    @Test
    public void LogOut() {
        MainPage mainPage = new MainPage(driver);
        mainPage.testLogOut();
    }
    @Test
    public void Search() {
        MainPage mainPage = new MainPage(driver);
        mainPage.testSearch();
    }
    @Test
    public void Menu() {
        MainPage mainPage = new MainPage(driver);
        mainPage.testMenuVisibility();
    }
    @Test
    public void Newsletter() {
        MainPage mainPage = new MainPage(driver);
        mainPage.testNewsletter();
    }



}
