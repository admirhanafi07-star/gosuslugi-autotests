package org.example.gosuslugi_cucumber.pages;

import org.example.gosuslugi_cucumber.utils.ConfigCucumber;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    // Поля для всех страниц/степов
    private WebDriver driver;
    protected WebDriverWait wait;

    // Конструктор
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigCucumber.EXPLICIT_WAIT));
    }

    // Общие методы для всех страниц
    public void openPage(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Ожидает появления элемента на странице (WebElement)
    public void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
