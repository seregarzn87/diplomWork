package AvtoTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class AddingAnItemToTheShoppingCart {

        protected WebDriver driver;
        @BeforeSuite
        public void open(){
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://allithave.ru/");
        }
        @AfterTest
        public void close(){
            driver.close();
        }

        @Test(description = "Проверка добавления товара в корзину")
        public void AddingAnItemToTheShoppingCart(){
            driver.findElement(By.xpath("//input[@name='search']")).sendKeys("телефон", Keys.ENTER);
            driver.findElement(By.cssSelector("button.buy.flex-grow-1.ml-sm-2.ml-1")).click();
            WebElement element = driver.findElement(By.cssSelector("span.count"));
            int b = Integer.parseInt(element.getText());
            int a = 1;
            Assert.assertEquals(a,b);
        }
    }
