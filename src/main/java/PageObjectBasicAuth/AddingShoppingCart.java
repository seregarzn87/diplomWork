package PageObjectBasicAuth;

import io.qameta.allure.Step;
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

    @Step("Добавление элемента в строку поиска")
    public void addingAndClickAnItemToTheSearchBar() {
        searchBarMainField.sendKeys("телефон", Keys.ENTER);
    }
    @Step("Нажатие на кнопку поиска")
    public void clickButton() {
        button.click();
    }
    @Step("Проверка корзины покупок")
    public void checkingTheShoppingCart () {
        int b = Integer.parseInt(count.getText());
        int a = 1;
        Assert.assertEquals(a,b);
    }
}

