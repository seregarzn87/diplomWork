package PageObjectBasicAuth;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BookmarksPage {
    WebDriver driver;

    public BookmarksPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchBarMainField;
    @FindBy(xpath = "/html/body/main/div/div[2]/div[2]/div[1]/div/div/div[3]/button[1]")
    private WebElement elementPageOne;
    @FindBy(xpath = "/html/body/main/div/div[2]/div[2]/div[3]/div/div/div[3]/button[1]")
    private WebElement elementPageTwo;
    @FindBy(xpath = "/html/body/header/div[1]/div/div/div/div[2]/a[2]/sup")
    private WebElement bookmarksCount;

    public void EnteringAnItemInTheSearchBar(){
        searchBarMainField.sendKeys("телефон", Keys.ENTER);
    }
    public void clickElementPage(){
        elementPageOne.click();
        elementPageTwo.click();
    }
    public void checkingTheNumberOfProductsInBookmarks(){
        int a = Integer.parseInt(bookmarksCount.getText());
        int b = 2;
        Assert.assertEquals(a,b);
    }
}
