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
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/i")
    private WebElement theProductCatalogElement;
    @FindBy(xpath = "//*[@id=\"menu\"]/div[1]/ul/li[1]/a")
    private WebElement theElementOfTheCatalogTab;
    @FindBy(xpath = "/html/body/main/div/div[3]/div[2]/div[1]/div[8]/a/span")//
    private WebElement catalogLining;
    @FindBy(xpath = "/html/body/main/div/div[3]/div[1]/nav/div[8]/a")
    private WebElement getTheProductCatalogElement;

    @FindBy(xpath = "/html/body/main/div/div[3]/div[2]/div[3]/div")
    private List<WebElement> getTheElementOfTheCatalogTab;
    @FindBy(xpath = "//span[text()='Авто и мото']")
    private WebElement elementMainPage;

    public void clickElementMainPage(){
        elementMainPage.click();
    }

    public void clickTheProductCatalogElement(){
        theProductCatalogElement.click();
    }
    public void clickTheElementOfTheCatalogTab(){
        theElementOfTheCatalogTab.click();
    }
    public void clickCatalogLining(){
        catalogLining.click();
    }
    public void clickGetTheProductCatalogElement(){
        getTheProductCatalogElement.click();
    }
    public void checkingTheDisplayOfItemsInTheSideSearchBar(){
        clickTheProductCatalogElement();
        clickTheElementOfTheCatalogTab();
        clickCatalogLining();
        clickGetTheProductCatalogElement();
        String textCatalog = "под сиденье";
        for (WebElement pageCatalog : getTheElementOfTheCatalogTab){
            assert pageCatalog.getText().contains(textCatalog);
        }
    }
    public void checkingTheSearchForAnItemFromTheMainPage(){
        clickElementMainPage();
        clickCatalogLining();
        clickGetTheProductCatalogElement();
        String textCatalog = "под сиденье";
        for (WebElement pageCatalog : getTheElementOfTheCatalogTab){
            assert pageCatalog.getText().contains(textCatalog);
        }
    }

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

