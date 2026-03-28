package gosuslugi_autotests_playwright.gosuslugi.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import gosuslugi_autotests_playwright.wildberries.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.example.gosuslugi_playwright.wildberries.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

@Slf4j
public class AuthTestWildberries extends BaseTest {

    private MainPage mainPage = new MainPage();

    @Nested
    @DisplayName("🔐 Работа с главной страницей")
    class MainPageTest {

        @Nested
        @DisplayName("Позитивные сценарии")
        @Tag("positive")
        @Tag("smoke") // позитивные тесты часто входят в smoke
        class PositiveAuthTests {

            @Test
            @DisplayName("Открытие главной страницы https://www.wildberries.ru/")
            void test1() {
                mainPage.closePopup();
                /*log.info("=== Запуск теста test1 ===");
                // 1. Ждем, пока страница загрузится (сеть успокоится)
                page.waitForLoadState(LoadState.NETWORKIDLE);
                // 2. Небольшая пауза для анимаций и дозагрузки картинок
                page.waitForTimeout(5000);
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/test1.png")));*/
            }

            @Test
            @DisplayName("Нажимаем на иконку фотографии")
            void test2() {
                mainPage.searchByImage("C:\\Users\\admir\\OneDrive\\Desktop\\photo_2025-12-03_22-48-53.jpg");
            }

            @Test
            @DisplayName("Получение списка ссылок всех услуг и название этих услуг")
            void test3() {

            }

            @Test
            @DisplayName("Переход на страницу регистрации")
            void test5() {
                mainPage.closePopup();
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/test3.png")));
            }
        }
    }

    @Nested
    @DisplayName("🔐 Работа со страницей регистрации")
    class LoginPageTest {

        @Nested
        @DisplayName("Позитивные сценарии")
        @Tag("positive")
        @Tag("smoke") // позитивные тесты часто входят в smoke
        class PositiveAuthTests {






    }




























}
