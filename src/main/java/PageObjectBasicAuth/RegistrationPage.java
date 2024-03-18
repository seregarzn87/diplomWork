package PageObjectBasicAuth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    public WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//span[text()=' Личный кабинет']")
    private WebElement thePersonalAccountTab;

    @FindBy(xpath = "//input[@placeholder='Имя']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@placeholder='Фамилия']")
    private WebElement surnameField;

    @FindBy(xpath = "//input[@placeholder='Телефон']")
    private WebElement telefonField;

    @FindBy(xpath = "//input[@placeholder='E-Mail']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Не менее 6 символов']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@placeholder='Повторите пароль']")
    private WebElement repeatPasswordField;

    @FindBy(xpath = "//button[text()='Регистрация']")
    private WebElement registrationButton;

    public void clickThePersonalAccountTab(){
        thePersonalAccountTab.click();
    }

    public void NameInput(String name){
        nameField.sendKeys(name);
    }

    public void SurnameInput(String surname){
        surnameField.sendKeys(surname);
    }

    public void TelefonInput(String telefon){
        telefonField.sendKeys(telefon);
    }

    public void EmailInput(String email) {
        emailField.sendKeys(email);
    }

    public void PasswordInput(String password) {
        passwordField.sendKeys(password);
    }

    public void RepeatPasswordInput(String repeatPassword) {
        repeatPasswordField.sendKeys(repeatPassword);
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }
}



