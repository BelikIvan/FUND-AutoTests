package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
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
    }

    public void testAuth() {
        AuthA.click();
        AuthEmail.sendKeys("testibstest@gmail.com");
        AuthPass.sendKeys("!test123!");
        AuthButton.click();
    }

    public void testLogOut() {
        AuthA.click();
        AuthEmail.sendKeys("testibstest@gmail.com");
        AuthPass.sendKeys("!test123!");
        AuthButton.click();
        LogOutSelect.click();
    }

    public void testForgotPass() {
        AuthA.click();
        ForgotA.click();
        ForgotEmail.sendKeys("testibstest@gmail.com");
        ForgotButton.click();
    }

    public void testSearch() {
        SearchInput.sendKeys("50 Pink Ribbon Shaped Silicone Bracelets (50 Bracelets)");
        SearchInput.submit();
    }

    public void testMenuVisibilityMenuSBRC() {
        MenuSBRC.click();
    }

    public void testMenuVisibilityMenuSBC() {
        MenuSBC.click();
    }

    public void testNewsletter() {
        Newsletter.sendKeys(mail);
        Newsletter.submit();
    }
    public void testLoginFail(String email, String pass) {
        AuthA.click();
        AuthEmail.sendKeys(email);
        AuthPass.sendKeys(pass);
        AuthButton.click();
    }
}
