package org.example.gosuslugi_autotests;

import lombok.extern.slf4j.Slf4j;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Это страница регистрации и авторизации*/
@Slf4j
public class LoginRegistrationPage extends BasePage{

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

    public LoginRegistrationPage(WebDriver driver) {
        super(driver); // Вызываем конструктор BasePage
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

    @Step("Ввод email: {email} и пароля: {password}")
    public LoginRegistrationPage enterEmail(String email, String password) {
        emailField.clear();
        emailField.sendKeys(email);

        passwordField.clear();
        passwordField.sendKeys(password);

        buttonEnter.click();
        return this;
    }

    /**
     * Проверяет, появилось ли сообщение об ошибке с ожидаемым текстом ожидаемый текст ошибки (например "Неверный логин или пароль")
     * @return true если ошибка появилась и текст совпадает
     */
    @Step("Ожидание появления сообщения об ошибке")
    public LoginRegistrationPage thePresenceOfText(){
        waitForElementVisible(errorMessage);
        return this;
    }

    // Локатор для окна "Введите код с картинки"
    @FindBy(css = ".esia-form-container.text-center.mb-20.mb-md-40")
    private WebElement EnterTheCodeFromTheImageWindow;

    public EnterTheCodeFromTheImage windowEnterTheCodeFromTheImage(){
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
        return new EnterTheCodeFromTheImage(driver);
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

                    // Здесь ваш switch/case
                /*switch (text) {
                    case "Неверный логин или пароль":
                        System.out.println("✅ Найден текст ошибки: " + text);
                        break;
                    case "Заполните поле":
                        System.out.println("✅ Найден текст ошибки: " + text);
                        break;
                    case "Введите номер телефона, СНИЛС или электронную почту":
                        System.out.println("✅ Найден текст ошибки: " + text);
                        break;
                    default:
                        windowEnterTheCodeFromTheImage();
                        break;
                }*/
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
    public ModalWindow openHelpModal() {
        try {
            unableToLogIn.click();
            log.info("✅ Модальное окно открылось");
        } catch (Exception e) {
            log.error("❌ Не удалось открыть модальное окно: {}", e.getMessage());
            throw e;
        }
        return new ModalWindow(driver);
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