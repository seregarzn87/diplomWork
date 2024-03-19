package AvtoTesting;

import PageObjectBasicAuth.BookmarksPage;
import PageObjectBasicAuth.TheSearchBarPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Bookmarks {

        public WebDriver driver;
        public BookmarksPage bookmarksPage;

        @BeforeClass
        public void setup() {
            driver = new ChromeDriver();
            bookmarksPage = new BookmarksPage(driver);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(ConfProperties.getProperty("theSearchBarPage"));
        }
        @AfterTest
        public void close(){
            driver.close();
        }
        @Test(description = "Проверка добавления товара в закладки")
        public void CheckingTheAdditionOfAnItemToBookmarks(){
            bookmarksPage.EnteringAnItemInTheSearchBar();
            bookmarksPage.clickElementPage();
            bookmarksPage.checkingTheNumberOfProductsInBookmarks();
        }

    }
