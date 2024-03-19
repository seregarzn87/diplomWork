package PageObjectBasicAuth;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddingShoppingCart {
    WebDriver driver;


    public AddingShoppingCart (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(css = "button.buy.flex-grow-1.ml-sm-2.ml-1")
            private WebElement button;
    @FindBy(css = "span.count")
            private WebElement count;
    @FindBy(xpath = "//input[@name='search']")
            public WebElement searchBarMainField;

    public void addingAndClickAnItemToTheSearchBar() {
        searchBarMainField.sendKeys("телефон", Keys.ENTER);
    }
    public void clickButton() {
        button.click();
    }
    public void checkingTheShoppingCart () {
        int b = Integer.parseInt(count.getText());
        int a = 1;
        Assert.assertEquals(a,b);
    }
}

