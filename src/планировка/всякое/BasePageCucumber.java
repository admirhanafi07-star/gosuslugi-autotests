package org.example.gosuslugi_cucumber;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.gosuslugi_selenium.Config.EXPLICIT_WAIT;

public class BasePageCucumber {
    protected WebDriver driver;
    protected WebDriverWait waitCucumber;

    public BasePageCucumber(WebDriver driver) {
        this.driver = driver;
        this.waitCucumber = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
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
        waitCucumber.until(ExpectedConditions.visibilityOf(element));
    }

    // Ожидает, когда элемент станет кликабельным (видимым и активным)
    public void waitForElementClickable(WebElement element) {
        waitCucumber.until(ExpectedConditions.elementToBeClickable(element));
    }











}
