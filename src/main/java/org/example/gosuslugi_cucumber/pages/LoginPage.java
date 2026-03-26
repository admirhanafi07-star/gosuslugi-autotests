package org.example.gosuslugi_cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**LoginPage — получаем драйвер через конструктор*/
public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@_ngcontent-ng-c3672901016]")
    private WebElement button;

    @FindBy(xpath = "//input[@name='Телефон / Эл. почта / СНИЛС']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='Пароль']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()=' Войти ']")
    private WebElement loginButton;

    @FindBy(css = ".error-label.mb-4")
    private WebElement errorMessage;

    public LoginPage openLoginPage() {
        openPage("https://www.gosuslugi.ru/");
        return this;
    }

    public void enterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();// Сначала ждём и потом клик
    }

    public void enterLogin(String login) {
        emailField.clear();
        emailField.sendKeys(login);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorText() {
        waitForElementVisible(errorMessage);
        return errorMessage.getText().trim();
    }

}
