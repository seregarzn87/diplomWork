package AvtoTesting;

import PageObjectBasicAuth.SortingPage;
import PageObjectBasicAuth.TheSearchBarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
