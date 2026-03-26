package gosuslugi_autotests_selenium;

import io.qameta.allure.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@DisplayName("🔐 Работа с главной страницей")
class MainPageTest extends BaseTest {

    @Nested
    @DisplayName("Позитивные сценарии")
    @Tag("positive")
    @Tag("smoke") // позитивные тесты часто входят в smoke
    class PositiveAuthTests {

        @Test
        @DisplayName("Открытие главной страницы https://www.gosuslugi.ru/")
        void test1(TestInfo testInfo) {
            log.info("Выполняется тест: {}", testInfo.getDisplayName());
            log.info("Теги: {}", testInfo.getTags());
            log.info("Класс теста: {}", testInfo.getTestClass().get().getSimpleName());
            log.info("Имя метода: {}", testInfo.getTestMethod().get().getName());
        }
        //====================================================================================================
        @Test
        @DisplayName("Получаем список категории из шапки")
        void test2() {
            log.info("📋 Получаем список категорий из шапки сайта");
            mainPage.getAllCategoryNamesHat();

        }
        //====================================================================================================
        @Test
        @DisplayName("Получаем список категории")
        void modalWindowTest() {
            log.info("📋 Получаем список всех категорий");
            mainPage.getAllCategoryNames();

        }
    }


}

@DisplayName("🔐 Работа с авторизацией")
@Slf4j
class AuthorizationTests extends BaseTest {

    @Nested
    @DisplayName("Позитивные сценарии")
    @Tag("positive")
    @Tag("smoke") // позитивные тесты часто входят в smoke
    class PositiveAuthTests {

        //====================================================================================================
        @Test
        @DisplayName("Ввод корректных данных (логин и пароль)")
        void validCredentialsTest() {
            log.info("🔑 Тест с корректными данными");
            mainPage.clickExtensionsLink()
                    .enterEmail("+79889207429", "Hanafi.07");
            // Добавьте проверку успешного входа
        }
        //====================================================================================================
        @Test
        @DisplayName("Проверка модального окна авторизации")
        void modalWindowTest(TestInfo testInfo) {
            log.info("🪟 Проверка модального окна");
            mainPage.clickExtensionsLink();
            log.info("Тест: {}", testInfo.getDisplayName());
            log.info("Теги: {}", testInfo.getTags());
        }
    }


    //___________________________________________________________________________________________________
    @Nested
    @DisplayName("Негативные сценарии")
    @Tag("negative")
    @Tag("regression") // негативные в регрессию
    class NegativeAuthTests {
        //====================================================================================================
        @DisplayName("Ввод нескольких не правильных логинов и правильный пароль")
        @ParameterizedTest
        @ValueSource(strings = {
                "user1",              // несуществующий пользователь
                "user2",              // другой несуществующий
                " ",                  // пробел
                "",                   // пустая строка
                "very_long_username_that_should_not_exist_in_system_12345",  // очень длинный
                "user@name",          // со спецсимволом
                "1234567890",         // только цифры
                "!@#$%^&*()"          // только спецсимволы
        })
        void invalidLoginValidPasswordTest(String username) {
            log.info("🔍 ТЕСТ с логином: '{}'", username);

            String result = mainPage.clickExtensionsLink()
                    .enterEmail(username, "Hanafi.07")
                    .getErrorText();

            log.info("Результат: {}", result);
            log.info("{}", "─".repeat(50));
            // ✅ Проверяем, что результат не пустой и содержит одно из ожидаемых сообщений
            assertFalse(result.isEmpty(), "Ошибка какая - то есть т.е. одна из трёх вариантов: " + username);
            log.info("✅ Тест пройден\n");
        }

        /*//====================================================================================================
        @DisplayName("Ввод нескольких не правильных паролей и правильный логин")
        @ParameterizedTest
        @ValueSource(strings = {
                "",                       // пустой пароль
                " ",                      // пробел
                "    ",                   // несколько пробелов
                "123",                    // слишком короткий
                "qwerty",                 // простой пароль
                "password",               // стандартный пароль
                "P@ssw0rd",               // похож на правильный, но другой
                "very_long_password_that_exceeds_normal_length_1234567890", // очень длинный
                "!@#$%^",                 // только спецсимволы
                "12345678",               // только цифры
                "abcdefgh",               // только буквы
                "русский",                // кириллица
                "漢字",                    // иероглифы
                "🔥🌍💻",                  // эмодзи
                "',.;:[]{}",              // различные символы
                "пароль",                 // русское слово
                "ADMIN",                   // заглавные буквы
                "admin123",               // типичный простой пароль
                "q1w2e3r4",               // последовательность на клавиатуре
                "1q2w3e4r",               // обратная последовательность
                "!QAZ2wsx",               // комбинация
        })
        void invalidPasswordValidLoginTest(String password) {
            log.info("🔍 ТЕСТ с паролем: '{}'", password);
            log.info("Длина пароля: {} символов", password.length());

            String result = mainPage.clickExtensionsLink()
                    .enterEmail("+79889207429", password)
                    .getErrorText();

            log.info("Результат: {}", result);
            // ✅ Проверяем, что результат не пустой и содержит одно из ожидаемых сообщений
            assertFalse(result.isEmpty(), "Ошибка какая - то есть т.е. одна из трёх вариантов: " + password);
            log.info("✅ Тест пройден\n");
        }*/

