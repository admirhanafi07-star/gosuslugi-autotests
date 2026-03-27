package org.example.gosuslugi_playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.example.gosuslugi_playwright.base.BasePage;

import java.util.List;

@Slf4j
//// Главная страница сайта gosuslugi.ru
public class MainPage extends BasePage {

    // ========== КНОПКА ВХОДА ==========
    public MainPage clickLoginButton() {
        page.getByText("Войти").click();
        return this;
    }

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


}
