package PageObjectBasicAuth;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LocationPage {
    WebDriver driver;

    public LocationPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//a[@data-target='#city']")
    private WebElement locationField;

    @FindBy(xpath = "/html/body/header/div[1]/div/div/div/div[2]/a[1]")
    private WebElement getLocationCity;

    @FindBy(xpath = "//a[@data-city='Москва']")
    private WebElement cityDisplay;

    public void clickLocationField(){
        locationField.click();
    }

    public void clickCityDisplay(){
        cityDisplay.click();
    }
    public void delayInOpening(){
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void checkingTheCityDisplayCheckingTheCityDisplay(){
        String cityResultText = "Москва";
        assert getLocationCity.getText().equals(cityResultText): "Не корректно отображен город";
    }
}