        //====================================================================================================
        @DisplayName("Разные логины и пароли")
        @ParameterizedTest
        @CsvSource({
                "user1, pass123, Введите номер телефона, СНИЛС или электронную почту в формате example@elpochta.ru",
                "admin, 12345, Введите номер телефона, СНИЛС или электронную почту в формате example@elpochta.ru",
                "test, qwerty, Введите номер телефона, СНИЛС или электронную почту в формате example@elpochta.ru"
        })
        void testWithDifferentPasswords(String login, String password, String expectedError) {
            // Теперь в метод приходит И логин И пароль!
            log.info("🔍 Тест с логином: '{}' и паролем: '{}'", login, password);
            log.info("Ожидаемая ошибка: {}", expectedError);

            String result = mainPage.clickExtensionsLink().enterEmail(login, password).getErrorText();
            log.info("Результат: {}", result);

            assertTrue(result.contains(expectedError),
                    "Ожидаемая ошибка не найдена в результате: " + result);
            log.info("✅ Тест пройден\n");
        }

    }
}

@Epic("Госуслуги")
@Feature("Модальное окно 'Введите код с картинки'")
@Owner("Команда тестирования")
@Slf4j
class TheCodeFromTheImageTest extends BaseTest{

    @Nested
    @DisplayName("Позитивные сценарии")
    @Tag("positive")
    @Tag("smoke") // позитивные тесты часто входят в smoke
    class PositiveImageTests {

        @DisplayName("Проверка появления капчи после 3х неудачных попыток входа")
        @ParameterizedTest
        @CsvSource({
                "+79889207429, pass123",
                "+79889207429, pass123",
                "+79889207429, pass123"
        })
        void enterTheCodeFromTheImageTest(String login, String password){
            log.info("🔐 Попытка входа {}: {} ", login, password);
            mainPage.clickExtensionsLink().enterEmail(login, password).getErrorText();
        }
    }

}

@Epic("Госуслуги")
@Feature("Модальное окно")
@Owner("Команда тестирования")
@Slf4j
class ModalWindowTest extends BaseTest{

    @Nested
    @DisplayName("Позитивные сценарии")
    @Tag("positive")
    @Tag("smoke")
    @Story("Управление модальным окном")
    class PositiveAuthTests{

        @Test
        @DisplayName("Открытие модального окна")
        @Description("Проверяет возможность открытия модального окна через меню расширений")
        @Severity(SeverityLevel.NORMAL)
        void test1() {
            log.info("🪟 Тест: открытие модального окна");
            mainPage.clickExtensionsLink().openHelpModal();
        }

        @Test
        @DisplayName("Открытие и закрытие модального окна разными способами")
        @Description("Проверяет полный цикл работы с модальным окном: открытие и закрытие через крестик и кнопку")
        @Severity(SeverityLevel.CRITICAL)
        @Story("Закрытие модального окна")
        void test2() {
            log.info("🔄 Тест: полный цикл работы с модальным окном");
            mainPage.clickExtensionsLink().openHelpModal().testModalBothWays();
        }

        @Test
        @DisplayName("Проверка всех ссылок и название этих ссылок в модальном окне")
        @Description("Проверяет наличие и корректность всех ссылок и название этих ссылок в модальном окне помощи")
        @Severity(SeverityLevel.MINOR)
        @Story("Ссылки в модальном окне и название этих ссылок")
        void test3() {
            log.info("🔗 Тест: проверка ссылок в модальном окне");
            mainPage.clickExtensionsLink().openHelpModal().allWebElementHref();
        }

    }

//@Feature - группирует тесты по функциональности @Feature("Модальное окно") - в отчете все тесты с этой аннотацией будут сгруппированы в разделе "Модальное окно"
//@Story - делит Feature на конкретные сценарии - @Story("Управление модальным окном") - позволяет увидеть, какие именно сценарии внутри фичи тестируются
//@Description - подробное описание теста - @Description("Проверяет возможность открытия модального окна через меню расширений") - отображается в отчете как пояснение, что делает тест
//@Severity - важность теста - @Severity(SeverityLevel.CRITICAL) - BLOCKER - блокирующий (критично), CRITICAL - критический, NORMAL - обычный, MINOR - незначительный, TRIVIAL - тривиальный
//@Link - Ссылка на требования/документацию - @Link(name = "Требование", url = "https://...") - в отчете будет кликабельная ссылка
//@Issue - Ссылка на баг в трекере - @Issue("BUG-456") - связывает тест с багом (если тест падает из-за известного бага)
//@TmsLink - Ссылка на тест-кейс в Test Management System - @TmsLink("TC-789") - связывает автоматический тест с ручным тест-кейсом
//
}