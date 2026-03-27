package gosuslugi_autotests_playwright.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import gosuslugi_autotests_playwright.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.example.gosuslugi_playwright.pages.LoginPage;
import org.example.gosuslugi_playwright.pages.MainPage;
import org.example.gosuslugi_playwright.pages.RegistrationPage;
import org.junit.jupiter.api.*;
import java.nio.file.Paths;

@Slf4j
public class AuthTest extends BaseTest {

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
            @DisplayName("Открытие главной страницы https://www.gosuslugi.ru/")
            void test1() {
                log.info("=== Запуск теста test1 ===");
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/test1.png")));
            }

            @Test
            @DisplayName("Получения списка ссылок и название этих ссылок в меню")
            void test2() {
                mainPage.allLocatorText();
            }

            @Test
            @DisplayName("Получение списка ссылок всех услуг и название этих услуг")
            void test3() {
                mainPage.allLocatorTextServices();
            }

            @Test
            @DisplayName("Переход на страницу регистрации")
            void test5() {
                mainPage.clickLoginButton();
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

            @Test
            @DisplayName("Открытые страницы регистрации")
            void test1() {
                log.info("=== Тест: открытие страницы регистрации ===");

                // Открываем страницу
                mainPage.registrationPage();

                // Ждем полной загрузки
                page.waitForLoadState(LoadState.NETWORKIDLE);
                page.waitForTimeout(500); // пауза для анимаций

                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/test1.png")));
            }

            @Test
            @DisplayName("Нажать на кнопку регистрации ")
            void test2() {
                log.info("=== Тест: нажатие кнопки регистрации ===");

                // Открываем страницу и нажимаем кнопку регистрации
                mainPage.registrationPage().buttonRegister();

                // Ждем загрузки после нажатия
                page.waitForLoadState(LoadState.NETWORKIDLE);
                page.waitForTimeout(500);

                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/test2.png")));

                log.info("✅ Кнопка регистрации нажата");
            }

            @Test
            @DisplayName("Окошко первое")
            void test3() {
                log.info("=== Тест: окошко первое ===");

                // Открываем страницу и нажимаем кнопку регистрации
                mainPage.registrationPage().buttonRegister2().buttonRegister3();

                // Ждем загрузки после нажатия
                page.waitForLoadState(LoadState.NETWORKIDLE);
                page.waitForTimeout(500);

                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/test3.png")));

                log.info("✅ На странице регистрации");
            }
        }





    }




























}
