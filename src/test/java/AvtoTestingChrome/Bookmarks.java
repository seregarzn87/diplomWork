package AvtoTestingChrome;

import PageObjectBasicAuth.BookmarksPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
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
        @Test(description = "Проверка добавления товара в закладки и отображения на экране элементов вкладки закладки и их нужного количества")
        public void CheckingTheAdditionOfAnItemToBookmarks(){
            bookmarksPage.EnteringAnItemInTheSearchBar();
            bookmarksPage.clickElementPage();
            bookmarksPage.checkingTheNumberOfProductsInBookmarks();
            bookmarksPage.clickBookmarksElement();
            bookmarksPage.CheckingTheDisplayOfTabItemsBookmarks();
        }
    }
