package org.example.gosuslugi_cucumber;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ModalWindowCucumber extends LoginRegistrationPageCucumber {

    private static final Logger log = LoggerFactory.getLogger(ModalWindowCucumber.class);

    @FindBy(xpath = "//button[text()=' Не удаётся войти ']") //  Не удаётся войти
    private WebElement unableToLogIn;

    @FindBy(xpath = "//button[text()=' Закрыть окно ']") // Закрыть окно через крестик
    private WebElement closeTheWindow;

    @FindBy(xpath = "//button[@class=\"esia-plain-button esia-plain-button--auto-width\"]") // Закрыть окно через "Закрыть"
    private WebElement closeTheWindow2;

    public ModalWindowCucumber(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Закрытие модального окна через крестик")
    // Метод для закрытия через крестик
    public ModalWindowCucumber closeViaCross() {
        try {

            closeTheWindow.click();
            log.info("✅ Закрыто через крестик");
        } catch (Exception e) {
            log.error("❌ Не удалось закрыть через крестик: {}", e.getMessage());
            throw e;
        }
        return this;
    }

    // Метод для открытия модального окна
    @Step("Открытие модального окна")
    public ModalWindowCucumber openHelpModal2() {
        try {
            unableToLogIn.click();
            log.info("✅ Модальное окно открылось");
        } catch (Exception e) {
            log.error("❌ Не удалось открыть модальное окно: {}", e.getMessage());
            throw e;
        }
        return this;
    }

    // Метод для закрытия через кнопку "Закрыть"
    @Step("Закрытие модального окна через кнопку 'Закрыть'")
    public ModalWindowCucumber closeViaButton() {
        try {
            closeTheWindow2.click();
            log.info("✅ Закрыто через кнопку 'Закрыть'");
        } catch (Exception e) {
            log.error("❌ Не удалось закрыть через кнопку: {}", e.getMessage());
            throw e;
        }
        return this;
    }

    // Метод для открытия модального окна
    @Step("Открытие модального окна (повторное)")
    public ModalWindowCucumber openHelpModal3() {
        try {
            unableToLogIn.click();
            log.info("✅ Модальное окно открылось");
        } catch (Exception e) {
            log.error("❌ Не удалось открыть модальное окно: {}", e.getMessage());
            throw e;
        }
        return this;
    }

    // Комбинированный метод для теста
    @Step("Тестирование полного цикла: открытие и закрытие модального окна разными способами")
    public ModalWindowCucumber testModalBothWays() {
        log.info("🔄 Начинаем тестирование модального окна");
        return this.closeViaCross()
                .openHelpModal2()
                .closeViaButton()
                .openHelpModal3();
    }

    //___________________________________________________________________________________________
    @FindBy(xpath = "//a[@target='_blank']")
    public List<WebElement> allWebElement;

    @Step("Получение и вывод всех ссылок и название из модального окна")
    public void allWebElementHref(){
        log.info("🔗 Получаем все ссылки из модального окна");

        //Получение списка всех ссылок
        List<String> result = allWebElement.stream().map(e -> e.getAttribute("href")).collect(Collectors.toList());

        //Получение списка названий всех ссылок
        List<String> resultText = allWebElement.stream()
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());

        log.info("Найдено ссылок: {}", allWebElement.size());

        for (int i = 0; i < allWebElement.size(); i++) {
            log.info("Ссылка {}: {} — название: {}", (i + 1), result.get(i), resultText.get(i));
        }
    }


}
