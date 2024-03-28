package PageObjectBasicAuth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

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
    public WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Не менее 6 символов']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@placeholder='Повторите пароль']")
    public WebElement repeatPasswordField;

    @FindBy(xpath = "//button[text()='Регистрация']")
    private WebElement registrationButton;

    @FindBy(xpath = "/html/body/main/div/p")
    private WebElement messageAboutSuccessfulRegistration;

    @FindBy(xpath = "/html/body/main/div/div[4]")
    private WebElement messageAboutNotSuccessfulRegistration;

    @FindBy(xpath = "/html/body/main/div/div[3]")
    private WebElement getMessageAboutSuccessfulRegistration;

    public void clickThePersonalAccountTab() {
        thePersonalAccountTab.click();
    }

    public void NameInput(String name) {
        nameField.sendKeys(name);
    }

    public void SurnameInput(String surname) {
        surnameField.sendKeys(surname);
    }

    public void TelefonInput(String telefon) {
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
    public void delayInOpening(){
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verificationOfSuccessfulRegistration() {
        String messageSuccessful = messageAboutSuccessfulRegistration.getText();
        String messageNotSuccessful = messageAboutNotSuccessfulRegistration.getText();

        String text = "Спасибо за регистрацию в нашем интернет магазине. " +
                "Теперь вы можете делать покупки быстрее и удобнее. " +
                "Вы также можете просматривать корзину и список закладок с различных устройств, " +
                "отслеживать статус своего заказа, видеть свои предыдущие заказы " +
                "или получать скидки как наш постоянный покупатель.";
        String textNot = "\n" +
                "\t\t\t    \t\tПароли не совпадают\n" +
                "\t\t\t    \t\t";
        if (messageSuccessful.equals(text)) {
            System.out.println("Регистрация пройдена");
        } else if (messageNotSuccessful.equals(textNot)) {
            System.out.println("Регистрация не пройдена");
        }
    }
        public void verificationRegistration() {
            String messageGetMessageAboutSuccessfulRegistration = getMessageAboutSuccessfulRegistration.getText();
            String textUser = "зарегистрирован";
            assert messageGetMessageAboutSuccessfulRegistration.contains(textUser);
        }
    }





