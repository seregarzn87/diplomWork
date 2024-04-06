package AvtoTestingChrome;

import PageObjectBasicAuth.AddingShoppingCart;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddingAnItemToTheShoppingCart {

        protected WebDriver driver;
        public AddingShoppingCart addingShoppingCart;
        @BeforeClass
        public void open(){
            driver = new ChromeDriver();
            addingShoppingCart = new AddingShoppingCart(driver);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://allithave.ru/");
        }
    @AfterMethod(alwaysRun = true)
    public String captureScreen() {
        String path;
        try {
            WebDriver webDriver = new Augmenter().augment(driver);
            File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshot/" + scrFile.getName();
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            path = "Скриншот не сделан" + e.getMessage();
        }
        return path;
    }

    @AfterSuite
    public void close(){
        driver.quit();
    }

        @Test(description = "Проверка добавления товара в корзину")
        public void AddingAnItemToTheShoppingCart(){
            addingShoppingCart.addingAndClickAnItemToTheSearchBar();
            addingShoppingCart.clickButton();
            addingShoppingCart.checkingTheShoppingCart();
        }
    }
