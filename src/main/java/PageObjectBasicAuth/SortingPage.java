package PageObjectBasicAuth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class SortingPage {
    WebDriver driver;

    public SortingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/main/div[2]/div[3]/a")
    private WebElement elementMainPage;
    @FindBy(xpath = "/html/body/main/div/div[3]/div[2]/div[1]/div[3]/a")
    private WebElement catalogLining;
    @FindBy(xpath = "/html/body/main/div/div[3]/div[1]/div[1]/div[2]/div/div[1]/input")
    private WebElement prieceMinField;
    @FindBy(xpath = "/html/body/main/div/div[3]/div[1]/div[1]/div[3]/div/div[7]/label")
    private WebElement elementBrand;
    @FindBy(xpath = "/html/body/main/div/div[3]/div[2]/div[3]/div/div[4]/div/div/div[1]/a")
    private WebElement getElementBrand;
    @FindBy(xpath = "/html/body/main/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/a")
    private WebElement pageElementBrand;
    @FindBy(xpath = "/html/body/main/div/div[3]/div[2]/div[1]/div[2]/span[4]")
    private WebElement elPrice;
    @FindBy(xpath = "/html/body/main/div/div[3]/div[2]/div[3]/div/div[1]/div/div/div[2]/div/span")
    private WebElement getElPrice;
    @FindBy(xpath = "/html/body/header/div[2]/div[1]/div[1]/a/img")
    private WebElement refreshPage;

    public void clickRefreshPage(){
        refreshPage.click();
    }
    public void clickElPrice(){
        elPrice.click();
    }
    public void priceComparison() {
        int a = Integer.parseInt(prieceMinField.getAttribute("value"));
        int b = Integer.parseInt(getElPrice.getText());
        Assert.assertEquals(a,b);
    }
    public void delayInOpening(){
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setGetElementBrand(){
        Assert.assertEquals(pageElementBrand.getText(), ConfProperties.getProperty("elBrand"));
    }

    public void clickGetElementBrand(){
        getElementBrand.click();
    }

    public void clickElementBrand(){
        elementBrand.click();
    }

    public void openPageSort() {
        elementMainPage.click();
        catalogLining.click();
    }
}



