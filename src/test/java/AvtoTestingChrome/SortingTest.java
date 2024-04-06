package AvtoTestingChrome;

import PageObjectBasicAuth.SortingPage;
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

public class SortingTest {
    public WebDriver driver;
    public SortingPage sortingPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        sortingPage = new SortingPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("theSearchBarPage"));
    }
    @AfterMethod(alwaysRun = true)
    public String captureScreenTest() {
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
    @Test(description = "Проверка сортировки по возрастанию цены и минимальному значению")
    public void sortPriceTest(){
        sortingPage.clickRefreshPage();
        sortingPage.delayInOpening();
        sortingPage.openPageSort();
        sortingPage.delayInOpening();
        sortingPage.clickElPrice();
        sortingPage.delayInOpening();
        sortingPage.priceComparison();
    }
    @Test(description = "Проверка сортировки по производителю")
    public void sortBrandTest(){
        sortingPage.openPageSort();
        sortingPage.clickElementBrand();
        sortingPage.clickGetElementBrand();
        sortingPage.setGetElementBrand();
    }
}
