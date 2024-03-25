package AvtoTesting;

import PageObjectBasicAuth.SortingPage;
import PageObjectBasicAuth.TheSearchBarPage;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Sorting {
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
    @AfterTest(alwaysRun = true)
    public String captureScreen() {
        String path;
        try {
            WebDriver webDriver = new Augmenter().augment(driver);
            File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshot/ " + scrFile.getName();
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
    @Test(description = "Проверка сортировки по возрастанию цены и минимальному значению")
    public void sortPrice(){
        sortingPage.clickRefreshPage();
        sortingPage.delayInOpening();
        sortingPage.openPageSort();
        sortingPage.delayInOpening();
        sortingPage.clickElPrice();
        sortingPage.delayInOpening();
        sortingPage.priceComparison();
    }
    @Test(description = "Проверка сортировки по производителю")
    public void sortBrand(){
        sortingPage.openPageSort();
        sortingPage.clickElementBrand();
        sortingPage.clickGetElementBrand();
        sortingPage.setGetElementBrand();
    }
}
