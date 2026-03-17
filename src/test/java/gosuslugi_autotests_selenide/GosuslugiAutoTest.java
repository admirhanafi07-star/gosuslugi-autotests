package gosuslugi_autotests_selenide;

import com.codeborne.selenide.WebDriverRunner;
import org.example.selenide.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.title;

public class GosuslugiAutoTest extends BaseTest {

    @Nested
    @DisplayName("✅ Позитивные тесты")
    @Tag("positive")
    class PositiveTests {

        @Test
        @DisplayName("🔐 Открытие ссылки")
        void test1() {
            // 1. Срабатывает вот этот вызов open("https://www.gosuslugi.ru/");
            // 2. Текущий URL
            System.out.println("📌 Текущий URL: " + WebDriverRunner.url());
        }

        @Test
        @DisplayName("🔐 Получить список элементов")
        void test2() {
            System.out.println("\n🔍 ДИАГНОСТИКА СТРАНИЦЫ");
            System.out.println("══════════════════════════════════════════");
            // 1. Заголовок страницы
            System.out.println("📌 Заголовок: " + title());
            // 2. Поиск элементов по разным селекторам
            System.out.println("\n🔍 ПОИСК ЭЛЕМЕНТОВ:");
            // Поиск по тегу li
            $$("li").shouldHave(sizeGreaterThan(0));
            int liCount = $$("li").size();
            System.out.println("📌 Всего li: " + liCount);
            // Поиск по классу mr-24
            $$(".mr-24").shouldHave(sizeGreaterThan(0));
            int mr24Count = $$(".mr-24").size();
            System.out.println("📌 Элементов с классом mr-24: " + mr24Count);
            // Поиск по классу link-plain
            $$(".link-plain").shouldHave(sizeGreaterThan(0));
            int linkPlainCount = $$(".link-plain").size();
            System.out.println("📌 Элементов с классом link-plain: " + linkPlainCount);
            // Поиск p.link-plain
            $$("p.link-plain").shouldHave(sizeGreaterThan(0));
            int pLinkPlainCount = $$("p.link-plain").size();
            System.out.println("📌 p.link-plain: " + pLinkPlainCount);

        }

        @Test
        @DisplayName("🔐 Получить список элементов")
        void test3() {
            mainPage.printAllElements();
        }


    }
    @Nested
    @DisplayName("❌ Негативные тесты")
    @Tag("negative")
    class NegativeTests {
        // Здесь тесты на то, чего не должно быть
    }

}

class LoginPageTests extends BaseTest {

    @Nested
    @DisplayName("✅ Позитивные сценарии")
    @Tag("positive")
    class PositiveTests {
        @Test
        @DisplayName("🔐 Переход на страницу регистраций")
        void test3() {
            mainPage.clickExtensionLink();
        }
    }

    @Nested
    @DisplayName("❌ Негативные сценарии")
    @Tag("negative")
    class NegativeTests {

        @ParameterizedTest
        @ValueSource(strings = {"wrong", " ", "", "12345"})
        @DisplayName("Неверный пароль вызывает ошибку")
        void invalidPasswordShowsError(String password) {

        }
    }
}