package AvtoTesting;

import PageObjectBasicAuth.TheSearchBarPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TheSearchBar {
    public WebDriver driver;
    public TheSearchBarPage theSearchBarPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        theSearchBarPage = new TheSearchBarPage(driver);
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

    @Test(description = "Проверка поиска  товара по поисковой строке " +
            "и его наличие на отображаемой странице с помощью класса ConfProperties",priority = 1)
    public void CheckingTheProductSearchConfProperties(){
        theSearchBarPage.addingTheItemNameToTheSearchBarConfProperties();
        theSearchBarPage.checkingTheCorrectnessOfDisplayingInformationInTheSearchBarConfProperties();
    }
    @Test(description = "Проверка поиска  товара по поисковой строке " +
            "и его наличие на отображаемой странице",priority = 2)
    public void CheckingTheProductSearch(){
        theSearchBarPage.searchBarMainField.clear();
        theSearchBarPage.addingTheItemNameToTheSearchBar();
        theSearchBarPage.checkingTheCorrectnessOfDisplayingInformationInTheSearchBar();
    }
    @Test(description = "Проверка поиска товара по боковой панели поиска",priority = 3)
    public void TheSideSearchBar(){
        theSearchBarPage.checkingTheDisplayOfItemsInTheSideSearchBar();
    }

    @Test(description = "Проверка поиска товара с главной страницы",priority = 4)
    public void mainPageSearchBar(){
        theSearchBarPage.checkingTheSearchForAnItemFromTheMainPage();
    }
}
