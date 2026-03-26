package org.example.gosuslugi_cucumber;

import ch.qos.logback.core.joran.sanity.Pair;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Это страница регистрации и авторизации*/
@Slf4j
public class LoginRegistrationPageCucumber extends BasePageCucumber {

    @FindBy(xpath = "//button[text()=' Восстановить ']") // Восстановить
    private WebElement recover;

    @FindBy(xpath = "//a[text()='Подробнее']") // Подробнее
    private WebElement verbalLink2;

    @FindBy(xpath = "//button[@aria-label='QR-код']") //  QR-код
    private WebElement QRсode;

    @FindBy(xpath = "//button[@aria-label='Эл. подпись']") //  Электронная подпись
    private WebElement electronicSignature;

    @FindBy(xpath = "//button[text()=' Зарегистрироваться ']") // Зарегистрироваться
    private WebElement register;

    @FindBy(xpath = "//a[@href=\"https://www.gosuslugi.ru/landing/esia-help\"]") // Куда ещё можно войти с паролем от Госуслуг?
    private WebElement href;

    public LoginRegistrationPageCucumber(WebDriver driver) {
        super(driver); // Вызываем конструктор BasePageCucumber
        PageFactory.initElements(driver, this);
    }

    //___________________________________________________________________________________________

    @FindBy(xpath = "//input[@name=\"Телефон / Эл. почта / СНИЛС\"]") // Телефон / Эл. почта / СНИЛС
    private WebElement emailField;

    @FindBy(xpath = "//input[@name=\"Пароль\"]") // Пароль
    private WebElement passwordField;

    @FindBy(css = ".error-label.mb-4") // Разный текст на ошибку
    private WebElement errorMessage;

    @FindBy(xpath = "//button[@class=\"plain-button plain-button_wide\"]") // кнопка 'Войти'
    private WebElement buttonEnter;

    @Step("Ввод логина : {login}")
    public LoginRegistrationPageCucumber enterLogin(String login) {
        emailField.clear();
        emailField.sendKeys(login);
        return this;
    }

    @Step("Ввод пароля : {password}")
    public LoginRegistrationPageCucumber enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginRegistrationPageCucumber enterEbutton() {
        buttonEnter.click();
        return this;
    }

    private String lastErrorMessage;

    public LoginRegistrationPageCucumber messageError(String error){
        if (error.contains("Неверный логин или пароль")){
            System.out.println("Валидация отработало успешно, текст ошибки: " + error);
        } else {
            System.out.println("Ничего не сработало, сиди и разбирайся");
        }

        this.lastErrorMessage = errorMessage.getText().trim();
        return this;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }


//___________________________________________________________________________________________




















    /**
     * Проверяет, появилось ли сообщение об ошибке с ожидаемым текстом ожидаемый текст ошибки (например "Неверный логин или пароль")
     * @return true если ошибка появилась и текст совпадает
     */
    @Step("Ожидание появления сообщения об ошибке")
    public LoginRegistrationPageCucumber thePresenceOfText(){
        waitForElementVisible(errorMessage);
        return this;
    }

    // Локатор для окна "Введите код с картинки"
    @FindBy(css = ".esia-form-container.text-center.mb-20.mb-md-40")
    private WebElement EnterTheCodeFromTheImageWindow;

    public EnterTheCodeFromTheImageCucumber windowEnterTheCodeFromTheImage(){
        log.info("══════════════════════════════════════════");
        log.info("🔍 ПРОВЕРКА ОКНА КАПЧИ");

        boolean check = EnterTheCodeFromTheImageWindow.isDisplayed();
        log.info("📌 Окно 'Введите код с картинки' отображается: {}", check ? "✅ ДА" : "❌ НЕТ");
        if (check) {
            log.info("✅ Окно капчи отображается");
        } else {
            log.warn("⚠️ Окно капчи НЕ отображается"); // warn = предупреждение
        }

        log.info("══════════════════════════════════════════");
        return new EnterTheCodeFromTheImageCucumber(driver);
    }

    // Метод для получения текста ошибки (возвращает String)
    @Step("Получение текста ошибки")
    public String getErrorText() {
        log.debug("Начинаем проверку текста ошибки"); // debug = для отладки

        try {
            waitForElementVisible(errorMessage);
            String text = errorMessage.getText().trim();

            log.info("📌 Текст с элемента: \"{}\"", text);
            log.info("📌 Элемент отображается: {}", errorMessage.isDisplayed() ? "✅" : "❌");
            log.info("📌 Текст не пустой: {}", !text.isEmpty() ? "✅" : "❌");
            if (errorMessage.isDisplayed() && !text.isEmpty()) {

                if (text.contains(ErrorMessage.INVALID_CREDENTIALS.getValue()) ||
                        text.contains(ErrorMessage.EMPTY_FIELD.getValue()) ||
                        text.contains(ErrorMessage.INVALID_PHONE.getValue())) {

                    log.info("✅ Найдена ошибка: {}", text); // {} = подстановка

                } else {
                    log.warn("⚠️ Текст не совпадает с известными ошибками");
                }
            } else {
                log.warn("⚠️ Элемент не отображается или текст пустой");
            }

            log.info("══════════════════════════════════════════");
            return text;

        } catch (Exception e) {
            log.error("❌ Ошибка при получении текста: {}", e.getMessage()); // error = ошибка
            windowEnterTheCodeFromTheImage();
            return "ERROR";
        }
    }

    //___________________________________________________________________________________________
    @FindBy(xpath = "//button[text()=' Не удаётся войти ']") //  Не удаётся войти
    private WebElement unableToLogIn;
    // Метод для открытия модального окна
    @Step("Открытие модального окна помощи")
    public ModalWindowCucumber openHelpModal() {
        try {
            unableToLogIn.click();
            log.info("✅ Модальное окно открылось");
        } catch (Exception e) {
            log.error("❌ Не удалось открыть модальное окно: {}", e.getMessage());
            throw e;
        }
        return new ModalWindowCucumber(driver);
    }

}

enum ErrorMessage {
    INVALID_CREDENTIALS("Неверный логин или пароль"),
    EMPTY_FIELD("Заполните поле"),
    INVALID_PHONE("Введите номер телефона, СНИЛС или электронную почту");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}