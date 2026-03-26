package org.example.gosuslugi_cucumber;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/** Это главная страница gosuslugi*/
@Slf4j
public class MainPageCucumber extends BasePageCucumber {

    // Локаторы для главной страницы
    private static final By EXTENSIONS_LINK = By.xpath("//button[@_ngcontent-ng-c3672901016]");

    public MainPageCucumber(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Клик по ссылке расширений для перехода к авторизации")
    public LoginRegistrationPageCucumber clickExtensionsLink() {
        // Пишем полное имя с классом wait.until(ExpectedConditions.elementToBeClickable(EXTENSIONS_LINK));
        waitCucumber.until(ExpectedConditions.elementToBeClickable(EXTENSIONS_LINK)).click();// Сначала ждём
        return new LoginRegistrationPageCucumber(driver); // Передаём driver
    }
}