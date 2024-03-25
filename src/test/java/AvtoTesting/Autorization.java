package AvtoTesting;

import PageObjectBasicAuth.AutorizationPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
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
    @AfterTest(alwaysRun = true)
    public String captureScreen() {
        String path;
        try {
            WebDriver webDriver = new Augmenter().augment(driver);
            File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            path = "./target/screrncsots/" + scrFile.getName();
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            path = "Скриншот не сделан" + e.getMessage();
        }
        return path;
    }
    @AfterTest
    public void close(){
        driver.quit();
    }

    @Test(dataProvider = "value", description = "Проверка авторизации с не валидными данными", priority = 1)
    public void negativeTestDataProviderAuthorization(String email, String password){
        autorizationPage.emailFieldAutorization.clear();
        autorizationPage.emailAutorizationInput(email);
        autorizationPage.passwordFieldAutorization.clear();
        autorizationPage.passwordAutorizationInput(password);
        autorizationPage.clickButtonEntrance();
        autorizationPage.verificationOfSuccessfulAuthorization();
    }

    @Test(description = "Проверка авторизации с валидными данными", priority = 2)
    public void FillingOuTheAuthorizationForm(){
        autorizationPage.emailFieldAutorization.clear();
        autorizationPage.emailAutorizationInput(ConfProperties.getProperty("email"));
        autorizationPage.passwordFieldAutorization.clear();
        autorizationPage.passwordAutorizationInput(ConfProperties.getProperty("password"));
        autorizationPage.clickButtonEntrance();
        autorizationPage.verificationOfSuccessfulAuthorization();
    }

    @DataProvider(name = "value")
    public Object[][] dataProviderMethodAuthorization() {
        Object[][] data = new Object[7][2];
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
        //5 row
        data[4][0] = "!hdh@";
        data[4][1] = "!%67";
        //6 row
        data[5][0] = "";
        data[5][1] = "123456";
        //7 row
        data[6][0] = "serega@yandex.ru";
        data[6][1] = "123";
        return data;
    }
}
