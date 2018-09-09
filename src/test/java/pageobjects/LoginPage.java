package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    // Авторизация
    @FindBy(id = "email")
    private WebElement Login;

    @FindBy(id = "pass")
    private WebElement Password;

    @FindBy(id = "send2")
    private WebElement SignInButton;

    @FindBy(className = "header-links-account-toggle")
    private WebElement LogOutSelect;

    @FindBy(xpath = "//a[contains(text(), 'Log Out')]")
    public WebElement Logout;

    @FindBy(xpath = "//div[contains(text(), 'You did not sign in correctly or your account is temporarily disabled.')]")
    public WebElement ErrorNotification;

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
    private WebElement Forgots;




    public void inputLogin(String login) {
        Login.sendKeys(login);
    }

    public void inputPassword(String password) {
        Password.sendKeys(password);
    }

    public void clickSignInButton() {
        SignInButton.click();
    }

    public void clickLogOutSelect() {
        LogOutSelect.click();
    }




}
