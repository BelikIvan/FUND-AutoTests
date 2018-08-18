package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.UUID;

public class MainPage extends PageObject {

    // Авторизация
    @FindBy(xpath = "//a[contains(text(), 'Sign In/Register')]")
    private WebElement AuthA;

    @FindBy(id = "email")
    private WebElement AuthEmail;

    @FindBy(id = "pass")
    private WebElement AuthPass;

    @FindBy(id = "send2")
    private WebElement AuthButton;

    @FindBy(className = "header-links-account-toggle")
    private WebElement LogOutSelect;

    @FindBy(xpath = "//a[contains(text(), 'Log Out')]")
    private WebElement LogOutA;

    // Регистрация
    @FindBy(xpath = "//span[contains(text(), 'Create an Account')]")
    private WebElement RegSpan;

    @FindBy(id = "firstname")
    private WebElement RegName;

    @FindBy(id = "lastname")
    private WebElement RegSurname;

    @FindBy(id = "is_subscribed")
    private WebElement RegSubscribed;

    @FindBy(id = "email_address")
    private WebElement RegEmail;

    @FindBy(id = "password")
    private WebElement RegPass;

    @FindBy(id = "password-confirmation")
    private WebElement RegConfPass;

    @FindBy(xpath = "//span[contains(text(), 'Create an Account')]")
    private WebElement RegButton;

    @FindBy(xpath = "//div[text()='Thank you for registering with Main Website Store.']")
    private WebElement RegSuccess;

    // Восстановление пароля
    @FindBy(xpath = "//span[contains(text(), 'Forgot Your Password?')]")
    private WebElement ForgotA;

    @FindBy(id = "email_address")
    private WebElement ForgotEmail;

    @FindBy(xpath = "//span[contains(text(), 'Reset My Password')]")
    private WebElement ForgotButton;

    @FindBy(xpath = "//div[text()='If there is an account associated with testibstest@gmail.com you will receive an email with a link to reset your password.']")
    private WebElement ForgotSuccess;

    // Поиск
    @FindBy(id = "search")
    private  WebElement SearchInput;

    @FindBy(xpath = "//span[contains(text(), 'Search']")
    private WebElement SearchButton;

    @FindBy(xpath = "//a[contains(text(), '50 Pink Ribbon Shaped Silicone Bracelets (50 Bracelets)')]")
    private WebElement SearchSuccess;

    // Меню
    @FindBy(xpath = "//span[contains(text(), 'Shop by Ribbon Color')]")
    private WebElement MenuSBRC;

    @FindBy(xpath = "//span[contains(text(), 'Shop by Cause')]")
    private WebElement MenuSBC;

    @FindBy(xpath = "//span[contains(text(), 'No Texting')]")
    private WebElement MenuLink;

    @FindBy(xpath = "//span[contains(text(), 'Diseases & Health')]")
    private WebElement MenuLink2;

    // Подписка
    @FindBy(id = "newsletter")
    private WebElement Newsletter;

    @FindBy(xpath = "//div[text()='Thank you for your subscription.']")
    private WebElement NewsletterSuccess;

    // Генерация email
    UUID id = UUID.randomUUID();
    String mail = id+"@gmail.com";


    public MainPage(WebDriver driver){
        super(driver);
    }

    public void testReg() {
        AuthA.click();
        RegSpan.click();
        RegName.sendKeys("Test Name");
        RegSurname.sendKeys("Test Surname");
        RegSubscribed.click();
        RegEmail.sendKeys(mail);
        RegPass.sendKeys("!test123!");
        RegConfPass.sendKeys("!test123!");
        RegButton.click();
        String TestRegSuccess = RegSuccess.getText();
        Assert.assertEquals("Thank you for registering with Main Website Store.", TestRegSuccess);
    }

    public void testAuth() {
        AuthA.click();
        AuthEmail.sendKeys("testibstest@gmail.com");
        AuthPass.sendKeys("!test123!");
        AuthButton.click();
        String AuthSuccess = "https://ffcdev.fundraisingforacause.com/customer/account/";
        Assert.assertEquals(driver.getCurrentUrl(), AuthSuccess);
    }

    public void testLogOut() {
        AuthA.click();
        AuthEmail.sendKeys("testibstest@gmail.com");
        AuthPass.sendKeys("!test123!");
        AuthButton.click();
        LogOutSelect.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement WaitLogOutA = wait.until(ExpectedConditions.elementToBeClickable(LogOutA));
        WaitLogOutA.click();
        String LogOutUrl = "https://ffcdev.fundraisingforacause.com/customer/account/logoutSuccess/";
        Assert.assertEquals(driver.getCurrentUrl(), LogOutUrl);
    }

    public void testForgotPass() {
        AuthA.click();
        ForgotA.click();
        ForgotEmail.sendKeys("testibstest@gmail.com");
        ForgotButton.click();
        String TestResetSuccess = ForgotSuccess.getText();
        Assert.assertEquals("If there is an account associated with testibstest@gmail.com you will receive an email with a link to reset your password.", TestResetSuccess);
    }

    public void testSearch() {
        SearchInput.sendKeys("50 Pink Ribbon Shaped Silicone Bracelets (50 Bracelets)");
        SearchInput.submit();
        String Search = SearchSuccess.getText();
        Assert.assertEquals("50 Pink Ribbon Shaped Silicone Bracelets (50 Bracelets)", Search);
    }

    public void testMenuVisibility() {
        MenuSBRC.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement MenuVisibility = wait.until(ExpectedConditions.visibilityOf(MenuLink));
        String UlMenu = MenuVisibility.getText();
        Assert.assertEquals("No Texting", UlMenu);
        MenuSBC.click();
        WebElement MenuVisibility2 = wait.until(ExpectedConditions.visibilityOf(MenuLink2));
        String UlMenu2 = MenuVisibility2.getText();
        Assert.assertEquals("Diseases & Health", UlMenu2);
    }

    public void testNewsletter() {
        Newsletter.sendKeys(mail);
        Newsletter.submit();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement NewsletterWait = wait.until(ExpectedConditions.visibilityOf(NewsletterSuccess));
        String NewsletterText = NewsletterWait.getText();
        Assert.assertEquals("Thank you for your subscription.", NewsletterText);
    }
}
