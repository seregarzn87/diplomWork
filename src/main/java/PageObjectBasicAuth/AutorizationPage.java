package PageObjectBasicAuth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AutorizationPage {
    public WebDriver driver;

    public AutorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//input[@placeholder='E-Mail']")
    private WebElement emailFieldAutorization;
    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private WebElement passwordFieldAutorization;
    @FindBy(xpath = "//button[text()='Вход']")
    private WebElement buttonEntrance;
    @FindBy(xpath = "/html/body/main/div/p")
    private WebElement successfulAuthorizationMessage;

    public void emailAutorizationInput(String email){
        emailFieldAutorization.sendKeys(email);
    }
    public void passwordAutorizationInput(String password){
        passwordFieldAutorization.sendKeys(password);
    }
    public void clickButtonEntrance(){
        buttonEntrance.click();
    }
    public void verificationOfSuccessfulAuthorization(){
        String messageLogin = successfulAuthorizationMessage.getText();
        String textLogin = "Вы успешно авторизовались";
        Assert.assertEquals(messageLogin, textLogin);
    }


}
