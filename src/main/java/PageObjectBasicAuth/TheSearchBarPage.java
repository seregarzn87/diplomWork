package PageObjectBasicAuth;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TheSearchBarPage {
    WebDriver driver;

    public TheSearchBarPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchBarMainField;
    @FindBy(xpath = "/html/body/main/div/div[2]/div[2]")
    private List<WebElement> listOfPageElements;

    public void addingTheItemNameToTheSearchBarConfProperties() {
        searchBarMainField.sendKeys(ConfProperties.getProperty("nameToTheSearchBar"));
        searchBarMainField.sendKeys(Keys.ENTER);
    }
    public void addingTheItemNameToTheSearchBar() {
        searchBarMainField.sendKeys("телефон");
        searchBarMainField.sendKeys(Keys.ENTER);
    }

    public void checkingTheCorrectnessOfDisplayingInformationInTheSearchBarConfProperties() {
        String textSearchBar = ConfProperties.getProperty("nameToTheSearchBar");
        for (WebElement pageElements : listOfPageElements) {
            assert pageElements.getText().contains(textSearchBar): "Элемента поиска - нет в списке";
        }
    }
    public void checkingTheCorrectnessOfDisplayingInformationInTheSearchBar() {
        String textSearchBar = "телефон";
        for (WebElement pageElements : listOfPageElements) {
            assert pageElements.getText().contains(textSearchBar): "Элемента поиска - нет в списке";
        }
    }
}

