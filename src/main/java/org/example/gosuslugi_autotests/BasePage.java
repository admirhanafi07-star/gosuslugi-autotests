package org.example.gosuslugi_autotests;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.example.gosuslugi_autotests.Config.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
    }


    // БАЗОВЫЕ МЕТОДЫ ДЛЯ РАБОТЫ С БРАУЗЕРОМ
    // ================================================================================

    // Открывает указанный URL в браузере
    public void open(String url) {
        driver.get(url);
    }



    // МЕТОДЫ ОЖИДАНИЯ (WAITERS)
    // ================================================================================

    // Ожидает появления элемента на странице (WebElement)
    public void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Ожидает, когда элемент станет кликабельным (видимым и активным)
    public void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }











}
