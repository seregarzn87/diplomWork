package AvtoTesting;

import PageObjectBasicAuth.LocationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Location {
    public WebDriver driver;
    public LocationPage locationPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        locationPage = new LocationPage(driver);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("theSearchBarPage"));
    }
    @AfterTest
    public void close(){
        driver.close();
    }
    @Test(description = "Проверка установки местоположения через быстрый поиск")
    public void CheckinTheLocationSettingViaQuickSearch(){
        locationPage.clickLocationField();
        locationPage.delayInOpening();
        locationPage.clickCityDisplay();
        locationPage.delayInOpening();
        locationPage.checkingTheCityDisplayCheckingTheCityDisplay();
    }
}
