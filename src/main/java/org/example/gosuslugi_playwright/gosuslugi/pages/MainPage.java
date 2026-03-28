package org.example.gosuslugi_playwright.gosuslugi.pages;

import com.microsoft.playwright.Locator;
import lombok.extern.slf4j.Slf4j;
import org.example.gosuslugi_playwright.gosuslugi.base.BasePage;

import java.util.List;

@Slf4j
//// Главная страница сайта gosuslugi.ru
public class MainPage extends BasePage {

    // ========== КНОПКА ВХОДА ==========
    public MainPage clickLoginButton() {
        page.getByText("Войти").click();
        return this;
    }

    //====================================================================================================
    // ========== ВСЕ ЭЛЕМЕНТЫ МЕНЮ ==========
    public MainPage allLocator() {
        List<Locator> items = page.locator("ul li.mr-24").all();
        log.info("📋 Найдено элементов: {}", items.size());

        for (int i = 0; i < items.size(); i++) {
            log.info("  {}. Элемент {}", i + 1, i);
        }
        return this;
    }

    // ========== ТЕКСТЫ ВСЕХ ЭЛЕМЕНТОВ ==========
    public MainPage allText() {
        List<String> items = page.locator("ul li.mr-24").allTextContents();
        log.info("📝 Тексты элементов:");

        for (int i = 0; i < items.size(); i++) {
            String text = items.get(i).trim();  // чистим текст
            log.info("  {}. {}", i + 1, text);
        }
        return this;
    }

    // ========== ВСЕ ВМЕСТЕ ==========
    public MainPage allLocatorText() {
        log.info("=== Вывод информации о меню ===");
        allLocator();    // выводим элементы
        allText();       // выводим тексты
        return this;
    }
    //====================================================================================================
    // ========== ВСЕ ЭЛЕМЕНТЫ УСЛУГ ==========
    public MainPage allLocatorServices() {
        List<Locator> items = page.locator("button .ng-star-inserted").all();
        log.info("📋 Найдено услуг: {}", items.size());

        for (int i = 0; i < items.size(); i++) {
            log.info("  {}. Услуга {}", i + 1, i);
        }
        return this;
    }

    // ========== ТЕКСТЫ ВСЕХ ЭЛЕМЕНТОВ ==========
    public MainPage allTextServices() {
        List<String> items = page.locator("p.color-white").allTextContents();
        log.info("📝 Тексты услуг:");

        for (int i = 0; i < items.size(); i++) {
            String text = items.get(i).trim();  // чистим текст
            log.info("  {}. {}", i + 1, text);
        }
        return this;
    }

    // ========== ВСЕ ВМЕСТЕ ==========
    public MainPage allLocatorTextServices() {
        log.info("=== Вывод информации об услугах ===");
        allLocatorServices();    // выводим ссылки услуг
        allTextServices();       // выводим название услуг
        return this;
    }
    //====================================================================================================
    // ========== ПЕРЕХОД НА СТРАНИЦУ РЕГИСТРАЦИИ ==========
    public LoginPage registrationPage() {
        page.getByText("Войти").click();
        log.info("Переход на страницу регистрации осуществлён");
        return new LoginPage();
    }










}
