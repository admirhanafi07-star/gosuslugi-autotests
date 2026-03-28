package org.example.gosuslugi_playwright.wildberries.base;

import com.microsoft.playwright.*;

import java.util.List;

public class BasePage {

    // Поля класса (будут жить долго)
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;

    // Инициализация (НЕ используем try-with-resources так как есть поля!)
    public static void setUp() {
        if (playwright == null) {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(false).setArgs(List.of("--disable-blink-features=AutomationControlled")));

            context = browser.newContext();
            page = context.newPage();
        }
    }

    // Открыть страницу https://www.gosuslugi.ru/
    public static void openPage(String url) {
        if (page == null) {
            setUp();
        }
        page.navigate(url);
    }

    // Закрыть всё
    public static void tearDown() {
        try {
            if (page != null) {
                page.close();
                page = null;
            }
            if (context != null) {
                context.close();
                context = null;
            }
            if (browser != null) {
                browser.close();
                browser = null;
            }
            if (playwright != null) {
                playwright.close();
                playwright = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
