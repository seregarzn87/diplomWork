package AvtoTesting;

import PageObjectBasicAuth.AddingShoppingCart;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
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
        @AfterTest
        public void close(){
            driver.close();
        }

        @Test(description = "Проверка добавления товара в корзину")
        public void AddingAnItemToTheShoppingCart(){
            addingShoppingCart.addingAndClickAnItemToTheSearchBar();
            addingShoppingCart.clickButton();
            addingShoppingCart.checkingTheShoppingCart();
        }
    }
