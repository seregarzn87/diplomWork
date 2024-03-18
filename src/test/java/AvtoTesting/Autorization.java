package AvtoTesting;

import PageObjectBasicAuth.AutorizationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Autorization {
    public WebDriver driver;
    public AutorizationPage autorizationPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        autorizationPage = new AutorizationPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("autorizationPage"));
    }
    @AfterTest
    public void close(){
        driver.close();
    }

    @Test(description = "Проверка авторизации с валидными данными")
    public void FillingOuTheAuthorizationForm(){
        autorizationPage.emailAutorizationInput(ConfProperties.getProperty("email"));
        autorizationPage.passwordAutorizationInput(ConfProperties.getProperty("password"));
        autorizationPage.clickButtonEntrance();
        autorizationPage.verificationOfSuccessfulAuthorization();
    }

    @Test(dataProvider = "value", description = "Проверка авторизации с не валидными данными")
    public void negativeTestDataProviderAuthorization(String email, String password){
        autorizationPage.emailAutorizationInput(email);
        autorizationPage.passwordAutorizationInput(password);
        autorizationPage.clickButtonEntrance();
        autorizationPage.verificationOfSuccessfulAuthorization();
    }

    @DataProvider(name = "value")
    public Object[][] dataProviderMethodAuthorization() {
        Object[][] data = new Object[4][2];
        // 1 row.
        data[0][0] = "serega@yandex.ru";
        data[0][1] = "123456";
        // 2 row.
        data[1][0] = "";
        data[1][1] = "";
        // 3 row.
        data[2][0] = "seregarzn@yandex.ru";
        data[2][1] = "555555";
        // 4 row.
        data[3][0] = "seregarzn@yandex.ru";
        data[3][1] = "!%67";
        return data;
    }
}
