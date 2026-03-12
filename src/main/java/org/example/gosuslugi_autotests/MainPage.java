package org.example.gosuslugi_autotests;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

/** Это главная страница gosuslugi*/
@Slf4j
public class MainPage extends BasePage {

    // Локаторы для главной страницы
    private static final By EXTENSIONS_LINK = By.xpath("//button[@_ngcontent-ng-c3672901016]");

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Клик по ссылке расширений для перехода к авторизации")
    public LoginRegistrationPage clickExtensionsLink() {
        // Пишем полное имя с классом wait.until(ExpectedConditions.elementToBeClickable(EXTENSIONS_LINK));
        wait.until(ExpectedConditions.elementToBeClickable(EXTENSIONS_LINK)).click();// Сначала ждём
        return new LoginRegistrationPage(driver); // Передаём driver
    }


    //___________________________________________________________________________________________
    // Локатор для всех кнопок категорий в шапке
    @FindBy(css = "ul.flex-container-d-lg.header li p.link-plain")
    private List<WebElement> allCategoriesHat;

    @Step("Получение списка всех категорий в шапке сайта")
    public List<String> getAllCategoryNamesHat() {
        List<String> categoryNames = allCategoriesHat.stream()
                .map(item -> item.getText().trim())
                .collect(Collectors.toList());

        log.info("✅ Найденные категории: {}", categoryNames);
        return categoryNames;
    }
    //___________________________________________________________________________________________


    //___________________________________________________________________________________________
    // Локатор для всех кнопок категорий
    @FindBy(css = "button.category[role='tab']")
    private List<WebElement> allCategories;

    @Step("Получение списка всех категорий с атрибутами")
    public List<String> getAllCategoryNames() {
        List<String> listString = allCategories.stream().map(el -> el.getAttribute("aria-label")).collect(Collectors.toList());
        log.info("✅ Найденные категории: {}", listString);
        return listString;
    }

    //___________________________________________________________________________________________
}