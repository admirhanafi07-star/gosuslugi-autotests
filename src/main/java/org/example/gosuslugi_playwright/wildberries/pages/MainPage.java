package org.example.gosuslugi_playwright.wildberries.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import lombok.extern.slf4j.Slf4j;
import org.example.gosuslugi_playwright.wildberries.base.BasePage;

import java.nio.file.Paths;
import java.util.List;

@Slf4j
//// Главная страница сайта gosuslugi.ru
public class MainPage extends BasePage {

    // ========== ЗАКРЫТЬ ПОПАП ==========
    public MainPage closePopup() {
        page.locator("button._close_heicy_55").click();
        log.info("🔘 Попап закрыт");
        return this;
    }

    // ========== ПРИНЯТЬ КУКИ ==========
    public MainPage acceptCookies() {
        page.locator("button.cookies__btn").click();
        log.info("🍪 Куки приняты");
        return this;
    }

    // ========== КЛИК ПО ИКОНКЕ ПОИСКА ПО ФОТО ==========
    public MainPage clickSearchPhoto() {
        page.locator("div .imageIcon--Ji1JO").click();
        log.info("🔍 Клик по иконке поиска по фото");
        return this;
    }

    /*// ========== КЛИК ПО ИКОНКЕ ПОИСКА ПО ФОТО ==========
    public MainPage clickSearchPhotoSelectAPhoto() {
        page.locator("[id='uploadLink']").click();
        log.info("🔍 Клик по ссылке 'выберите фото'");
        return this;
    }*/

    // ========== ПОСЧИТАТЬ ИНПУТЫ ==========
    public MainPage countFileInputs() {
        int count = page.locator("input[type='file']").count();
        log.info("📁 Найдено input[type='file']: {}", count);
        return this;
    }

    // ========== ЗАГРУЗИТЬ ФОТО ДЛЯ ПОИСКА ==========
    public MainPage uploadPhoto(String filePath) {
        log.info("=== Загрузка фото ===");

        page.locator("#popUpFileInput").setInputFiles(
                Paths.get(filePath)
        );
        page.waitForTimeout(3000);

        log.info("📁 Файл загружен");
        return this;
    }

    // ========== ПОЛНЫЙ ПОИСК ПО ФОТО ==========
    public MainPage searchByImage(String filePath) {
        return closePopup()
                .acceptCookies()
                .clickSearchPhoto()
                //.clickSearchPhotoSelectAPhoto()
                .countFileInputs()
                .uploadPhoto(filePath);
    }









    /*//====================================================================================================
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
*/
}
