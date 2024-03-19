package AvtoTesting;

import PageObjectBasicAuth.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Registration {
    public static RegistrationPage registrationPage;
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("registrationPage"));
    }

    @AfterTest
    public void close() {
        driver.close();
   }

    @Test(description = "Проверка заполнения формы регистрации не валидными данными")
    public void negativeTestValue() {
        registrationPage.EmailInput(ConfProperties.getProperty("email"));
        registrationPage.PasswordInput(ConfProperties.getProperty("password"));
        registrationPage.RepeatPasswordInput(ConfProperties.getProperty("repeatPassword"));
        registrationPage.clickRegistrationButton();
        registrationPage.verificationOfSuccessfulRegistration();
    }
    @Test(dataProvider = "InvalidData", description = "Проверка заполнения формы регистрации не валидными данными с помощью DataProvider")
    public void negativeTestValueDataProvider(String email, String password, String repeatPassword){
        registrationPage.emailField.clear();
        registrationPage.EmailInput(email);
        registrationPage.passwordField.clear();
        registrationPage.PasswordInput(password);
        registrationPage.repeatPasswordField.clear();
        registrationPage.RepeatPasswordInput(repeatPassword);
        registrationPage.clickRegistrationButton();
        registrationPage.verificationOfSuccessfulRegistration();
    }

    @Test(description = "Проверка заполнение формы регистрации валидными данными")
    public void FillingOutTheRegistrationForm() {
        registrationPage.clickThePersonalAccountTab();
        registrationPage.clickRegistrationButton();
        registrationPage.NameInput(ConfProperties.getProperty("name"));
        registrationPage.SurnameInput(ConfProperties.getProperty("surname"));
        registrationPage.EmailInput(ConfProperties.getProperty("email"));
        registrationPage.TelefonInput(ConfProperties.getProperty("telefon"));
        registrationPage.PasswordInput(ConfProperties.getProperty("password"));
        registrationPage.RepeatPasswordInput(ConfProperties.getProperty("repeatPassword"));
        registrationPage.clickRegistrationButton();
        registrationPage.verificationOfSuccessfulRegistration();
    }

        @DataProvider(name = "InvalidData")
        public Object[][] dataProviderMethod() {
        Object[][] data = new Object[5][3];
        // 1 row.
        data[0][0] = "seregarzn@yandex.ru";
        data[0][1] = "123456";
        data[0][2] = "23";
        // 2 row.
        data[1][0] = "";
        data[1][1] = "123456";
        data[1][2] = "123456";
        // 3 row.
        data[2][0] = "";
        data[2][1] = "";
        data[2][2] = "";
        // 4 row.
        data[3][0] = "seregarzn@yandex.ru";
        data[3][1] = "";
        data[3][2] = "";
        // 5 row.
        data[4][0] = "555";
        data[4][1] = "123456";
        data[4][2] = "123456";
        return data;
    }
}




