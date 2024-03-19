package AvtoTesting;

import PageObjectBasicAuth.AutorizationPage;
import PageObjectBasicAuth.TheSearchBarPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
    @AfterTest
    public void close(){
        driver.close();
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
}
