package gosuslugi_autotests_cucumber.stepdefinitions;

import gosuslugi_autotests_cucumber.Hooks;
import io.cucumber.java.ru.*;
import org.example.cucumber.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

/**LoginSteps — используем Hooks.driver для создания LoginPage*/
public class LoginSteps {
    private LoginPage loginPage;

    @Дано("я открываю главную страницу")
    public void openMainPage() {
        this.loginPage = new LoginPage(Hooks.driver);
        loginPage.openLoginPage();  // открывает главную
    }

    @Когда("я нажимаю на ссылку расширений")
    public void clickExtensionLink() {
        loginPage.enterButton();  // кликает на кнопку для перехода к логину
    }

    @Когда("я ввожу логин {string}")
    public void enterLogin(String login) {
        loginPage.enterLogin(login);
    }

    @Когда("я ввожу пароль {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @И("я нажимаю кнопку {string}")
    public void clickButton(String button) {
        loginPage.clickLoginButton();
    }

    @Тогда("я вижу сообщение об ошибке {string}")
    public void seeErrorMessage(String expectedMessage) {
        String actualMessage = loginPage.getErrorText();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

}
